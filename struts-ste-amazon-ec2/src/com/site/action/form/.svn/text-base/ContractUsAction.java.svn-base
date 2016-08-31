package com.site.action.form;

import com.opensymphony.xwork2.ActionSupport;
import com.dao.CommentsDao;
import com.domain.Comment;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: epsi
 * Date: 24-Jan-2012
 * Time: 20:25:46
 * To change this template use File | Settings | File Templates.
 */
public class ContractUsAction extends ActionSupport {

    private static Logger log = Logger.getLogger(ContractUsAction.class);

    private String name;
    private String email;
    private String message;
    private String subject;

    private boolean showSubheader = false;
    private String textMessage;

    private CommentsDao commentsDao;

    public void setCommentsDao(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public boolean isShowSubheader() {
        return showSubheader;
    }

    public void setShowSubheader(boolean showSubheader) {
        this.showSubheader = showSubheader;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String addContractDetails() {

        log.debug("*** NAME : " + name);
        log.debug("*** Email : " + email);
        log.debug("*** Message : " + message);
        System.out.println("*** NAME : " + name);
        System.out.println("*** Email : " + email);
        System.out.println("*** Message Subject : " + subject);
        System.out.println("*** Message : " + message);

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LeduswSAAAAALbZLjFZTdYl6Yq7le4DfJD7ZkMu");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
            Comment comment = new Comment();
            comment.setName(name);
            comment.setEmailAddress(email);
            comment.setMessage(message);
            comment.setSubject(subject);
            comment.setMessage(message);
            commentsDao.addComment(comment);
            textMessage = "Thank you for your message. We will get back to you shortly.";
        } else {
            textMessage = "Please re enter the value displayed in the image correctly.";
        }
        showSubheader = true;

        return SUCCESS;
    }
}
