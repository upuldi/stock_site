package com.dao;

import org.hibernate.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 8/4/11
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class EODChartDaoJDBC extends JdbcTemplate implements EODChartDao {

    private static final String queryEODValues = "SELECT DATE_FORMAT( DATE,  '%Y-%m-%d' ) DATE, REPLACE( FORMAT( vol, 0 ) ,  ',',  '' ) VOL, TRIM( close ) , REPLACE( trade,  ',',  '' ) AS trade FROM upuldi_CSEDAILYDATA.EOD_DATA WHERE ticker =  ? ORDER BY date DESC;";
    private static final String queryHCEODValues = "SELECT  CONCAT(UNIX_TIMESTAMP(DATE_FORMAT(DATE,'%Y-%m-%d')),'000') DATE, TRIM( close ) AS CLOSE ,  REPLACE( FORMAT( vol, 0 ) ,  ',',  '' ) VOLUME, REPLACE( trade,  ',',  '' )  AS TRADES\n" +
            "FROM upuldi_CSEDAILYDATA.EOD_DATA WHERE ticker =  ? AND close is not null ORDER BY date ASC;";

    private static final String queryHCEODOtherValues = "SELECT  CONCAT(UNIX_TIMESTAMP(DATE_FORMAT(e.DATE,'%Y-%m-%d')),'000') DATE, TRIM( e.close ) AS CLOSE ,  REPLACE( FORMAT( e.vol, 0 ) ,  ',',  '' ) VOLUME, REPLACE( e.trade,  ',',  '' )  AS TRADES , d.remarks  " +
            "FROM upuldi_CSEDAILYDATA.EOD_DATA e left outer join upuldi_CSEDAILYDATA.Dividents d on d.ticker = e.ticker and  e.DATE = str_to_date(d.date,'%d-%M-%Y')  WHERE e.ticker =  ? AND e.close is not null ORDER BY e.date ASC";

    private static final String queryHCEODSplitValues = "SELECT  CONCAT(UNIX_TIMESTAMP(DATE_FORMAT(e.DATE, '%Y-%m-%d')), '000') DATE, TRIM(e.close) AS CLOSE, REPLACE(FORMAT(e.vol, 0), ',', '') VOLUME, REPLACE(e.trade, ',', '') AS TRADES, concat(s.ACTION,' ',s.OLD_PROPORTION,' into ',NEW_PROPORTION) as description\n" +
            "FROM upuldi_CSEDAILYDATA.EOD_DATA e left outer join upuldi_CSEDAILYDATA.SHARE_SPLITS s ON s.ticker  = e.ticker and e.DATE = s.EFFECTIVE_DATE WHERE e.ticker = ? AND e.close is not null ORDER BY e.date ASC";


    private static final String queryEODValuesForCandle = "select DATE_FORMAT(date,'%Y-%m-%d') Date,TRIM(open) as open,TRIM(high) as high,TRIM(low) as low,TRIM(close) as close,REPLACE(FORMAT(vol,0),',','') as vol, REPLACE( trade,  ',',  '' ) as trade from upuldi_CSEDAILYDATA.EOD_DATA where ticker = ? order by date desc; ";
    private static final String queryEODForignHoldingValues = "SELECT DATE_FORMAT(STR_TO_DATE(S.LAST_TRADED_DATE,'%d/%m/%Y'),  '%Y-%m-%d') DATE, REPLACE(RTRIM(LTRIM(S.FORIGN_HOLDING)) ,  ',', '' ) VOL \n" +
            "FROM upuldi_CSEDAILYDATA.DAILY_STOCK_STATISTICS S\n" +
            "INNER JOIN upuldi_CSEDAILYDATA.COMPANY_STOCK_MAPPING M on S.COMPANY_NAME = M.COMPANY_NAME\n" +
            "WHERE M.TICKER =  ? \n" +
            "group by LAST_TRADED_DATE,FORIGN_HOLDING\n" +
            "ORDER BY STR_TO_DATE(LAST_TRADED_DATE,'%d/%m/%Y') DESC;";

    private static final String queryEODIssuedQtyValues = "SELECT DATE_FORMAT(STR_TO_DATE(S.LAST_TRADED_DATE,'%d/%m/%Y'),  '%Y-%m-%d') DATE, REPLACE(RTRIM(LTRIM(S.ISSUED_QTY)) ,  ',', '' ) QTY\n" +
            "FROM upuldi_CSEDAILYDATA.DAILY_STOCK_STATISTICS S\n" +
            "INNER JOIN upuldi_CSEDAILYDATA.COMPANY_STOCK_MAPPING M on S.COMPANY_NAME = M.COMPANY_NAME\n" +
            "WHERE M.TICKER =  ? \n" +
            "ORDER BY STR_TO_DATE(LAST_TRADED_DATE,'%d/%m/%Y') DESC;";


    public ResultSet getEODValues(String type) {

        Object[] parameters = new Object[1];
        parameters[0] = type;
        SqlRowSet rowSet = this.queryForRowSet(queryEODValues, parameters);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    public ResultSet getEODValuesForCandle(String type) {

        Object[] parameters = new Object[1];
        parameters[0] = type;
        SqlRowSet rowSet = this.queryForRowSet(queryEODValuesForCandle, parameters);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    public ResultSet getEODForignHoldingValues(String stock) {

        Object[] parameters = new Object[1];
        parameters[0] = stock;

        SqlRowSet rowSet = this.queryForRowSet(queryEODForignHoldingValues, parameters);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();

    }

    public ResultSet getEODIssuedQtyValues(String stock) {

        Object[] parameters = new Object[1];
        parameters[0] = stock;
        SqlRowSet rowSet = this.queryForRowSet(queryEODIssuedQtyValues, parameters);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();

    }

    @Override
    public ResultSet getHCEODValues(String type) {
        Object[] parameters = new Object[1];
        parameters[0] = type;
        SqlRowSet rowSet = this.queryForRowSet(queryHCEODValues, parameters);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    @Override
    public ResultSet getHCEODOtherValues(String category, String type) {

        Object[] parameters = new Object[1];
        parameters[0] = type;

        String releventQueryString = null;

        if ("dividents".equalsIgnoreCase(category)) {
            releventQueryString = queryHCEODOtherValues;
        } else if ("splits".equalsIgnoreCase(category)) {
            releventQueryString = queryHCEODSplitValues;
        } else if ("rights".equalsIgnoreCase(category)) {
            releventQueryString = queryHCEODSplitValues;
        }

        releventQueryString = releventQueryString.replace("?","'"+type+"'");
        SqlRowSet rowSet = this.queryForRowSet(releventQueryString );
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }
}
