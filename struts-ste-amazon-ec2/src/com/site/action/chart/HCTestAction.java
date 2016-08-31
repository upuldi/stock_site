package com.site.action.chart;

import com.dao.MarketSummeryViewDao;
import com.domain.DailyMarketSummery;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 12/2/12
 * Time: 9:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class HCTestAction extends ActionSupport {

    private String selectedLink;

    private String aspiChange;
    private String mpiChange;
    private String aspiChangePresentage;
    private String mpiChangePresentage;
    private String aspiValue;
    private String mpiValue;
    private String fontClassASPIChangeValue;
    private String fontClassASPIChangePresentage;
    private String fontClassMPIChangeValue;
    private String fontClassMPIChangePresentage;
    private String aspiImage;
    private String mpiImage;

    private MarketSummeryViewDao marketSummeryViewDao;
    public void setMarketSummeryViewDao(MarketSummeryViewDao marketSummeryViewDao) {
        this.marketSummeryViewDao = marketSummeryViewDao;
    }

    public String getAspiImage() {
        return aspiImage;
    }

    public String getMpiImage() {
        return mpiImage;
    }

    public String getSelectedLink() {
        return selectedLink;
    }

    public String getAspiChange() {
        return aspiChange;
    }

    public String getMpiChange() {
        return mpiChange;
    }

    public String getAspiChangePresentage() {
        return aspiChangePresentage;
    }

    public String getMpiChangePresentage() {
        return mpiChangePresentage;
    }

    public String getAspiValue() {
        return aspiValue;
    }

    public String getMpiValue() {
        return mpiValue;
    }

    public String getFontClassASPIChangeValue() {
        return fontClassASPIChangeValue;
    }

    public String getFontClassASPIChangePresentage() {
        return fontClassASPIChangePresentage;
    }

    public String getFontClassMPIChangeValue() {
        return fontClassMPIChangeValue;
    }

    public String getFontClassMPIChangePresentage() {
        return fontClassMPIChangePresentage;
    }

    public MarketSummeryViewDao getMarketSummeryViewDao() {
        return marketSummeryViewDao;
    }

    public String hcTest() {

        selectedLink = "marketdata";

        DailyMarketSummery dailyMarketSummery = marketSummeryViewDao.getMarketSummeryView();
        aspiChange = dailyMarketSummery.getAspiChange();
        mpiChange = dailyMarketSummery.getMpiChange();
        aspiValue = dailyMarketSummery.getCseAllShareIndex();
        mpiValue = dailyMarketSummery.getMilankaPriceIndex();
        aspiChangePresentage = dailyMarketSummery.getAspiChangePresentage();
        mpiChangePresentage = dailyMarketSummery.getMpiChangePresentage();

        if (null != aspiChange && Double.parseDouble(aspiChange) >= 0) {
            fontClassASPIChangeValue = "cusfont-green";
            fontClassASPIChangePresentage = "cusfont-green";
            aspiImage = "green-up.png";
        }else {
            fontClassASPIChangeValue = "cusfont-red";
            fontClassASPIChangePresentage = "cusfont-red";
            aspiImage = "red-down.png";
        }

        if (null != mpiChange && Double.parseDouble(mpiChange) >= 0) {
            fontClassMPIChangeValue = "cusfont-green";
            fontClassMPIChangePresentage = "cusfont-green";
            mpiImage = "green-up.png";
        }else {
            fontClassMPIChangeValue = "cusfont-red";
            fontClassMPIChangePresentage = "cusfont-red";
            mpiImage = "red-down.png";
        }

        return SUCCESS;
    }

    public String newTest(){


        return SUCCESS;
    }
}


