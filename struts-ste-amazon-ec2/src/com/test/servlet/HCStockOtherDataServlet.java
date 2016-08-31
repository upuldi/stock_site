package com.test.servlet;

import com.dao.EODChartDao;
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
 * Date: 1/2/13
 * Time: 12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class HCStockOtherDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("REQUEST GOT FOR HCStockOtherDataServlet");

        EODChartDao eodChartDao = (EODChartDao) SpringContext.getBean("eODChartDao");

        String type = request.getParameter("type");
        String category = request.getParameter("category");
        String callback = request.getParameter("callback");

        if (null != type && type.trim().length() > 0) {

            String content = "";
            String startSection = callback + "([\n";
            String endSection = "]);";

            String bodyContent = "";
            ResultSet rset = eodChartDao.getHCEODOtherValues(category, type);
            try {
                while (rset.next()) {
                    String dateStr = rset.getString(1);
                    String value = rset.getString(2);
                    String volume = rset.getString(3);
                    String trades = rset.getString(4);

                    String remarks = "";
                    if (null != rset.getString(5)) {
                        remarks = rset.getString(5);
                    }

                    bodyContent = bodyContent + "[" + dateStr + "," + value + "," + volume + ",'" + remarks + "'],\n";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            bodyContent = bodyContent.substring(0, bodyContent.length() - 2);
            String wholeString = startSection + bodyContent + endSection;

            System.out.println("Complete Response : " + wholeString);
            response.setContentLength(wholeString.length());
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(wholeString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
