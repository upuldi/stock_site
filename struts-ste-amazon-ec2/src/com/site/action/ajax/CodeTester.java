package com.site.action.ajax;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/25/12
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeTester {
    
    static Logger log = Logger.getLogger(CodeTester.class);


    public static final String CALL_COUNT = "callCount";
    public static final String UTF_8 = "UTF-8";
    public static final String EQUAL_OP = "=";
    public static final String PAGE = "page";
    public static final String ACTION_URL = "http://www.cse.lk/dwr/call/plaincall/MarketDataJS.getIndicesToday.dwr";
    public static final String HTTP_SESSION_ID = "httpSessionId";
    public static final String SCRIPT_SESSION_ID = "scriptSessionId";
    public static final String C0_SCRIPT_NAME = "c0-scriptName";
    public static final String C0_METHOD_NAME = "c0-methodName";
    public static final String C0_ID = "c0-id";
    public static final String BATCH_ID = "batchId";
    public static final String MARKET_DATA_JS = "MarketDataJS";
    public static final String GET_INDICES_TODAY = "getIndicesToday";
    public static final String HEADER_HTM = "/header.htm";
    public static final String JSESSION_ID = "26E1945B4904AB03366074875066448D373";
    public static final String AND_OP = "&";


    public static final String HOST = "Host";
    public static final String CSE_SITE_URL = "www.cse.lk";
    public static final String ACCEPT = "Accept";
    public static final String ACCEPT_TYPES = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String ACCEPT_LANGUAGE_PARAMS = "en-us,en;q=0.5";
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    public static final String ACCEPT_CHAR_SET_PARAMS = "ISO-8859-1,utf-8;q=0.7,*;q=0.7";
    public static final String CONNECTION = "Connection";
    public static final String KEEP_ALIVE = "keep-alive";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_PARAMS = "text/plain; charset=UTF-8";
    public static final String REFERER = "Referer";
    public static final String REFERER_PARAM = "http://www.cse.lk/header.htm";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LENGTH_PARAM = "171";

    public static void main (String []args) throws UnsupportedEncodingException {



        log.debug("starting");


        String data = URLEncoder.encode(CALL_COUNT, UTF_8) + EQUAL_OP + URLEncoder.encode("1", UTF_8);
        data += AND_OP + URLEncoder.encode(PAGE, UTF_8) + EQUAL_OP + URLEncoder.encode(HEADER_HTM, UTF_8);
        data += AND_OP + URLEncoder.encode(HTTP_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("", UTF_8);
        data += AND_OP + URLEncoder.encode(SCRIPT_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(JSESSION_ID, UTF_8);
        data += AND_OP + URLEncoder.encode(C0_SCRIPT_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(MARKET_DATA_JS, UTF_8);
        data += AND_OP + URLEncoder.encode(C0_METHOD_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(GET_INDICES_TODAY, UTF_8);
        data += AND_OP + URLEncoder.encode(C0_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("0", UTF_8);
        data += AND_OP + URLEncoder.encode(BATCH_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("1", UTF_8);




        log.debug("String VAL " + data);
        log.debug("String Buffer");

        SB();


        
        
        
        
    }

    private static void SB() throws UnsupportedEncodingException {

        StringBuffer data = new StringBuffer(URLEncoder.encode(CALL_COUNT, UTF_8) + EQUAL_OP + URLEncoder.encode("1", UTF_8));
        data.append(AND_OP + URLEncoder.encode(PAGE, UTF_8) + EQUAL_OP + URLEncoder.encode(HEADER_HTM, UTF_8));
        data.append(AND_OP + URLEncoder.encode(HTTP_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("", UTF_8));
        data.append(AND_OP + URLEncoder.encode(SCRIPT_SESSION_ID, UTF_8) + EQUAL_OP + URLEncoder.encode(JSESSION_ID, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_SCRIPT_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(MARKET_DATA_JS, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_METHOD_NAME, UTF_8) + EQUAL_OP + URLEncoder.encode(GET_INDICES_TODAY, UTF_8));
        data.append(AND_OP + URLEncoder.encode(C0_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("0", UTF_8));
        data.append(AND_OP + URLEncoder.encode(BATCH_ID, UTF_8) + EQUAL_OP + URLEncoder.encode("1", UTF_8));

        log.debug("String Buffer VALUE" + data);
    }
}
