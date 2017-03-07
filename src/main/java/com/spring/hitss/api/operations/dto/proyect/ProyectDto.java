package com.spring.hitss.api.operations.dto.proyect;

import com.spring.hitss.api.operations.dto.rework.ReworkDto;
import com.spring.hitss.api.operations.dto.risk.RiskDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HItss on 10/01/2017.
 */
@Document(collection = "Proyect")
public class ProyectDto {

    @Id
    private String Id;
    private Integer proyect_Id;
    private String proyect_Name;
    private Integer id_Sector;
    private String sector;
    private Integer id_Customer;
    private String customer;
    private String proyect_Type;
    private String group;
    private String bussines_Line;
    private List<RiskDto> proyect_Risk = new ArrayList<>();
    private List<Risk_Type> risk_types = new ArrayList<>();
    private List<ReworkDto> proyect_Rework = new ArrayList<>();

    public String getProyect_Name() {
        return proyect_Name;
    }

    public void setProyect_Name(String proyect_Name) {
        this.proyect_Name = proyect_Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getProyect_Id() {
        return proyect_Id;
    }

    public void setProyect_Id(Integer proyect_Id) {
        this.proyect_Id = proyect_Id;
    }

    public Integer getId_Sector() {
        return id_Sector;
    }

    public void setId_Sector(Integer id_Sector) {
        this.id_Sector = id_Sector;
    }

    public Integer getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(Integer id_Customer) {
        this.id_Customer = id_Customer;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProyect_Type() {
        return proyect_Type;
    }

    public void setProyect_Type(String proyect_Type) {
        this.proyect_Type = proyect_Type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getBussines_Line() {
        return bussines_Line;
    }

    public void setBussines_Line(String bussines_Line) {
        this.bussines_Line = bussines_Line;
    }

    public List<RiskDto> getProyect_Risk() {
        return proyect_Risk;
    }

    public void setProyect_Risk(List<RiskDto> proyect_Risk) {
        this.proyect_Risk = proyect_Risk;
    }

    public List<Risk_Type> getRisk_type() {
        return risk_types;
    }

    public void setRisk_type(String type, Integer total) {
        Risk_Type risk_type = new Risk_Type(type, total);
        this.risk_types.add(risk_type);
    }

    public List<ReworkDto> getProyect_Rework() {
        return proyect_Rework;
    }

    public void setProyect_Rework(List<ReworkDto> proyect_Rework) {
        this.proyect_Rework = proyect_Rework;
    }

    @Override
    public String toString() {
        return "ProyectDto{" +
                "Id='" + Id + '\'' +
                ", proyect_Id=" + proyect_Id +
                ", proyect_Name='" + proyect_Name + '\'' +
                ", id_Sector=" + id_Sector +
                ", sector='" + sector + '\'' +
                ", id_Customer=" + id_Customer +
                ", customer='" + customer + '\'' +
                ", proyect_Type='" + proyect_Type + '\'' +
                ", group='" + group + '\'' +
                ", bussines_Line='" + bussines_Line + '\'' +
                ", proyect_Risk=" + proyect_Risk +
                '}';
    }

    class Risk_Type {
        String type;
        Integer total = 0;

        public Risk_Type(String type, Integer total) {
            this.type = type;
            this.total = total;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}