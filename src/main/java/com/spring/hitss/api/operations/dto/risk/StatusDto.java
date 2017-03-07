package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "StatusProyectRisk")
public class StatusDto {

    @Id
    private String Id;
    private String status_Name;

    public String getstatus_Name() {
        return status_Name;
    }

    public void setstatus_Name(String status_Name) {
        status_Name = status_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
