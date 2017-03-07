package com.spring.hitss.api.operations.dto.risk;

import com.spring.hitss.api.operations.dto.user.UserDto;

import java.util.Date;

/**
 * Created by HItss on 08/01/2017.
 */
public class CommentRiskDto {

    String Id;
    String id_User;
    String user_information;
    Date created_At;
    String comment;

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser_information() {
        return user_information;
    }

    public void setUser_information(String user_information) {
        this.user_information = user_information;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
