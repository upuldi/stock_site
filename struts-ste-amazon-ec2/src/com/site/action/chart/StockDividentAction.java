package com.site.action.chart;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/31/12
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class StockDividentAction extends BaseSubHeaderTickerAction {

    public String stockCode;
    public String tickerOnly;

    public String getTickerOnly() {
        return tickerOnly;
    }

    public void setTickerOnly(String tickerOnly) {
        this.tickerOnly = tickerOnly;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String inputData() {
        super.inputDataConfig("charts");
        return "divident-input";
    }

    public String submitData() {
        if (null != stockCode) {
            tickerOnly = stockCode.substring(stockCode.indexOf("[")+1,stockCode.indexOf("]"));
            super.submitDataConfig("charts",tickerOnly);
            return "divident-submit";
        } else {
            return "divident-input";
        }
    }
}
