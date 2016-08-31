package com.site.action.ajax;

import com.domain.MarketStatus;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;


import static com.site.action.util.ActionConstents.CALL_COUNT;
import static com.site.action.util.ActionConstents.UTF_8;
import static com.site.action.util.ActionConstents.EQUAL_OP;
import static com.site.action.util.ActionConstents.PAGE;
import static com.site.action.util.ActionConstents.HTTP_SESSION_ID;
import static com.site.action.util.ActionConstents.SCRIPT_SESSION_ID;
import static com.site.action.util.ActionConstents.C0_SCRIPT_NAME;
import static com.site.action.util.ActionConstents.C0_METHOD_NAME;
import static com.site.action.util.ActionConstents.C0_ID;
import static com.site.action.util.ActionConstents.BATCH_ID;
import static com.site.action.util.ActionConstents.HEADER_HTM;
import static com.site.action.util.ActionConstents.AND_OP;
import static com.site.action.util.ActionConstents.ONE;
import static com.site.action.util.ActionConstents.ZERO;

import static com.site.action.util.ActionConstents.HOST;
import static com.site.action.util.ActionConstents.CSE_SITE_URL;
import static com.site.action.util.ActionConstents.ACCEPT;
import static com.site.action.util.ActionConstents.ACCEPT_TYPES;
import static com.site.action.util.ActionConstents.ACCEPT_LANGUAGE;
import static com.site.action.util.ActionConstents.ACCEPT_LANGUAGE_PARAMS;
import static com.site.action.util.ActionConstents.ACCEPT_CHARSET;
import static com.site.action.util.ActionConstents.ACCEPT_CHAR_SET_PARAMS;
import static com.site.action.util.ActionConstents.CONNECTION;
import static com.site.action.util.ActionConstents.KEEP_ALIVE;
import static com.site.action.util.ActionConstents.CONTENT_TYPE;
import static com.site.action.util.ActionConstents.CONTENT_TYPE_PARAMS;
import static com.site.action.util.ActionConstents.REFERER;
import static com.site.action.util.ActionConstents.REFERER_PARAM;
import static com.site.action.util.ActionConstents.CONTENT_LENGTH;
import static com.site.action.util.ActionConstents.CONTENT_LENGTH_PARAM;


