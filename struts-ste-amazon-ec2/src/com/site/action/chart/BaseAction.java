package com.site.action.chart;

import com.dao.EODDataDao;
import com.opensymphony.xwork2.ActionSupport;
import com.site.framework.SpringContext;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 9/30/13
 * Time: 7:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction extends ActionSupport {

    private String fancyTicker;
    private static Logger log = Logger.getLogger(BaseAction.class);

    public String getFancyTicker() {
        return fancyTicker;
    }

    public BaseAction() {
        this.fancyTicker = fancyTicker;
       // init();
    }

    protected void initFancyTicker() {

        EODDataDao eodMarketData = (EODDataDao) SpringContext.getBean("eODDataDao");
        String fancyTickerString = eodMarketData.getLatestFancyTickerString();

        log.info("FANCY TICKER : " + fancyTickerString);

        fancyTicker = fancyTickerString;
    }
}
