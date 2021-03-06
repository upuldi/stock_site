package com.manager;

import com.dao.CSEListedCompanyDao;
import com.domain.CSEListedCompany;
import com.domain.Ticker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/2/11
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class CSEListedCompanyManagerImpl implements CSEListedCompanyManager {

    private CSEListedCompanyDao cseListedCompanyDao;

    public void setCseListedCompanyDao(CSEListedCompanyDao cseListedCompanyDao) {
        this.cseListedCompanyDao = cseListedCompanyDao;
    }

    public List<String> getCSEStockCodes() {

        List<CSEListedCompany> cseListedCompanies =  cseListedCompanyDao.getCSEListedCompanies();
        List<String> cseListedCompanyStockCodes = new ArrayList<String>();
        cseListedCompanyStockCodes.add("");

        for (CSEListedCompany cseListedCompany : cseListedCompanies) {
            cseListedCompanyStockCodes.add(cseListedCompany.getStockCode());
        }
        return cseListedCompanyStockCodes;
    }

    @Override
    public List<CSEListedCompany> getCompanyListForSearchString(String searchString) {
        return cseListedCompanyDao.getListedCompaniesForSearchString(searchString);
    }

    @Override
    public CSEListedCompany getCompanyById(String companyId) {
        return cseListedCompanyDao.getCompanyById(companyId);
    }

    @Override
    public List<Ticker> getTickersForCompanyId(String companyId) {
        return cseListedCompanyDao.getTickersForCompany(companyId);
    }

    @Override
    public Ticker getTickerBySymbol(String stockCode) {
        return cseListedCompanyDao.getTickerBySymbol(stockCode);
    }

    @Override
    public List<CSEListedCompany> getCSEStockCodesWithCompany() {
        List<CSEListedCompany> cseListedCompanies =  cseListedCompanyDao.getCSEListedCompaniesWithCompanyName();
        return cseListedCompanies;
    }
}
