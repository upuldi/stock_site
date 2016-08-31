package com.site.action.ajax;

import com.dao.ChartDataDaoHibernate;
import com.dao.MarketSummeryDao;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/6/12
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class AJAXHCChartDataAction extends ActionSupport /*implements
        ServletRequestAware, ServletResponseAware*/ {

 //   private static final Logger log = Logger.getLogger(AJAXHCChartDataAction.class);

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


    public String  fetchData() throws IOException, SQLException {

        System.out.println("REQUEST RECEIVED ...............");


            String paramValue = "";
            paramValue = httpServletRequest.getParameter("callback");

            String type = "";
            type = httpServletRequest.getParameter("type");

            String content = "";
            String startSection = paramValue +"([\n";
            String endSection = "]);";

            String bodyContent = "";
            ResultSet rsetASI = marketSummeryDao.getMarketSummeryValuesForAMCharts(type);
            while(rsetASI.next()){
                String dateStr = rsetASI.getString(1);
                String value = rsetASI.getString(2);

                bodyContent = bodyContent + "[" + dateStr + "," + value + "],\n";
            }

            bodyContent = "TEST YO YO ---------------------";
            bodyContent = bodyContent.substring(0,bodyContent.length()-2);
            String wholeString =/* startSection +*/ bodyContent + endSection;


            System.out.println("Complete Response : " + wholeString);
            httpServletResponse.setContentLength(wholeString.length());
            httpServletResponse.setContentType("application/json");
            PrintWriter out = httpServletResponse.getWriter();
            out.print(wholeString);

        return SUCCESS;
    }


    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}
