package com.dao;

import com.domain.CSEListedCompany;
import com.domain.Ticker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/2/11
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CSEListedCompanyDao {

    List<CSEListedCompany> getCSEListedCompanies();

    List<CSEListedCompany> getListedCompaniesForSearchString(String searchString);

    CSEListedCompany getCompanyById(String companyId);

    List<Ticker> getTickersForCompany(String companyId);

    Ticker getTickerBySymbol(String stockCode);

    List<CSEListedCompany> getCSEListedCompaniesWithCompanyName();

}
