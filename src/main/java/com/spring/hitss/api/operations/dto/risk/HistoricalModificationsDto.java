package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HItss on 07/02/2017.
 */
@Document(collection = "HistoricalModifications")
public class HistoricalModificationsDto {

    @Id
    private String Id;
    private String owner;
    private Date created_at;
    private String id_risk;
    private String tmp_comment;
    private List<ModificationFieldDto> modificationFieldDtos = new ArrayList<>();

    public HistoricalModificationsDto(String owner, Date created_at, String id_risk, String tmp_comment) {
        this.owner = owner;
        this.created_at = created_at;
        this.id_risk = id_risk;
        this.tmp_comment = tmp_comment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getId_risk() {
        return id_risk;
    }

    public void setId_risk(String id_risk) {
        this.id_risk = id_risk;
    }

    public String getTmp_comment() {
        return tmp_comment;
    }

    public void setTmp_comment(String tmp_comment) {
        this.tmp_comment = tmp_comment;
    }

    public List<ModificationFieldDto> getModificationFieldDtos() {
        return modificationFieldDtos;
    }

    public void setModificationFieldDtos(String field_name, String old_text, String new_text) {
        String s = "cambiado \"" + old_text + "\" por \"" + new_text + "\".";
        this.modificationFieldDtos.add(new ModificationFieldDto(field_name, s));
    }
}

class ModificationFieldDto {

    private String field_name;
    private String field_message;

    public ModificationFieldDto(String field_name, String field_message) {
        this.field_name = field_name;
        this.field_message = field_message;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getField_message() {
        return field_message;
    }

    public void setField_message(String field_message) {
        this.field_message = field_message;
    }
}