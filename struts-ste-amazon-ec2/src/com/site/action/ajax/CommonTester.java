package com.site.action.ajax;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 4/8/12
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonTester {

    public static final String H5ALL_VAL_DY = "select * from (select day,CONCAT(UNIX_TIMESTAMP(str_to_date(day,'%d-%m-%Y')),'000') as KK, REPLACE(VOLUME_OF_DOMESTIC_NO, \",\", \"\") as value \n" +
            "from upuldi_CSEDAILYDATA.DAILY_MARKET_SUMMERY where VOLUME_OF_DOMESTIC_NO is not null order by str_to_date(day,'%d-%m-%Y') asc\n" +
            ") mm where mm.KK > :from and mm.KK < :to;";

    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        Long now = calendar.getTimeInMillis();
        Date timeNow = calendar.getTime();
        calendar.add(Calendar.MONTH,-6);
        Date sixMonthsFromNow = calendar.getTime();

        System.out.println("NOW " + timeNow);
        System.out.println("SIX MONTHS BACK " + sixMonthsFromNow);
    }
}
