package com.domain;

/**
 * Created by IntelliJ IDEA.
 * User: epsi
 * Date: 24-Jan-2012
 * Time: 21:57:45
 * To change this template use File | Settings | File Templates.
 */
public class Comment {

    private long id;
    private String name;
    private String emailAddress;
    private String subject;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
