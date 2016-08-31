package com.test.servlet;

import com.dao.EODChartDao;
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
 * Date: 12/29/12
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class HCEodDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println("REQUEST GOT");

        EODChartDao eodChartDao = (EODChartDao) SpringContext.getBean("eODChartDao");

        String type = request.getParameter("type");
        String callback = request.getParameter("callback");

        String content = "";
        String startSection = callback +"([\n";
        String endSection = "]);";

        String bodyContent = "";
        ResultSet rset = eodChartDao.getHCEODValues(type);
        try {
            while(rset.next()){
                String dateStr = rset.getString(1);
                String value = rset.getString(2);
                String volume = rset.getString(3);

                bodyContent = bodyContent + "[" + dateStr + "," + value + "," + volume + "],\n";
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
