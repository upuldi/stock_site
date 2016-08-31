package com.test.servlet;

import au.com.bytecode.opencsv.CSVWriter;
import com.dao.MarketSummeryDao;
import com.site.framework.SpringContext;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/14/12
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AMMarketDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        System.out.println("REQUEST GOT");
        try {
            byte[] blobData = getMarketSummeryCSV(type);
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=data.csv");
            response.setContentLength(blobData.length);
            ServletOutputStream out = response.getOutputStream();
            out.write(blobData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private byte[] getMarketSummeryCSV(String type) throws IOException, SQLException {

        StringWriter stringWriter = new StringWriter();
        CSVWriter writer = new CSVWriter(stringWriter);

        MarketSummeryDao marketSummeryDao = (MarketSummeryDao) SpringContext.getBean("marketSummeryDao");

        ResultSet rset = marketSummeryDao.getMarketSummeryValuesForAMCharts(type);
        System.out.println("Result Set is coming.." + rset);

        writer.writeAll(rset, false);
        writer.close();
        String csvStringContent = stringWriter.toString().replace("\"", "");
        return csvStringContent.getBytes();
    }

}
