package com.site.action.ajax;

import com.domain.CSEListedCompany;
import com.manager.CSEListedCompanyManager;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/6/12
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class AutoFillDataSupport extends ActionSupport implements
        ServletRequestAware, ServletResponseAware {

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    Logger log = Logger.getLogger(AutoFillDataSupport.class);

    private CSEListedCompanyManager cseListedCompanyManager;
    private static List<String> stockCodes;
    private static List<CSEListedCompany> stockObjects;
    private Map<String,String> stockCodeTickerMap = new HashMap<String,String>();

    public void setCseListedCompanyManager(CSEListedCompanyManager cseListedCompanyManager) {
        this.cseListedCompanyManager = cseListedCompanyManager;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public String fetchStockCodes() throws IOException, ServletException {

        if (null == stockCodes) {
            stockObjects = cseListedCompanyManager.getCSEStockCodesWithCompany();

            stockCodes = new ArrayList<String>();
            stockCodes.add("");
            for (CSEListedCompany cseListedCompany : stockObjects) {
                stockCodes.add(cseListedCompany.getStockCode());
                stockCodeTickerMap.put(cseListedCompany.getStockCode(),cseListedCompany.getDescription());
            }
        }

        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setHeader("Cache-control", "no-cache, no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Expires", "-1");

        JSONArray arrayObj =new JSONArray();

        log.info("Obtaining stock codes from the db.");

        String enteredLetter = httpServletRequest.getParameter("term");
        log.debug(" User entered : " +enteredLetter);
        enteredLetter = enteredLetter.toUpperCase();

        for (Map.Entry<String,String> entry : stockCodeTickerMap.entrySet()) {

            if(entry.getKey().startsWith(enteredLetter) || entry.getValue().startsWith(enteredLetter)) {
                arrayObj.add(entry.getKey());
            }
        }

        for (String stockCode : stockCodes) {
            if(stockCode.startsWith(enteredLetter)) {
                arrayObj.add(stockCode);
            }
        }
        out.println(arrayObj.toString());
        out.close();
        return SUCCESS;
    }
}
