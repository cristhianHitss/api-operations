package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "FrequencyMonitoringProyectRisk")
public class FrequencyMonitoringDto {

    @Id
    private String Id;
    private String frequencyMonitoring_Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getfrequencyMonitoring_Name() {
        return frequencyMonitoring_Name;
    }

    public void setfrequencyMonitoring_Name(String frequencyMonitoring_Name) {
        frequencyMonitoring_Name = frequencyMonitoring_Name;
    }
}
