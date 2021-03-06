package com.dao;

import com.domain.CSEListedCompany;
import com.domain.Ticker;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/2/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class CSEListedCompanyDaoHibernate extends HibernateDaoSupport implements CSEListedCompanyDao {

    public List<CSEListedCompany> getCSEListedCompanies() {
        Query query = getSession().getNamedQuery("getCSEListedCompanyCodes");
        return query.list();
    }

    @Override
    public List<CSEListedCompany> getListedCompaniesForSearchString(String searchString) {
        Query query = getSession().getNamedQuery("getCSEListedCompaniesForSearchString");
        query.setString("searchString", "%" + searchString + "%" );
        return query.list();

    }

    @Override
    public CSEListedCompany getCompanyById(String companyId) {

        CSEListedCompany returnObj = null;
        Query query = getSession().getNamedQuery("getCSEListedCompanyById");
        query.setString("id", companyId  );
        List list = query.list();
        if (null != list && list.size() > 0) {
            returnObj = (CSEListedCompany) list.get(0);

        }
        return returnObj;
    }

    @Override
    public List<Ticker> getTickersForCompany(String companyId) {
        Query query = getSession().getNamedQuery("getTickersByCompanyId");
        query.setString("companyId",companyId);
        return query.list();
    }

    @Override
    public Ticker getTickerBySymbol(String stockCode) {
        Query query = getSession().getNamedQuery("getTickerBySymbol");
        query.setString("symbol",stockCode);
        Object obj = query.uniqueResult();
        Ticker ticker = null;
        if (null != obj) {
            ticker = (Ticker) obj;
        }
        return ticker;
    }

    @Override
    public List<CSEListedCompany> getCSEListedCompaniesWithCompanyName() {
        Query query = getSession().getNamedQuery("getCSEListedCompanyCodesWithCompanyNames");
        return query.list();
    }
}
