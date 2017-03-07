package com.spring.hitss.api.operations.dto.log;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by HItss on 20/01/2017.
 */
@Document(collection = "LogActivity")
public class LogDto {

    @Id
    private String Id;
    private String id_user;
    private String detail_user;
    private String access_token;
    private String module;
    private String detail_activity;
    private Date date;

    public LogDto(String id_user, String module, String detail_activity, Date date, String access_token, String detail_user) {
        this.detail_user = detail_user;
        this.access_token = access_token;
        this.id_user = id_user;
        this.module = module;
        this.detail_activity = detail_activity;
        this.date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail_activity() {
        return detail_activity;
    }

    public void setDetail_activity(String detail_activity) {
        this.detail_activity = detail_activity;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getDetail_user() {
        return detail_user;
    }

    public void setDetail_user(String detail_user) {
        this.detail_user = detail_user;
    }
}
