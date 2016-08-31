package com.dao;

import com.domain.EODData;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 6/23/11
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class EODDataDaoHibernate extends HibernateDaoSupport implements EODDataDao {

    public void saveEODData(EODData eodData) {
        getHibernateTemplate().save(eodData);
    }

    public EODData getEODDataForStock(String dateString, String stockCode) {

        Query query = getSession().getNamedQuery("getEODDataForStock");
        query.setString("date",dateString);
        query.setString("ticker",stockCode);
        EODData eodData = (EODData) query.uniqueResult();

        return eodData;
    }

    public EODData getLatestEODDataForStock(String stockCode) {

        Query query = getSession().getNamedQuery("getLastEODDataForStock");
        query.setString("ticker",stockCode);
        query.setFirstResult(0);
        query.setMaxResults(1);
        Object obj = query.uniqueResult();
        EODData returnObj = null;
        if (null != obj) {
            returnObj = (EODData) obj;
        }
        return returnObj;
    }

    @Override
    public String getLatestFancyTickerString() {
        Query query = getSession().getNamedQuery("getLatestFancyTickerString");
        return   (String) query.uniqueResult();
    }
}
