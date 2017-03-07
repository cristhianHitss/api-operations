package com.spring.hitss.api.operations.dto.operation;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by HItss on 03/01/2017.
 */
@Component
public class SearchEngineRequestDto implements Serializable{

    private Integer year;
    private String  list_of_Countries;
    private String  country;
    private String  group;
    private String  bussines_Line;
    private String  project_Type;
    private String  client;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProject_Type() {
        return project_Type;
    }

    public void setProject_Type(String project_Type) {
        this.project_Type = project_Type;
    }

    public String getBussines_Line() {
        return bussines_Line;
    }

    public void setBussines_Line(String bussines_Line) {
        this.bussines_Line = bussines_Line;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getList_of_Countries() {
        return list_of_Countries;
    }

    public void setList_of_Countries(String list_of_Countries) {
        this.list_of_Countries = list_of_Countries;
    }

    @Override
    public String toString() {
        return "SearchEngineRequestDto{" +
                "year=" + year +
                ", list_of_Countries='" + list_of_Countries + '\'' +
                ", country='" + country + '\'' +
                ", group='" + group + '\'' +
                ", bussines_Line='" + bussines_Line + '\'' +
                ", project_Type='" + project_Type + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
