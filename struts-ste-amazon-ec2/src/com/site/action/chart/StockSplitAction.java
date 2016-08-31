package com.site.action.chart;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 10/3/13
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockSplitAction extends BaseSubHeaderTickerAction {

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
        return "split-input";
    }

    public String submitData() {
        if (null != stockCode) {
            tickerOnly = stockCode.substring(stockCode.indexOf("[")+1,stockCode.indexOf("]"));
            super.submitDataConfig("charts",tickerOnly);
            return "split-submit";
        } else {
            return "split-input";
        }
    }

}