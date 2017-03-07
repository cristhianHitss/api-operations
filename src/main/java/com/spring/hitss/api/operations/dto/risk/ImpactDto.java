package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
public @Document(collection = "ImpactProyectRisk")
class ImpactDto {
    @Id
    private String Id;
    private String impact_Name;
    private Integer impact_Value;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getimpact_Name() {
        return impact_Name;
    }

    public void setimpact_Name(String impact_Name) {
        impact_Name = impact_Name;
    }

    public Integer getimpact_Value() {
        return impact_Value;
    }

    public void setimpact_Value(Integer impact_Value) {
        impact_Value = impact_Value;
    }
}
