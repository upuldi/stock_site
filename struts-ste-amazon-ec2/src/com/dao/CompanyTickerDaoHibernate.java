package com.dao;

import com.domain.Ticker;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/28/12
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyTickerDaoHibernate extends HibernateDaoSupport implements CompanyTickerDao{

    @Override
    public Ticker getCSETickerIdByCompanyTicker(String symbol) {
        
        Query query = getSession().getNamedQuery("getCSECompanyTickerIdByTickerSymbol");
        query.setString("ticker",symbol);
        Object o = query.uniqueResult();
        Ticker ticker = null;
        if (null != o) {
            ticker = (Ticker) o;
        }
        return ticker;
    }
}
