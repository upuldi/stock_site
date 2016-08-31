package com.dao;

import com.domain.Ticker;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/28/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyTickerDao {

    Ticker getCSETickerIdByCompanyTicker(String symbol);
}
