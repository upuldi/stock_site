package com.site.action.chart;

import com.domain.EODData;
import com.domain.Ticker;
import com.manager.CSEListedCompanyManager;
import com.manager.EODDataManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 10/3/13
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockChartByTickerAction extends BaseSubHeaderTickerAction {

    public String stockCodeOnly;

    public String getStockCodeOnly() {
        return stockCodeOnly;
    }

    public void setStockCodeOnly(String stockCodeOnly) {
        this.stockCodeOnly = stockCodeOnly;
    }

    public String stockDataByCode() {
        super.submitDataConfig("charts",stockCodeOnly);
        return "eodChart-submit";
    }

}
