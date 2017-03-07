package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "EffectivenessActionsProyectRisk")
public class EffectivenessActionsDto {

    @Id
    private String Id;
    private String effectivenessActions_Name;

    public String getEffectivenessActions_Name() {
        return effectivenessActions_Name;
    }

    public void setEffectivenessActions_Name(String effectivenessActions_Name) {
        effectivenessActions_Name = effectivenessActions_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
