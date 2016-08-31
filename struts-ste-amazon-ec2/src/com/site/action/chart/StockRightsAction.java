package com.site.action.chart;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 10/9/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockRightsAction extends BaseSubHeaderTickerAction {

    private String stockCode;
    public String tickerOnly;

    public String getStockCode() {
        return stockCode;
    }

    public String getTickerOnly() {
        return tickerOnly;
    }

    public void setTickerOnly(String tickerOnly) {
        this.tickerOnly = tickerOnly;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String inputData() {
        super.inputDataConfig("charts");
        return "right-input";
    }

    public String submitData() {
        if (null != stockCode) {
            tickerOnly = stockCode.substring(stockCode.indexOf("[")+1,stockCode.indexOf("]"));
            super.submitDataConfig("charts",tickerOnly);
            return "right-submit";
        } else {
            return "right-input";
        }
    }

}