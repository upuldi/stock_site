package com.domain;

/**
 * Created by IntelliJ IDEA.
 * User: udoluweera
 * Date: 3/1/12
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeyValueData {
    
    private Long id;
    private String key;
    private Long value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
