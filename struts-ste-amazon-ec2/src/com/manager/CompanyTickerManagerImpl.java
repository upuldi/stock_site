package com.manager;

import com.dao.CompanyTickerDao;
import com.domain.Ticker;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/28/12
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyTickerManagerImpl implements CompanyTickerManager{

    private CompanyTickerDao companyTickerDao;

    public void setCompanyTickerDao(CompanyTickerDao companyTickerDao) {
        this.companyTickerDao = companyTickerDao;
    }

    @Override
    public String getCSECompanyIdByCompanyTickerName(String symbol) {
        Ticker ticker = companyTickerDao.getCSETickerIdByCompanyTicker(symbol);
        String returnString = null;
        if (null != ticker) {
            returnString = ticker.getCseId();
        }
        return returnString;
    }
}
