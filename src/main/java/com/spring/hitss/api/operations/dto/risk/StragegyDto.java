package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
public @Document(collection = "StrategyProyectRisk")
class StragegyDto {

    @Id
    private String Id;
    private String stragegy_Name;

    public String getstragegy_Name() {
        return stragegy_Name;
    }

    public void setstragegy_Name(String stragegy_Name) {
        stragegy_Name = stragegy_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