/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/11/11
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealtimeMarketStatusData extends ActionSupport implements ModelDriven {

    private static final Logger log = Logger.getLogger(RealtimeMarketStatusData.class);
    public static final String DECIMAL_FORMAT_ONE = "###,###,###,###";
    public static final String DECIMAL_FORMAT_TWO = "############";
    public static final String DECIMAL_FORMAT_REALLY_BIG = "0000.0000000000E00";
    public static final String DECIMAL_FORMAT_REALLY_BIG_TWO = "###,###,###,###.00";
    public static final String POSITIVE_SPLIT_REGEX = "[,]";
    public static final String OPEN_BRACE = "(";
    public static final String CLOSE_BRACE = ")";
    public static final String JSESSION_ID_VAL = "26E1945B4904AB03366074875066448D373";
    public static final String MARKET_DATA_JS = "MarketDataJS";


    private transient MarketStatus marketStatus;

    private static final String marketSummeryUrl = "http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getMarketSummary.dwr";
    private static final String positiveContributorsUrl = "http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getPositiveContributorsCount.dwr";
    private static final String negativeContributorsUrl = "http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getNegativeContributorsCount.dwr";
    private static final String marketSummeryMethodName = "getMarketSummary";
    private static final String positiveContributorsMethodName = "getPositiveContributorsCount";
    private static final String negativeContributorsMethodName = "getNegativeContributorsCount";


    public String fetchRTIndexData() {

        boolean debugEnabledStatus = log.isDebugEnabled();

        try {

            final StringBuilder completeResponseMarketSummery = obtainCSEDataString(marketSummeryUrl, marketSummeryMethodName);
            final String completeResponseString = completeResponseMarketSummery.toString();
            final String valuesSection = completeResponseString.substring(completeResponseString.indexOf('{'), completeResponseString.indexOf('}'));

            if (debugEnabledStatus) {
                log.debug("Values Section : " + valuesSection);
            }

            final String[] springArray = valuesSection.split("[,]");

            int count = 0;
            for (String s : springArray) {
                log.debug(count + " : " + s);
                count = count + 1;
            }

            String volumeValue = springArray[0].substring(springArray[0].indexOf(':') + 1, springArray[0].length());
            NumberFormat withOutdecimalPoint = new DecimalFormat(DECIMAL_FORMAT_ONE);
            NumberFormat bigNumber = new DecimalFormat(DECIMAL_FORMAT_TWO);
            volumeValue = withOutdecimalPoint.format(bigNumber.parse(volumeValue));
            if (debugEnabledStatus) {
                log.debug("Volume Value " + volumeValue);
            }

            final String turnOverValue = springArray[1].substring(springArray[0].indexOf(":"), springArray[1].length());
            if (debugEnabledStatus) {
                log.debug("turnOverValue " + turnOverValue);
            }

            NumberFormat f = new DecimalFormat(DECIMAL_FORMAT_REALLY_BIG);
            NumberFormat other = new DecimalFormat(DECIMAL_FORMAT_REALLY_BIG_TWO);
            String formattedTurnoverValue = other.format(f.parse(turnOverValue).doubleValue());
            if (debugEnabledStatus) {
                log.debug("turnOverValue " + formattedTurnoverValue);
            }

            //-----------------------------------------

            StringBuilder completeResponsePositiveContributors = obtainCSEDataString(positiveContributorsUrl, positiveContributorsMethodName);
            if (debugEnabledStatus) {
                log.debug(" POSITIVE CONTRIBUTION  " + completeResponsePositiveContributors);
            }

            String valueSectionPositive = completeResponsePositiveContributors.substring(
                    completeResponsePositiveContributors.indexOf(OPEN_BRACE), completeResponsePositiveContributors.indexOf(CLOSE_BRACE));


            if (debugEnabledStatus) {
                log.debug("Value Section 2 " + valueSectionPositive);
            }
            String[] positiveValuesArray = valueSectionPositive.split(POSITIVE_SPLIT_REGEX);

            if (debugEnabledStatus) {
                log.debug("POSITIVE Value is : " + positiveValuesArray[2]);
            }
            final String positiveContributorsValue = positiveValuesArray[2];


            //-----------------------------------------

            StringBuilder completeResponseNegativeContributors = obtainCSEDataString(negativeContributorsUrl, negativeContributorsMethodName);
            if (debugEnabledStatus) {
                log.debug(" NEGATIVE CONTRIBUTION " + completeResponseNegativeContributors);
            }

            String valueSectionNegative = completeResponseNegativeContributors.substring(
                    completeResponseNegativeContributors.indexOf(OPEN_BRACE), completeResponseNegativeContributors.indexOf(CLOSE_BRACE));

            if (debugEnabledStatus) {
                log.debug("Value Section Negative " + valueSectionNegative);
            }
            String[] negativeValuesArray = valueSectionNegative.split("[,]");

            if (debugEnabledStatus) {
                log.debug("Negative Value is : " + negativeValuesArray[2]);
            }
            final String negativeContributorsValue = negativeValuesArray[2];

            marketStatus = new MarketStatus();
            marketStatus.setTurnover(formattedTurnoverValue);
            marketStatus.setVolume(volumeValue);
            marketStatus.setPositiveContributors(positiveContributorsValue);
            marketStatus.setNegativeContributors(negativeContributorsValue);


        } catch (Exception e) {
            log.error("Exception Occured ...... " + e.getMessage());
        }

        return SUCCESS;
    }

    private StringBuilder obtainCSEDataString(final String url, final String methodName) throws IOException {

        boolean debugEnabledStatus = log.isDebugEnabled();

        StringBuffer data = new StringBuffer(URLEncoder.encode(CALL_COUNT, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));
        data.append(AND_OP + URLEncoder.encode(PAGE, UTF_8) + EQUAL_OP + URLEncoder.encode(HEADER_HTM, UTF_8));
        data.append(AND_OP + URLEncoder.encode(HTTP_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("", UTF_8));
        data.append(AND_OP + URLEncoder.encode(SCRIPT_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(JSESSION_ID_VAL, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_SCRIPT_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(MARKET_DATA_JS, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_METHOD_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(methodName, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ZERO, UTF_8));
        data.append(AND_OP + URLEncoder.encode(BATCH_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));

        final URL urlMarketSummery = new URL(url);
        final URLConnection conn = urlMarketSummery.openConnection();
        conn.setDoOutput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty(HOST, CSE_SITE_URL);
        conn.setRequestProperty(ACCEPT, ACCEPT_TYPES);
        conn.setRequestProperty(ACCEPT_LANGUAGE, ACCEPT_LANGUAGE_PARAMS);
        conn.setRequestProperty(ACCEPT_CHARSET, ACCEPT_CHAR_SET_PARAMS);
        conn.setRequestProperty(CONNECTION, KEEP_ALIVE);
        conn.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE_PARAMS);
        conn.setRequestProperty(REFERER, REFERER_PARAM);
        conn.setRequestProperty(CONTENT_LENGTH, CONTENT_LENGTH_PARAM);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data.toString().trim().toCharArray());
        wr.flush();

        int status = ((HttpURLConnection) conn).getResponseCode();
        if (debugEnabledStatus) {
            log.debug("Response Status : " + status);
        }

        /* Display Response Headers. */
        Map<String, List<String>> k = ((HttpURLConnection) conn).getHeaderFields();
        for (Map.Entry<String, List<String>> e : k.entrySet()) {

            if (debugEnabledStatus) {
                log.debug("Header Key " + e.getKey());
            }
            for (String s : e.getValue()) {
                if (debugEnabledStatus) {
                    log.debug("Values" + s);
                }
            }
        }

        // Get the response
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder completeResponse = new StringBuilder();


        while ((line = rd.readLine()) != null) {
            //log.debug(line);
            completeResponse.append(line);
        }

        wr.close();
        rd.close();

        if (debugEnabledStatus) {
            log.debug("Complete Response : " + completeResponse.toString());
        }
        return completeResponse;
    }

    public void setMarketStatus(MarketStatus marketStatus) {
        this.marketStatus = marketStatus;
    }

    public Object getModel() {
        return marketStatus;
    }
}

