package com.spy.wb.aihotel_new.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RecordModel implements Serializable {

    private String name;
    private String gender;
    private String id;
    private String status;
    private String env;
    private String similarity;
    private Date date;
    private String url_now;
    private String url_regist;

    public RecordModel(String name, String gender, String id, String status, String env, String similarity, Date date, String url_now, String url_regist) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.status = status;
        this.env = env;
        this.similarity = similarity;
        this.date = date;
        this.url_now = url_now;
        this.url_regist = url_regist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl_now() {
        return url_now;
    }

    public void setUrl_now(String url_now) {
        this.url_now = url_now;
    }

    public String getUrl_regist() {
        return url_regist;
    }

    public void setUrl_regist(String url_regist) {
        this.url_regist = url_regist;
    }
}
