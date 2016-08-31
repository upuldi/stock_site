package com.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: udoluweera
 * Date: 11/11/12
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChartData {

    private Long id;
    private String date;
    private String value;
    private String volume;
    private Date dateObj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateObj() {
        return dateObj;
    }

    public void setDateObj(Date dateObj) {
        this.dateObj = dateObj;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
}
