package com.manager;

import com.domain.CSEListedCompany;
import com.domain.Ticker;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/2/11
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CSEListedCompanyManager {

    List<String> getCSEStockCodes();

    List<CSEListedCompany> getCompanyListForSearchString(String searchString);

    CSEListedCompany getCompanyById(String companyId);

    List<Ticker> getTickersForCompanyId(String companyId);

    Ticker getTickerBySymbol(String stockCode);

    List<CSEListedCompany> getCSEStockCodesWithCompany();

}
