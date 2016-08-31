package com.site.action.ajax;

import com.domain.RTIndexValues;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/5/11
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class RealtimeIndexAJAXData extends ActionSupport implements ModelDriven {

    private static final Logger log = Logger.getLogger(RealtimeIndexAJAXData.class);
    public static final String ACTION_URL = "http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getIndicesToday.dwr";
    public static final String MARKET_DATA_JS = "MarketDataJS";
    public static final String GET_INDICES_TODAY = "getIndicesToday";
    public static final String JSESSION_ID = "26E1945B4904AB03366074875066448D373";


    public static final String S2_V = "s2.v";
    public static final String ID = ".id";
    public static final String ID_1 = ".id=1";
    public static final String DOT_V_EQUAL = ".v=";
    public static final String DOT_C_EQUAL = ".c=";
    public static final String DOT_P_EQUAL = ".p=";
    public static final String DOT_ID_EQUAL = ".id";
    public static final String DOT_ID_EQUAL_41 = ".id=41";
    public static final String DECI_PATTERN_ONE = "##0.00;-##0.00";
    public static final String DECI_PATTERN_TWO = "###.##";
    public static final String CUSFONT_GREEN = "cusfont-green";
    public static final String GREEN_UP_PNG = "green-up.png";
    public static final String CUSFONT_RED = "cusfont-red";
    public static final String RED_DOWN_PNG = "red-down.png";


    private transient RTIndexValues rtIndexValues;


    public String getRTIndexDataOLD() {

        try {

//            String data = URLEncoder.encode("callCount", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
//            data += "&" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("/header.htm", "UTF-8");
//            data += "&" + URLEncoder.encode("httpSessionId", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8");
//            data += "&" + URLEncoder.encode("scriptSessionId", "UTF-8") + "=" + URLEncoder.encode("26E1945B4904AB03366074875066448D373", "UTF-8");
//            data += "&" + URLEncoder.encode("c0-scriptName", "UTF-8") + "=" + URLEncoder.encode("MarketDataJS", "UTF-8");
//            data += "&" + URLEncoder.encode("c0-methodName", "UTF-8") + "=" + URLEncoder.encode("getIndicesToday", "UTF-8");
//            data += "&" + URLEncoder.encode("c0-id", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");
//            data += "&" + URLEncoder.encode("batchId", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");

            StringBuffer data2 = new StringBuffer(URLEncoder.encode(CALL_COUNT, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(PAGE, UTF_8) + EQUAL_OP + URLEncoder.encode(HEADER_HTM, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(HTTP_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("", UTF_8));
            data2.append(AND_OP + URLEncoder.encode(SCRIPT_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(JSESSION_ID, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(C0_SCRIPT_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(MARKET_DATA_JS, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(C0_METHOD_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(GET_INDICES_TODAY, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(C0_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ZERO, UTF_8));
            data2.append(AND_OP + URLEncoder.encode(BATCH_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));

//            log.debug("CHECK EQUAL TEST ");
//            if (data.equals(data2)) {
//                log.debug("EQUAL YO");
//
//            }


            URL url = new URL("http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getIndicesToday.dwr");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setDoOutput(true);

//            conn.setRequestProperty("Host", "www.cse.lk");
//            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//            conn.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
//            conn.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
//            conn.setRequestProperty("Connection", "keep-alive");
//            conn.setRequestProperty("Content-Type", "text/plain; charset=UTF-8");
//            conn.setRequestProperty("Referer", "http://www.cse.lk/header.htm");
//            conn.setRequestProperty("Content-Length", "171");

            conn.setRequestProperty(HOST, CSE_SITE_URL);
            conn.setRequestProperty(ACCEPT, ACCEPT_TYPES);
            conn.setRequestProperty(ACCEPT_LANGUAGE, ACCEPT_LANGUAGE_PARAMS);
            conn.setRequestProperty(ACCEPT_CHARSET, ACCEPT_CHAR_SET_PARAMS);
            conn.setRequestProperty(CONNECTION, KEEP_ALIVE);
            conn.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE_PARAMS);
            conn.setRequestProperty(REFERER, REFERER_PARAM);
            conn.setRequestProperty(CONTENT_LENGTH, CONTENT_LENGTH_PARAM);

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data2.toString().trim().toCharArray());
            wr.flush();

            int status = ((HttpURLConnection) conn).getResponseCode();
            log.debug("Response Status : " + status);

            /* Display Response Headers. */
            Map<String, List<String>> k = ((HttpURLConnection) conn).getHeaderFields();
            for (Map.Entry<String, List<String>> e : k.entrySet()) {

                log.debug("Header Key " + e.getKey());
                for (String s : e.getValue()) {
                    log.debug("Values" + s);
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

            log.debug("Complete Response : " + completeResponse.toString());

            String completeResponseString = completeResponse.toString();

            String[] springArray = completeResponseString.split("[;]");

            int count = 0;
            int countASPI = 0;
            int countMPI = 0;
            String aspiValueContainingString = null;
            String mpiValueContainingString = null;
            String aspiChangeContainingString = null;
            String aspiPresentageContainingString = null;
            String aspiValue = null;
            String aspiChange = null;
            String aspiChangePresentage = null;
            String aspiBlock = null;

            String mpiValue = null;
            String mpiChange = null;
            String mpiChangePresentage = null;
            String mpiBlock = null;
            String mpiChangeContainingString = null;
            String miPresentageContainingString = null;

            for (String s : springArray) {

                log.debug(count + " : " + s);

                if (s.contains("s2.v")) {
                    log.debug("MPI FOUND : " + s);

                }
                if ((s.contains(".id")) && (s.substring(s.indexOf("."), s.length()).equalsIgnoreCase(".id=1"))) {
                    log.debug("ASPI BLOCK FOUND : " + s);
                    countASPI = count;
                    aspiBlock = s.substring(0, s.indexOf("."));
                    aspiValueContainingString = s.substring(0, s.indexOf(".")) + ".v=";
                    aspiChangeContainingString = s.substring(0, s.indexOf(".")) + ".c=";
                    aspiPresentageContainingString = s.substring(0, s.indexOf(".")) + ".p=";
                }
                if (null != aspiValueContainingString && s.contains(aspiValueContainingString)) {
                    log.debug("ASPI STRING FOUND : " + s);
                    aspiValue = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("ASPI VALUE : " + aspiValue);
                }
                if (null != aspiPresentageContainingString && s.contains(aspiPresentageContainingString)) {
                    log.debug("ASPI CHANGE PRESENTAGE STRING FOUND : " + s);
                    aspiChangePresentage = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("ASPI CHANGE PRESENTAGE : " + aspiChangePresentage);
                }


                if ((s.contains(".id")) && (s.substring(s.indexOf("."), s.length()).equalsIgnoreCase(".id=41"))) {
                    countMPI = count;
                    log.debug("MPI BLOCK FOUND : " + s);
                    mpiBlock = s.substring(0, s.indexOf("."));
                    mpiValueContainingString = s.substring(0, s.indexOf(".")) + ".v=";
                    mpiChangeContainingString = s.substring(0, s.indexOf(".")) + ".c=";
                    miPresentageContainingString = s.substring(0, s.indexOf(".")) + ".p=";
                }
                if (null != mpiValueContainingString && s.contains(mpiValueContainingString)) {
                    log.debug("MPI STRING FOUND : " + s);
                    mpiValue = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("MPI VALUE : " + mpiValue);
                }
                if (null != miPresentageContainingString && s.contains(miPresentageContainingString)) {
                    log.debug("MPI CHANGE PRESENTAGE STRING FOUND : " + s);
                    mpiChangePresentage = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("MPI CHANGE PRESENTAGE : " + mpiChangePresentage);
                }


                count = count + 1;
            }

            log.debug("ASPI VALUE : " + aspiValue);
            log.debug("MPI VALUE : " + mpiValue);

            for (int i = countASPI; i >= countASPI - 5; i--) {

                String s = springArray[i];

                if (null != aspiChangeContainingString && s.contains(aspiChangeContainingString)) {
                    log.debug("ASPI CHANGE STRING FOUND : " + s);
                    aspiChange = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("ASPI CHANGE : " + aspiChange);
                }
            }
            for (int i = countMPI; i >= countMPI - 5; i--) {

                String s = springArray[i];

                if (null != mpiChangeContainingString && s.contains(mpiChangeContainingString)) {
                    log.debug("MPI CHANGE STRING FOUND : " + s);
                    mpiChange = s.substring(s.indexOf("=") + 1, s.length());
                    log.debug("MPI CHANGE : " + mpiChange);
                }
            }

            DecimalFormat df = new DecimalFormat("#.##");

            DecimalFormat pattern = new DecimalFormat("##0.00;-##0.00");
            DecimalFormat decimalFormatTwo = new DecimalFormat("###.##");


            rtIndexValues = new RTIndexValues();
            rtIndexValues.setASPI(aspiValue);
            rtIndexValues.setMPI(mpiValue);

            double aspiChangeDoubleValue = pattern.parse(aspiChange).doubleValue();
            String aspiChangeClass = null;

            if (aspiChangeDoubleValue >= 0) {
                aspiChangeClass = "cusfont-green";
                rtIndexValues.setAspiImage("green-up.png");
            } else {
                aspiChangeClass = "cusfont-red";
                rtIndexValues.setAspiImage("red-down.png");
            }


            rtIndexValues.setAspiChange(decimalFormatTwo.format(aspiChangeDoubleValue));
            rtIndexValues.setAspiChangeClass(aspiChangeClass);
            rtIndexValues.setAspiChangePresentage(decimalFormatTwo.format(pattern.parse(aspiChangePresentage)));


            double mpiChangeDoubleValue = pattern.parse(mpiChange).doubleValue();
            String mpiChangeClass = null;

            if (mpiChangeDoubleValue >= 0) {
                mpiChangeClass = "cusfont-green";
                rtIndexValues.setMpiImage("green-up.png");
            } else {
                mpiChangeClass = "cusfont-red";
                rtIndexValues.setMpiImage("red-down.png");
            }

            rtIndexValues.setMpiChange(decimalFormatTwo.format(mpiChangeDoubleValue));
            rtIndexValues.setMpiChangeClass(mpiChangeClass);
            rtIndexValues.setMpiChangePresentage(decimalFormatTwo.format(pattern.parse(mpiChangePresentage)));


        } catch (Exception e) {
            log.error("Exception Occured ...... " + e.getMessage());
        }

        return SUCCESS;
    }

    public String fetchRTIndexData() {

        final boolean debugEnabledStatus = log.isDebugEnabled();

        try {

            StringBuffer data = new StringBuffer(URLEncoder.encode(CALL_COUNT, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));
            data.append(AND_OP + URLEncoder.encode(PAGE, UTF_8) + EQUAL_OP + URLEncoder.encode(HEADER_HTM, UTF_8));
            data.append(AND_OP + URLEncoder.encode(HTTP_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("", UTF_8));
            data.append(AND_OP + URLEncoder.encode(SCRIPT_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(JSESSION_ID, UTF_8));
            data.append(AND_OP + URLEncoder.encode(C0_SCRIPT_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(MARKET_DATA_JS, UTF_8));
            data.append(AND_OP + URLEncoder.encode(C0_METHOD_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(GET_INDICES_TODAY, UTF_8));
            data.append(AND_OP + URLEncoder.encode(C0_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ZERO, UTF_8));
            data.append(AND_OP + URLEncoder.encode(BATCH_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(ONE, UTF_8));

            final URL url = new URL(ACTION_URL);
            URLConnection conn = url.openConnection();
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


            final OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data.toString().trim().toCharArray());
            wr.flush();

            int status = ((HttpURLConnection) conn).getResponseCode();
            if (debugEnabledStatus) {
                log.debug("Response Status : " + status);
            }

            /* Display Response Headers. */
            final Map<String, List<String>> k = ((HttpURLConnection) conn).getHeaderFields();
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
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder completeResponse = new StringBuilder();

            try {
                StringBuffer line;
                if (null != rd) {
                    while ((line = new StringBuffer(rd.readLine())) != null) {
                        completeResponse.append(line);
                    }
                }
            } catch (NullPointerException e) {
                if (debugEnabledStatus) {
                    log.error("NUll Pointer Occured " ,e);
                }
            }

            wr.close();
            rd.close();

            if (debugEnabledStatus) {
                log.debug("Complete Response : " + completeResponse.toString());
            }

            String completeResponseString = completeResponse.toString();
            final String[] springArray = completeResponseString.split("[;]");

            int count = 0;
            int countASPI = 0;
            int countMPI = 0;
            String aspiValueContainingString = null;
            String mpiValueContainingString = null;
            String aspiChangeContainingString = null;
            String aspiPresentageContainingString = null;
            String aspiValue = null;
            String aspiChange = null;
            String aspiChangePresentage = null;
            String aspiBlock = null;

            String mpiValue = null;
            String mpiChange = null;
            String mpiChangePresentage = null;
            String mpiBlock = null;
            String mpiChangeContainingString = null;
            String miPresentageContainingString = null;

            for (String s : springArray) {

                if (debugEnabledStatus) {
                    log.debug(count + " : " + s);
                }

                if (s.contains(S2_V)) {
                    if (debugEnabledStatus) {
                        log.debug("MPI FOUND : " + s);
                    }

                }
                if ((s.contains(ID)) && (s.substring(s.indexOf("."), s.length()).equalsIgnoreCase(ID_1))) {
                    if (debugEnabledStatus) {
                        log.debug("ASPI BLOCK FOUND : " + s);
                    }
                    countASPI = count;
                    aspiBlock = s.substring(0, s.indexOf("."));
                    aspiValueContainingString = s.substring(0, s.indexOf('.')) + DOT_V_EQUAL;
                    aspiChangeContainingString = s.substring(0, s.indexOf('.')) + DOT_C_EQUAL;
                    aspiPresentageContainingString = s.substring(0, s.indexOf(".")) + DOT_P_EQUAL;
                }
                if (null != aspiValueContainingString && s.contains(aspiValueContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("ASPI STRING FOUND : " + s);
                    }
                    aspiValue = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("ASPI VALUE : " + aspiValue);
                    }
                }
                if (null != aspiPresentageContainingString && s.contains(aspiPresentageContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("ASPI CHANGE PRESENTAGE STRING FOUND : " + s);
                    }
                    aspiChangePresentage = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("ASPI CHANGE PRESENTAGE : " + aspiChangePresentage);
                    }
                }

                if ((s.contains(DOT_ID_EQUAL)) && (s.substring(s.indexOf("."), s.length()).equalsIgnoreCase(DOT_ID_EQUAL_41))) {
                    countMPI = count;
                    if (debugEnabledStatus) {
                        log.debug("MPI BLOCK FOUND : " + s);
                    }
                    mpiBlock = s.substring(0, s.indexOf("."));
                    mpiValueContainingString = s.substring(0, s.indexOf(".")) + DOT_V_EQUAL;
                    mpiChangeContainingString = s.substring(0, s.indexOf(".")) + DOT_C_EQUAL;
                    miPresentageContainingString = s.substring(0, s.indexOf(".")) + DOT_P_EQUAL;
                }
                if (null != mpiValueContainingString && s.contains(mpiValueContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("MPI STRING FOUND : " + s);
                    }
                    mpiValue = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("MPI VALUE : " + mpiValue);
                    }
                }
                if (null != miPresentageContainingString && s.contains(miPresentageContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("MPI CHANGE PRESENTAGE STRING FOUND : " + s);
                    }
                    mpiChangePresentage = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("MPI CHANGE PRESENTAGE : " + mpiChangePresentage);
                    }
                }
                count = count + 1;
            }

            if (debugEnabledStatus) {
                log.debug("ASPI VALUE : " + aspiValue);
                log.debug("MPI VALUE : " + mpiValue);
            }

            for (int i = countASPI; i >= countASPI - 5; i--) {

                String s = springArray[i];

                if (null != aspiChangeContainingString && s.contains(aspiChangeContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("ASPI CHANGE STRING FOUND : " + s);
                    }
                    aspiChange = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("ASPI CHANGE : " + aspiChange);
                    }
                }
            }
            for (int i = countMPI; i >= countMPI - 5; i--) {

                String s = springArray[i];

                if (null != mpiChangeContainingString && s.contains(mpiChangeContainingString)) {
                    if (debugEnabledStatus) {
                        log.debug("MPI CHANGE STRING FOUND : " + s);
                    }
                    mpiChange = s.substring(s.indexOf(EQUAL_OP) + 1, s.length());
                    if (debugEnabledStatus) {
                        log.debug("MPI CHANGE : " + mpiChange);
                    }
                }
            }

            DecimalFormat pattern = new DecimalFormat(DECI_PATTERN_ONE);
            DecimalFormat decimalFormatTwo = new DecimalFormat(DECI_PATTERN_TWO);

            rtIndexValues = new RTIndexValues();
            rtIndexValues.setASPI(aspiValue);
            rtIndexValues.setMPI(mpiValue);

            double aspiChangeDoubleValue = pattern.parse(aspiChange).doubleValue();
            String aspiChangeClass = null;

            if (aspiChangeDoubleValue >= 0) {
                aspiChangeClass = CUSFONT_GREEN;
                rtIndexValues.setAspiImage(GREEN_UP_PNG);
            } else {
                aspiChangeClass = CUSFONT_RED;
                rtIndexValues.setAspiImage(RED_DOWN_PNG);
            }

            rtIndexValues.setAspiChange(decimalFormatTwo.format(aspiChangeDoubleValue));
            rtIndexValues.setAspiChangeClass(aspiChangeClass);
            rtIndexValues.setAspiChangePresentage(decimalFormatTwo.format(pattern.parse(aspiChangePresentage)));

            double mpiChangeDoubleValue = pattern.parse(mpiChange).doubleValue();
            String mpiChangeClass = null;

            if (mpiChangeDoubleValue >= 0) {
                mpiChangeClass = CUSFONT_GREEN;
                rtIndexValues.setMpiImage(GREEN_UP_PNG);
            } else {
                mpiChangeClass = CUSFONT_RED;
                rtIndexValues.setMpiImage(RED_DOWN_PNG);
            }

            rtIndexValues.setMpiChange(decimalFormatTwo.format(mpiChangeDoubleValue));
            rtIndexValues.setMpiChangeClass(mpiChangeClass);
            rtIndexValues.setMpiChangePresentage(decimalFormatTwo.format(pattern.parse(mpiChangePresentage)));

        } catch (Exception e) {
            log.error("Exception Occured ...... " + e);
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public Object getModel() {
        return rtIndexValues;
    }
}

