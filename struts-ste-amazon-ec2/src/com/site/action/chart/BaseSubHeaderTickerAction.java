package com.site.action.chart;

import com.domain.EODData;
import com.domain.Ticker;
import com.manager.CSEListedCompanyManager;
import com.manager.EODDataManager;
import com.opensymphony.xwork2.ActionSupport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 10/3/13
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseSubHeaderTickerAction extends ActionSupport {

    private String selectedLink;
    private boolean showChart = false;
    private List<String> stockCodes;
    private CSEListedCompanyManager cseListedCompanyManager;

    private boolean showTable = false;
    private boolean showSubheader = false;
    private EODData eodData;
    private Ticker ticker;
    private String closeClass;
    private String change;
    private String changeClass;
    private String changeClassPresentage;
    private String changePresentage;
    private String imageLink;
    private String formatedVolume;
    private String formatedTrades;
    protected EODDataManager eodDataManager;
    private String dateString;

    private boolean showVolChart = false;
    private String ajaxPieChartJSONString;
    long volToday;
    long restVolWeek;

    public long getVolToday() {
        return volToday;
    }

    public void setVolToday(long volToday) {
        this.volToday = volToday;
    }

    public long getRestVolWeek() {
        return restVolWeek;
    }

    public void setRestVolWeek(long restVolWeek) {
        this.restVolWeek = restVolWeek;
    }

    public boolean isShowVolChart() {
        return showVolChart;
    }

    public void setShowVolChart(boolean showVolChart) {
        this.showVolChart = showVolChart;
    }

    public String getAjaxPieChartJSONString() {
        return ajaxPieChartJSONString;
    }

    public void setAjaxPieChartJSONString(String ajaxPieChartJSONString) {
        this.ajaxPieChartJSONString = ajaxPieChartJSONString;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }


    public void setEodDataManager(EODDataManager eodDataManager) {
        this.eodDataManager = eodDataManager;
    }

    public boolean isShowTable() {
        return showTable;
    }

    public void setShowTable(boolean showTable) {
        this.showTable = showTable;
    }

    public boolean isShowSubheader() {
        return showSubheader;
    }

    public void setShowSubheader(boolean showSubheader) {
        this.showSubheader = showSubheader;
    }

    public EODData getEodData() {
        return eodData;
    }

    public void setEodData(EODData eodData) {
        this.eodData = eodData;
    }

    public String getCloseClass() {
        return closeClass;
    }

    public void setCloseClass(String closeClass) {
        this.closeClass = closeClass;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangeClass() {
        return changeClass;
    }

    public void setChangeClass(String changeClass) {
        this.changeClass = changeClass;
    }

    public String getChangeClassPresentage() {
        return changeClassPresentage;
    }

    public void setChangeClassPresentage(String changeClassPresentage) {
        this.changeClassPresentage = changeClassPresentage;
    }

    public String getChangePresentage() {
        return changePresentage;
    }

    public void setChangePresentage(String changePresentage) {
        this.changePresentage = changePresentage;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getFormatedVolume() {
        return formatedVolume;
    }

    public void setFormatedVolume(String formatedVolume) {
        this.formatedVolume = formatedVolume;
    }

    public String getFormatedTrades() {
        return formatedTrades;
    }

    public void setFormatedTrades(String formatedTrades) {
        this.formatedTrades = formatedTrades;
    }

    public String getSelectedLink() {
        return selectedLink;
    }

    public void setSelectedLink(String selectedLink) {
        this.selectedLink = selectedLink;
    }

    public boolean isShowChart() {
        return showChart;
    }

    public void setShowChart(boolean showChart) {
        this.showChart = showChart;
    }

    public List<String> getStockCodes() {
        return stockCodes;
    }

    public void setStockCodes(List<String> stockCodes) {
        this.stockCodes = stockCodes;
    }

    public void setCseListedCompanyManager(CSEListedCompanyManager cseListedCompanyManager) {
        this.cseListedCompanyManager = cseListedCompanyManager;
    }

    private void init(String selectedLink) {
        selectedLink = selectedLink;
        stockCodes = cseListedCompanyManager.getCSEStockCodes();
    }

    protected void inputDataConfig(String selectedLink) {
        init(selectedLink);
        showChart = false;
        eodData = null;
        showSubheader = false;
        showTable = false;
    }

    protected void submitDataConfig(String selectedLink,String stockCode) {

        try {
            init(selectedLink);

            if (null != stockCode) {
                showChart = true;
            }

            EODData eodData = eodDataManager.getLatestEODDataForStock(stockCode);
            NumberFormat numberFormat = NumberFormat.getInstance();

            if (null != eodData) {

                this.eodData = eodData;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                dateString = simpleDateFormat.format(eodData.getDate());

                formatedVolume = numberFormat.format(eodData.getVol());
                formatedTrades = eodData.getTrade();


                if (null != eodData.getChange() && null != eodData.getChangePresentage()) {

                    change = eodData.getChange();
                    changePresentage = eodData.getChangePresentage();

                } else {

                    double openVal = numberFormat.parse(eodData.getOpen()).doubleValue();
                    double closeVal = numberFormat.parse(eodData.getClose()).doubleValue();
                    double changeVal = closeVal - openVal;
                    double changePresentageVal = (changeVal / openVal) * 100;

                    BigDecimal bdChange = new BigDecimal(changeVal).setScale(2, RoundingMode.HALF_EVEN);
                    double changeRounded = bdChange.doubleValue();

                    BigDecimal bdChangePresent = new BigDecimal(changePresentageVal).setScale(2, RoundingMode.HALF_EVEN);
                    double changePresentageDbRounded = bdChangePresent.doubleValue();


                    change = changeRounded + "";
                    changePresentage = changePresentageDbRounded + "";
                }

                if (null == change || change.isEmpty()) {
                    change = "0";
                    changePresentage = "0";
                }

                if (Double.parseDouble(change) >= 0) {
                    changeClass = "cusfont-big-green";
                    changeClassPresentage = "cusfont-green";
                    imageLink = "green-up.png";
                } else {
                    changeClass = "cusfont-big-red";
                    changeClassPresentage = "cusfont-red";
                    imageLink = "red-down.png";
                }

                showSubheader = true;
                showTable = true;
            }

            Ticker ticker = cseListedCompanyManager.getTickerBySymbol(stockCode);
            this.ticker = ticker;

            /* Volume Data */
            String tickerVolWTD = ticker.getVolWtd();
            if (null != ticker.getVolWtd()) {
                DecimalFormat df2 = new DecimalFormat( "#,###,###,###" );
                Long tickerVolWtd = df2.parse(ticker.getVolWtd().replace(" ","0")).longValue();
                if (tickerVolWtd > 0 && eodData.getVol() > 0 ) {

                    volToday = eodData.getVol();
                    restVolWeek = tickerVolWtd - volToday;
                    showVolChart = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
