package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "SourceProyectRisk")
public class SourceDto {

    @Id
    private String Id;
    private String source_Name;

    public String getsource_Name() {
        return source_Name;
    }

    public void setsource_Name(String source_Name) {
        source_Name = source_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}

