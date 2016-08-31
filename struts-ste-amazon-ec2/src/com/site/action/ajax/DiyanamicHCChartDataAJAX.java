package com.site.action.ajax;

import com.dao.ChartDataDaoHibernate;
import com.dao.MarketSummeryDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/7/12
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiyanamicHCChartDataAJAX extends ActionSupport implements
        ServletRequestAware, ServletResponseAware {

    private static final Logger log = Logger.getLogger(DiyanamicHCChartDataAJAX.class);

    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    private MarketSummeryDao marketSummeryDao;
    private ChartDataDaoHibernate chartDataDaoHibernate;

    public void setChartDataDaoHibernate(ChartDataDaoHibernate chartDataDaoHibernate) {
        this.chartDataDaoHibernate = chartDataDaoHibernate;
    }

    public void setMarketSummeryDao(MarketSummeryDao marketSummeryDao) {
        this.marketSummeryDao = marketSummeryDao;
    }


    public String fetchData() throws IOException, SQLException {

        String paramValue = "";
        paramValue = httpServletRequest.getParameter("callback");

        String start = "";
        start = httpServletRequest.getParameter("start");

        String end = "";
        end = httpServletRequest.getParameter("end");


        Calendar calendar = Calendar.getInstance();
        Long nowInMills = calendar.getTimeInMillis();
        Date timeNow = calendar.getTime();
        calendar.add(Calendar.YEAR,-5);
        Date sixMonthsFromNow = calendar.getTime();
        Long sixMonthsBackFromNowInMills = calendar.getTimeInMillis();

        System.out.println("NOW " + timeNow + " IN MILLS " + nowInMills);
        System.out.println("SIX MONTHS BACK " + sixMonthsFromNow + " IN MILLS " + sixMonthsBackFromNowInMills);

        if (null == start) {
            start = sixMonthsBackFromNowInMills.toString();
        }
        if (null == end) {
            end = nowInMills.toString();
        }

        //1318962600000

        //1350585000000

        String content = "";
        String startSection = paramValue +"([\n";
        String endSection = "]);";

        String bodyContent = "";
      /*  ResultSet rsetASI = marketSummeryDao.getDiyanamicMarketSummeryValues(start,end);
        while(rsetASI.next()){
            String dateStr = rsetASI.getString(1);
            String value = rsetASI.getString(2);

            bodyContent = bodyContent + "[" + dateStr + "," + value + "],\n";
        }*/

        bodyContent = bodyContent.substring(0,bodyContent.length()-2);
        String wholeString = startSection + bodyContent + endSection;
        log.debug("Complete Response : " + wholeString);
        httpServletResponse.setContentLength(wholeString.length());
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        out.print(wholeString);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}
