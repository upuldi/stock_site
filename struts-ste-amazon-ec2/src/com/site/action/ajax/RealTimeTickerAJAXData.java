package com.site.action.ajax;

import com.domain.Ticker;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.manager.CompanyTickerManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/23/12
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealTimeTickerAJAXData extends ActionSupport implements ModelDriven {

    private static final Logger log = Logger.getLogger(RealTimeTickerAJAXData.class);
    public static final String PAGE_SUMMERY_URL_CSE = "http://www.cse.lk/companyprofile/home.htm?id=";
    public static final String CUSFONT_BIG_GREEN = "cusfont-big-green";
    public static final String GREEN_UP_PNG = "green-up.png";
    public static final String CUSFONT_GREEN = "cusfont-green";
    public static final String CUSFONT_BIG_RED = "cusfont-big-red";
    public static final String RED_DOWN_PNG = "red-down.png";
    public static final String CUSFONT_RED = "cusfont-red";
    public static final char OPEN_BRACE = '(';
    public static final char CLOSE_BRACE = ')';
    private transient Ticker ticker = new Ticker();
    private transient CompanyTickerManager companyTickerManager;

    public void setCompanyTickerManager(final CompanyTickerManager companyTickerManager) {
        this.companyTickerManager = companyTickerManager;
    }

    @Override
    public Object getModel() {
        return ticker;
    }

    public String fetchTickerData() {

        final String tickerId = companyTickerManager.getCSECompanyIdByCompanyTickerName(ticker.getSymbol());
        ticker = obtainTickerValuesByCSEId(tickerId);
        return SUCCESS;
    }

    private Ticker obtainTickerValuesByCSEId(final String id) {


        log.debug("Process EOD Trading Summery...");
        Ticker ticker = new Ticker();
        try {

            final WebClient webClient = new WebClient();
            webClient.setJavaScriptEnabled(false);
            webClient.setAppletEnabled(false);
            webClient.setCssEnabled(false);

            final String tradeSummeryUrl = PAGE_SUMMERY_URL_CSE + id;
            final HtmlPage page = webClient.getPage(tradeSummeryUrl);
            Iterator<HtmlElement> iteratorHtmlElement = page.getAllHtmlChildElements().iterator();

            final List<HtmlUnorderedList> htmlUnorderedLists = new ArrayList<HtmlUnorderedList>();
            final List<HtmlTable> htmlTables = new ArrayList<HtmlTable>();

            int unorderedListCount = 0;
            int tableCount = 0;
            while (iteratorHtmlElement.hasNext()) {

                HtmlElement currentElement = iteratorHtmlElement.next();

                if (currentElement instanceof HtmlUnorderedList) {

                    if (log.isDebugEnabled()) {
                        log.debug(" Un OrderedList Found  ......................" + unorderedListCount);
                    }
                    HtmlUnorderedList htmlUnorderedList = (HtmlUnorderedList) currentElement;
                    htmlUnorderedLists.add(htmlUnorderedList);
                    unorderedListCount = unorderedListCount + 1;
                }

                if (currentElement instanceof HtmlTable) {

                    if (log.isDebugEnabled()) {
                        log.debug(" Table Found  ......................" + tableCount);
                    }
                    HtmlTable htmlTable = (HtmlTable) currentElement;
                    htmlTables.add(htmlTable);
                    tableCount = tableCount + 1;
                }
            }
            log.debug(" Start Processing Lists");

            /* Set Record Time. */
            final String recordDate = obtainValueComponentFromUL(htmlUnorderedLists.get(0));
            final String symbol = obtainValueComponentFromUL(htmlUnorderedLists.get(1));
            final String getLastTradedPrice = obtainValueComponentFromUL(htmlUnorderedLists.get(3));
            final String change = obtainValueComponentFromUL(htmlUnorderedLists.get(4));
            final String turnover = obtainValueComponentFromUL(htmlUnorderedLists.get(5));
            final String volume = obtainValueComponentFromUL(htmlUnorderedLists.get(6));
            final String trade = obtainValueComponentFromUL(htmlUnorderedLists.get(7));
            final String marketCap = obtainValueComponentFromUL(htmlUnorderedLists.get(8));
            final String marketCapPresent = obtainValueComponentFromUL(htmlUnorderedLists.get(9));
            final String betaASI = obtainValueComponentFromUL(htmlUnorderedLists.get(10));
            final String betaMPI = obtainValueComponentFromUL(htmlUnorderedLists.get(11));

            final HtmlTable tableOne = htmlTables.get(2);
            final String prevClose = tableOne.getRow(0).getCell(1).getTextContent();
            final String closingPrice = tableOne.getRow(1).getCell(1).getTextContent();
            final String allTimeHigh = tableOne.getRow(2).getCell(1).getTextContent();
            final String allTimeLow = tableOne.getRow(3).getCell(1).getTextContent();
            final String wtdTO = tableOne.getRow(4).getCell(1).getTextContent();
            final String mtdTO = tableOne.getRow(5).getCell(1).getTextContent();
            final String ytdTO = tableOne.getRow(6).getCell(1).getTextContent();

            final HtmlTable tableTwo = htmlTables.get(3);
            final String lastTradedPriceRange = tableTwo.getRow(0).getCell(1).getTextContent();
            final String wtdVO = tableTwo.getRow(1).getCell(1).getTextContent();
            final String mtdVO = tableTwo.getRow(2).getCell(1).getTextContent();
            final String ytdVO = tableTwo.getRow(3).getCell(1).getTextContent();

            /* Post Processing */
            if (null != change) {

                final String changeValue = change.substring(0, change.indexOf(OPEN_BRACE));
                final String changePresentage = change.substring(change.indexOf(OPEN_BRACE) + 1, change.indexOf(CLOSE_BRACE));

                ticker.setChange(changeValue);
                ticker.setChangePresentage(changePresentage);

                final Double changeDoubleVal = Double.parseDouble(changeValue);
                if (changeDoubleVal > 0) {
                    ticker.setChangeClass(CUSFONT_BIG_GREEN);
                    ticker.setChangeImage(GREEN_UP_PNG);
                    ticker.setChangeClassPresentage(CUSFONT_GREEN);
                } else {
                    ticker.setChangeClass(CUSFONT_BIG_RED);
                    ticker.setChangeImage(RED_DOWN_PNG);
                    ticker.setChangeClassPresentage(CUSFONT_RED);
                }
            }

            ticker.setRecordTIme(recordDate);
            ticker.setSymbol(symbol);
            ticker.setLastTradedPrice(getLastTradedPrice);
            ticker.setTurnover(turnover);
            ticker.setVolume(volume);
            ticker.setTrade(trade);
            ticker.setMarketCap(marketCap);
            ticker.setMarketCapPresent(marketCapPresent);
            ticker.setBetaAsi(betaASI);
            ticker.setBetaMpi(betaMPI);
            ticker.setPrevClose(prevClose);
            ticker.setClosingPrice(closingPrice);
            ticker.setAllTimeHigh(allTimeHigh);
            ticker.setAllTimeLow(allTimeLow);
            ticker.setToWtd(wtdTO);
            ticker.setToMtd(mtdTO);
            ticker.setToYtd(ytdTO);
            ticker.setLastTradedPriceRange(lastTradedPriceRange);
            ticker.setVolWtd(wtdVO);
            ticker.setVolMtd(mtdVO);
            ticker.setVolYtd(ytdVO);
            //log.debug("Ticker is : " + ticker.toString());

        } catch (Exception e) {
            log.debug(e.getMessage(), e);
        }

        return ticker;
    }

    private String obtainValueComponentFromUL(final HtmlUnorderedList htmlUnorderedList) {

        int count = 0;
        String valueString = null;
        for (HtmlElement htmlElement : htmlUnorderedList.getChildElements()) {

            if (htmlElement instanceof HtmlListItem) {
                HtmlListItem htmlListItem = (HtmlListItem) htmlElement;

                if (count == 1) {
                    valueString = htmlListItem.getTextContent();
                }
                count = count + 1;
            }
        }
        return valueString;
    }


}
