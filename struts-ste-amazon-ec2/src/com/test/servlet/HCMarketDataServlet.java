package com.test.servlet;

import com.dao.MarketSummeryDao;
import com.site.framework.SpringContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/14/12
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class HCMarketDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("REQUEST GOT");

        MarketSummeryDao marketSummeryDao = (MarketSummeryDao) SpringContext.getBean("marketSummeryDao");

        String type = request.getParameter("type");
        String callback = request.getParameter("callback");

        String content = "";
        String startSection = callback +"([\n";
        String endSection = "]);";

        String bodyContent = "";
        ResultSet rsetASI = marketSummeryDao.getMarketSummeryValuesForHCCharts(type);
        try {
            while(rsetASI.next()){
                String dateStr = rsetASI.getString(1);
                String value = rsetASI.getString(2);

                bodyContent = bodyContent + "[" + dateStr + "," + value + "],\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bodyContent = bodyContent.substring(0,bodyContent.length()-2);
        String wholeString = startSection + bodyContent + endSection;


        System.out.println("Complete Response : " + wholeString);
        response.setContentLength(wholeString.length());
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(wholeString);
    }
}
