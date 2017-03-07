package com.spring.hitss.api.operations.dto.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * Created by HItss on 22/12/2016.
 */
@Component
@Document(collection = "User")
public class UserDto {

    @Id
    private String  id;
    private String  username;
    private String  password;
    private String  name;
    private String  lastname;
    private String  email;
    private Integer usertype; // 1=>Administrator   2=>Operation   3=>Visitor
    private String  usertypedetail;
    private String  privileges;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getUsertypedetail() {
        return usertypedetail;
    }

    public void setUsertypedetail(String usertypedetail) {
        this.usertypedetail = usertypedetail;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", usertype=" + usertype +
                ", usertypedetail='" + usertypedetail + '\'' +
                ", privileges='" + privileges + '\'' +
                '}';
    }
}
