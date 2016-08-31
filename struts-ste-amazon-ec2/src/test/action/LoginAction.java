package test.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 4/4/12
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends ActionSupport implements
        ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;


    public String userLogin() {

        String requestUrl = this.request.getRequestURI();


        return "admin";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }
}
