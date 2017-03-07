package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "PhaseProyectRisk")
public class PhaseDto {

    @Id
    private String Id;
    private String phase_Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getphase_Name() {
        return phase_Name;
    }

    public void setphase_Name(String phase_Name) {
        phase_Name = phase_Name;
    }
}
