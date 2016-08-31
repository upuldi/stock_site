package com.site.action.common;

import com.domain.CSEListedCompany;
import com.manager.CSEListedCompanyManager;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 2/8/12
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchAction extends ActionSupport {

    private static Logger log = Logger.getLogger(SearchAction.class);

    private String searchString;
    private List<CSEListedCompany> cseCompanyList = new ArrayList<CSEListedCompany>();

    private CSEListedCompanyManager cseListedCompanyManager;

    public void setCseListedCompanyManager(CSEListedCompanyManager cseListedCompanyManager) {
        this.cseListedCompanyManager = cseListedCompanyManager;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<CSEListedCompany> getCseCompanyList() {
        return cseCompanyList;
    }

    public void setCseCompanyList(List<CSEListedCompany> cseCompanyList) {
        this.cseCompanyList = cseCompanyList;
    }

    public String searchCompany() {

        log.debug("Search String is : " + searchString);
        cseCompanyList = cseListedCompanyManager.getCompanyListForSearchString(searchString);
        log.debug(" Search Retured : " + cseCompanyList.size() + " companies");
        return SUCCESS;
   }


}
