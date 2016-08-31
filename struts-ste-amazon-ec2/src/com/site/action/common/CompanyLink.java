package com.site.action.common;

import com.domain.CSEListedCompany;
import com.domain.Ticker;
import com.manager.CSEListedCompanyManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/11/12
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyLink  extends ActionSupport {


    private String companyId;
    private static Logger log = Logger.getLogger(CompanyLink.class);
    private CSEListedCompany listedCompany = new CSEListedCompany();
    private CSEListedCompanyManager cseListedCompanyManager;
    private List<Ticker> companyTickers = new ArrayList<Ticker>();

    public List<Ticker> getCompanyTickers() {
        return companyTickers;
    }

    public void setCompanyTickers(List<Ticker> companyTickers) {
        this.companyTickers = companyTickers;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public CSEListedCompany getListedCompany() {
        return listedCompany;
    }

    public void setListedCompany(CSEListedCompany listedCompany) {
        this.listedCompany = listedCompany;
    }

    public void setCseListedCompanyManager(CSEListedCompanyManager cseListedCompanyManager) {
        this.cseListedCompanyManager = cseListedCompanyManager;
    }

    public String getCompanyData() {

        log.debug("Company Id is : " + companyId);
        listedCompany = cseListedCompanyManager.getCompanyById(companyId);
        log.debug("Company Name is : " + listedCompany.getCompanyName());
        companyTickers = cseListedCompanyManager.getTickersForCompanyId(companyId);
        log.debug("Ticker count is : " + companyTickers.size());

        
        return SUCCESS;
    }
}
