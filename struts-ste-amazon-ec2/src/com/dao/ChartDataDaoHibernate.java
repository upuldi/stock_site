package com.dao;

import com.domain.ChartData;
import com.domain.RubberPrice;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org. springframework.orm.hibernate3.support.HibernateDaoSupport;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/19/12
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChartDataDaoHibernate extends HibernateDaoSupport implements ChartDataDao {

    private static Logger log = Logger.getLogger(ChartDataDaoHibernate.class);

    public List<ChartData> getChartData(String type) {
        Query query = getSession().getNamedQuery(type);
        return (List<ChartData>) query.list();
    }

}
