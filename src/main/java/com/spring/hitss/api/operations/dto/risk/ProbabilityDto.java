package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "ProbabilityProyectRisk")
public class ProbabilityDto {

    @Id
    private String Id;
    private String probability_Name;
    private Double probability_Value;

    public String getprobability_Name() {
        return probability_Name;
    }

    public void setprobability_Name(String probability_Name) {
        probability_Name = probability_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Double getprobability_Value() {
        return probability_Value;
    }

    public void setprobability_Value(Double probability_Value) {
        probability_Value = probability_Value;
    }
}
