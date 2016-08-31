package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 8/1/11
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */



public class MarketSummeryDaoJDBC extends JdbcTemplate implements MarketSummeryDao {


    public static final class AM_MARKET_CONS {

        public static final String ALL_MARKET_SUMMERY_VALUE = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(cse_all_share_index, \",\", \"\")  as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where cse_all_share_index is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MILANKA_VALUE = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(milanka_price_index, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where milanka_price_index is not null  order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String SNP_VALUE = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(SNP_VAL, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where SNP_VAL is not null and SNP_VAL != \"\" order by str_to_date(day,'%d-%m-%Y') asc;";


        public static final String MARKET_TURNOVER_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_VALUE_OF_TURNOVER_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_VALUE_OF_TURNOVER_RS is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MARKET_TRADE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(TRADES_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where TRADES_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String DOM_TRADE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String FOR_TRADE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String DOM_PER_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_PURCHASE_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_PURCHASE_RS is not null order by str_to_date(day,'%d-%m-%Y')  desc;";


        public static final String DOM_SALE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_SALES_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_SALES_RS is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String FOR_PER_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_PURCHASE_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_PURCHASE_RS is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String FOR_SALE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_SALES_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_SALES_RS is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MVOL_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_TURNOVER_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_TURNOVER_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String VOL_DOM_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_DOMESTIC_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String VOL_FOR_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_FOREIGN_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_FOREIGN_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String TOT_VOL_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_TURNOVER_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_TURNOVER_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String DOM_VOL_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String FOR_VOL_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_FOREIGN_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_FOREIGN_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String ALL_TRADE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(TRADES_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where TRADES_NO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MARKET_CAP_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_CAPITALIZATION, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_CAPITALIZATION is not null order by str_to_date(day,'%d-%m-%Y') desc;";

    }
    public static final class AM_INDEX_CONS {

        public static final String BFI_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MBFI, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MBFI is not null and MBFI != \"\"  order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String BFT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MBFT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MBFT is not null and MBFT != \"\"  order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String CNP_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MCNP, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MCNP is not null and MCNP != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String CNE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MCNE, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MCNE is not null and MCNE != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String DIV_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MDIV, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MDIV is not null and MDIV != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String FNT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MFNT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MFNT is not null and MFNT != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String HLT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MHLT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MHLT is not null and MHLT != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String HNT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MHNT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MHNT is not null and MHNT != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String INV_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MINV, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MINV is not null and MINV != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String IT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MIT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MIT is not null and MIT != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String LNP_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MLNP, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MLNP is not null and MLNP != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MFG_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MMFG, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MMFG is not null and MMFG != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String MTR_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MMTR, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MMTR is not null and MMTR != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String OIL_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MOIL, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MOIL is not null and MOIL != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String PLT_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MPLT, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MPLT is not null and MPLT != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String PNE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MPNE, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MPNE is not null and MPNE != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String SRV_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MSRV, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MSRV is not null and MSRV != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String SNS_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MSNS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MSNS is not null and MSNS != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String TLE_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MTLE, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MTLE is not null and MTLE != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String TRD_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MTRD, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MTRD is not null and MTRD != \"\" order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String EPS_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_PRICE_EARNINGS_RATIO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_PRICE_EARNINGS_RATIO is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String PBV_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_PRICE_TO_BOOK_VALUE, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_PRICE_TO_BOOK_VALUE is not null order by str_to_date(day,'%d-%m-%Y') desc;";

        public static final String DY_VAL = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_DIVIDEND_YIELD, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_DIVIDEND_YIELD is not null order by str_to_date(day,'%d-%m-%Y') desc;";

    }

    public static final class  HC_MARKET_CONS {

        public static final String HC_ALL_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(cse_all_share_index, \",\", \"\")  as value\n" +
                "            from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where cse_all_share_index is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String H5ALL_VAL_DY = "select * from (select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000') as KK, REPLACE(VOLUME_OF_DOMESTIC_NO, \",\", \"\") as value \n" +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') asc\n" +
                ") mm where mm.KK > ':from' and mm.KK < ':to' ;";

        public static final String HC_MPI = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(milanka_price_index, \",\", \"\")  as value\n" +
                "            from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where milanka_price_index is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_SNP = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(SNP_VAL, \",\", \"\")  as value\n" +
                "            from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where SNP_VAL is not null order by str_to_date(day,'%d-%m-%Y') asc;";


        public static final String HC_MARKET_TRADE_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(TRADES_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where TRADES_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_DOM_TRADE_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(DOMESTIC_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_FOR_TRADE_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(FOREIGN_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_TO_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(MARKET_VALUE_OF_TURNOVER_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_VALUE_OF_TURNOVER_RS is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_TOT_VOL_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(VOLUME_OF_TURNOVER_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_TURNOVER_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_DOM_VOL_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(VOLUME_OF_DOMESTIC_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_FOR_VOL_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(VOLUME_OF_FOREIGN_NO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_FOREIGN_NO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_DOM_SALE_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(DOMESTIC_SALES_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_SALES_RS is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_DOM_PER_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(DOMESTIC_PURCHASE_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where DOMESTIC_PURCHASE_RS is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_FOR_SALE_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(FOREIGN_SALES_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_SALES_RS is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_FOR_PER_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(FOREIGN_PURCHASE_RS, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where FOREIGN_PURCHASE_RS is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_DV_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(MARKET_DIVIDEND_YIELD, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_DIVIDEND_YIELD is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_PBV_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(MARKET_PRICE_TO_BOOK_VALUE, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_PRICE_TO_BOOK_VALUE is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_HC_PER_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(MARKET_PRICE_EARNINGS_RATIO, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_PRICE_EARNINGS_RATIO is not null order by str_to_date(day,'%d-%m-%Y') asc;";

        public static final String HC_MAR_CAP_VAL = "select CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000'), REPLACE(MARKET_CAPITALIZATION, \",\", \"\") as value " +
                "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where MARKET_CAPITALIZATION is not null order by str_to_date(day,'%d-%m-%Y') asc;";

    }


    public ResultSet getMarketSummeryValuesForAMCharts(String type) {

        String query = null;

        if ("ALL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.ALL_MARKET_SUMMERY_VALUE;
        } else if ("MIL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.MILANKA_VALUE;
        } else if ("SNP".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.SNP_VALUE;
        } else if ("MTURNOVER".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.MARKET_TURNOVER_VAL;
        } else if ("MTRADE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.MARKET_TRADE_VAL;
        } else if ("DOMTRADE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.DOM_TRADE_VAL;
        } else if ("FORTRADE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.FOR_TRADE_VAL;
        } else if ("DOMPER".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.DOM_PER_VAL;
        } else if ("DOMSALE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.DOM_SALE_VAL;
        } else if ("FORPER".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.FOR_PER_VAL;
        } else if ("FORSALE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.FOR_SALE_VAL;
        } else if ("MVOL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.MVOL_VAL;
        } else if ("VOLDOM".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.VOL_DOM_VAL;
        } else if ("VFOR".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.VOL_FOR_VAL;
        } else if ("TOTVOL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.TOT_VOL_VAL;
        } else if ("DOMVOL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.DOM_VOL_VAL;
        } else if ("FORVOL".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.FOR_VOL_VAL;
        } else if ("ALLTRADE".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.ALL_TRADE_VAL;
        }else if ("MCAP".equalsIgnoreCase(type)) {
            query = AM_MARKET_CONS.MARKET_CAP_VAL;
        }else if ("BFI".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.BFI_VAL;
        }else if ("BFT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.BFT_VAL;
        }else if ("CNP".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.CNP_VAL;
        }else if ("CNE".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.CNE_VAL;
        }else if ("DIV".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.DIV_VAL;
        }else if ("FNT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.FNT_VAL;
        }else if ("HLT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.HLT_VAL;
        }else if ("HNT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.HNT_VAL;
        }else if ("INV".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.INV_VAL;
        }else if ("IT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.IT_VAL;
        }else if ("LNP".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.LNP_VAL;
        }else if ("MFG".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.MFG_VAL;
        }else if ("MTR".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.MTR_VAL;
        }else if ("OIL".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.OIL_VAL;
        }else if ("PLT".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.PLT_VAL;
        }else if ("PNE".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.PNE_VAL;
        }else if ("SRV".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.SRV_VAL;
        }else if ("SNS".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.SNS_VAL;
        }else if ("TLE".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.TLE_VAL;
        }else if ("TRD".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.TRD_VAL;
        }else if ("EPS".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.EPS_VAL;
        }else if ("PBV".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.PBV_VAL;
        }else if ("DY".equalsIgnoreCase(type)) {
            query = AM_INDEX_CONS.DY_VAL;
        }

        SqlRowSet rowSet = this.queryForRowSet(query);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    public ResultSet getMarketSummerySectionValues(String type) {

        String query = null;

        if ("VOL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d') as date, \n" +
                    "REPLACE(volume_of_turnover_no, \",\", \"\")  as allturn, \n" +
                    "REPLACE(volume_of_domestic_no, \",\", \"\")  as domestic,\n" +
                    "REPLACE(volume_of_foreign_no, \",\", \"\")  as forturn \n" +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("MIL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(milanka_price_index, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("MTURNOVER".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(MARKET_VALUE_OF_TURNOVER_RS, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("MTRADE".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(TRADES_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("DOMTRADE".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("FORTRADE".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("DOMPER".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_PURCHASE_RS, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y')  desc;";
        } else if ("DOMSALE".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_SALES_RS, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("FORPER".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_PURCHASE_RS, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("FORSALE".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(FOREIGN_SALES_RS, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("MVOL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_TURNOVER_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("VOLDOM".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_DOMESTIC_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("VFOR".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_FOREIGN_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("TOTVOL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_TURNOVER_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("DOMVOL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(DOMESTIC_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        } else if ("FORVOL".equalsIgnoreCase(type)) {
            query = "select DATE_FORMAT(str_to_date(day,'%d-%m-%Y'),'%Y-%m-%d'), REPLACE(VOLUME_OF_FOREIGN_NO, \",\", \"\") as value " +
                    "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY order by str_to_date(day,'%d-%m-%Y') desc;";
        }

        SqlRowSet rowSet = this.queryForRowSet(query);

        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    public ResultSet getContributorSummeryValues(String type) {

        String query = null;

        if ("VOLUME".equalsIgnoreCase(type)) {

            query = "select y.ticker,y.vol from (select @rownum:=@rownum+1 rownum, d.ticker,d.vol  \n" +
                    "from upuldi_CSEDAILYDATA.EOD_DATA d, (SELECT @rownum:=0) r where date  = \n" +
                    "(select z.date from (select @rownumC:=@rownumC+1 rownumC, d.date from upuldi_CSEDAILYDATA.EOD_DATA d, (SELECT @rownumC:=0) r group by date order by  DATE_FORMAT(d.date,'%Y-%m-%d') desc  limit 1)z) order by d.vol desc limit 10)y;";

        } else if ("POSITIVE-PRE".equalsIgnoreCase(type)) {

            query = "select x.* from (select d.ticker , ROUND((((REPLACE(close,',','')-REPLACE(open,',',''))/REPLACE(open,',',''))*100),2) gap from upuldi_CSEDAILYDATA.EOD_DATA d where d.date = (select z.date from (select @rownumC:=@rownumC+1 rownumC, d.date \n" +
                    "from upuldi_CSEDAILYDATA.EOD_DATA d, (SELECT @rownumC:=0) r group by date \n" +
                    "order by  DATE_FORMAT(d.date,'%Y-%m-%d') desc  limit 1)z)) x order by x.gap desc limit 10;";

        } else if ("NEGATIVE-PRE".equalsIgnoreCase(type)) {

            query = "select x.* from (select d.ticker , ROUND((((REPLACE(close,',','')-REPLACE(open,',',''))/REPLACE(open,',',''))*100),2) gap from upuldi_CSEDAILYDATA.EOD_DATA d where d.date = (select z.date from (select @rownumC:=@rownumC+1 rownumC, d.date \n" +
                    "from upuldi_CSEDAILYDATA.EOD_DATA d, (SELECT @rownumC:=0) r group by date \n" +
                    "order by  DATE_FORMAT(d.date,'%Y-%m-%d') desc  limit 1)z)) x order by x.gap asc limit 10;";

        } else if ("FORIGN-HOL-INDEX".equalsIgnoreCase(type)) {

            query = "select RTRIM(LTRIM(S.company_name)), round((CONVERT(REPLACE(S.forign_holding,',',''),UNSIGNED INTEGER)/CONVERT(REPLACE(S.issued_qty,',',''),UNSIGNED INTEGER))*100,2) PRESENT\n" +
                    "from upuldi_CSEDAILYDATA.DAILY_STOCK_STATISTICS S\n" +
                    "where S.last_traded_date = (select z.last_traded_date from (select @rownumC:=@rownumC+1 rownumC, d.last_traded_date from upuldi_CSEDAILYDATA.DAILY_STOCK_STATISTICS d, (SELECT @rownumC:=0) r group by last_traded_date order by  DATE_FORMAT(d.last_traded_date,'%d/%m/%Y') desc  limit 1)z\n" +
                    ") and ( round((CONVERT(REPLACE(S.forign_holding,',',''),UNSIGNED INTEGER)/CONVERT(REPLACE(S.issued_qty,',',''),UNSIGNED INTEGER))*100,2) < 100) \n" +
                    "and ( round((CONVERT(REPLACE(S.forign_holding,',',''),UNSIGNED INTEGER)/CONVERT(REPLACE(S.issued_qty,',',''),UNSIGNED INTEGER))*100,2) > 0 ) \n" +
                    "order by PRESENT;";
        }

        SqlRowSet rowSet = this.queryForRowSet(query);

        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

    @Override
    public ResultSet getMarketSummeryValuesForHCCharts(String type) {

        String query = null;

        if ("HC_ALL".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_ALL_VAL;
        }else if ("HC_MPI".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_MPI;
        }else if ("HC_SNP".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_SNP;
        }else if ("HC_TRADE".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_MARKET_TRADE_VAL;
        }else if ("HC_DOMTRADE".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_DOM_TRADE_VAL;
        }else if ("HC_FORTRADE".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_FOR_TRADE_VAL;
        }else if ("HC_TO".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_TO_VAL;
        }else if ("HC_TOT_VOL".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_TOT_VOL_VAL;
        }else if ("HC_DOM_VOL".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_DOM_VOL_VAL;
        }else if ("HC_DOM_PER".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_DOM_PER_VAL;
        }else if ("HC_DOM_SALE".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_DOM_SALE_VAL;
        }else if ("HC_FOR_VOL".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_FOR_VOL_VAL;
        }else if ("HC_FOR_PER".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_FOR_PER_VAL;
        }else if ("HC_FOR_SALE".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_FOR_SALE_VAL;
        }else if ("HC_MAR_CAP".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_MAR_CAP_VAL;
        }else if ("HC_PER".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_HC_PER_VAL;
        }else if ("HC_PBV".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_PBV_VAL;
        }else if ("HC_DV".equalsIgnoreCase(type)) {
            query = HC_MARKET_CONS.HC_DV_VAL;
        }
        SqlRowSet rowSet = this.queryForRowSet(query);
        ResultSetWrappingSqlRowSet resultSetWrappingSqlRowSet = (ResultSetWrappingSqlRowSet) rowSet;
        return resultSetWrappingSqlRowSet.getResultSet();
    }

}

