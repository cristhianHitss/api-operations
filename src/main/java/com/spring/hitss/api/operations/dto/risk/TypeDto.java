package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "TypeProyectRisk")
public class TypeDto {

    @Id
    private String Id;
    private String type_Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String gettype_Name() {
        return type_Name;
    }

    public void settype_Name(String type_Name) {
        type_Name = type_Name;
    }
}
