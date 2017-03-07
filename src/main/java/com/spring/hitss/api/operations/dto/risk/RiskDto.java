package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by HItss on 08/01/2017.
 */
@Document(collection = "Risk")
public class RiskDto {

    @Id
    private String Id;
    private Integer id_Proyect;
    private String proyect_Name;
    private String risk;
    private String id_Phase;
    private String id_Type;
    private String id_Source;
    private Date detection_Date;
    private String impact;
    private String potential_Causes;
    private Double id_Probability;
    private String id_Impact;
    private String priority;
    private Integer priority_order_identifier;
    private String id_Strategy;
    private String mitigation_Actions;
    private String contingency_actions;
    private String owner;
    private Date commitment_Date;
    private String id_Frequency_of_Monitoring;
    private String monitoring_Owner;
    private String id_Effectiveness_of_Actions;
    private String id_Status;
    private String tmp_comment;
    private List<CommentRiskDto> commentRisk = new ArrayList<>();

    public List<CommentRiskDto> getCommentRisk() {
        return commentRisk;
    }

    public void setCommentRisk(List<CommentRiskDto> commentRisk) {
        this.commentRisk = commentRisk;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProyect_Name() {
        return proyect_Name;
    }

    public void setProyect_Name(String proyect_Name) {
        this.proyect_Name = proyect_Name;
    }

    public Integer getId_Proyect() {
        return id_Proyect;
    }

    public void setId_Proyect(Integer id_Proyect) {
        this.id_Proyect = id_Proyect;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getId_Phase() {
        return id_Phase;
    }

    public void setId_Phase(String id_Phase) {
        this.id_Phase = id_Phase;
    }

    public String getId_Type() {
        return id_Type;
    }

    public void setId_Type(String id_Type) {
        this.id_Type = id_Type;
    }

    public String getId_Source() {
        return id_Source;
    }

    public void setId_Source(String id_Source) {
        this.id_Source = id_Source;
    }

    public Date getDetection_Date() {
        return detection_Date;
    }

    public void setDetection_Date(Date detection_Date) {
        this.detection_Date = detection_Date;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getPotential_Causes() {
        return potential_Causes;
    }

    public void setPotential_Causes(String potential_Causes) {
        this.potential_Causes = potential_Causes;
    }

    public Double getId_Probability() {
        return id_Probability;
    }

    public void setId_Probability(Double id_Probability) {
        this.id_Probability = id_Probability;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getId_Impact() {
        return id_Impact;
    }

    public void setId_Impact(String id_Impact) {
        this.id_Impact = id_Impact;
    }

    public String getId_Strategy() {
        return id_Strategy;
    }

    public void setId_Strategy(String id_Strategy) {
        this.id_Strategy = id_Strategy;
    }

    public String getMitigation_Actions() {
        return mitigation_Actions;
    }

    public void setMitigation_Actions(String mitigation_Actions) {
        this.mitigation_Actions = mitigation_Actions;
    }

    public String getContingency_actions() {
        return contingency_actions;
    }

    public void setContingency_actions(String contingency_actions) {
        this.contingency_actions = contingency_actions;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCommitment_Date() {
        return commitment_Date;
    }

    public void setCommitment_Date(Date commitment_Date) {
        this.commitment_Date = commitment_Date;
    }

    public String getId_Frequency_of_Monitoring() {
        return id_Frequency_of_Monitoring;
    }

    public void setId_Frequency_of_Monitoring(String id_Frequency_of_Monitoring) {
        this.id_Frequency_of_Monitoring = id_Frequency_of_Monitoring;
    }

    public String getMonitoring_Owner() {
        return monitoring_Owner;
    }

    public void setMonitoring_Owner(String monitoring_Owner) {
        this.monitoring_Owner = monitoring_Owner;
    }

    public String getId_Effectiveness_of_Actions() {
        return id_Effectiveness_of_Actions;
    }

    public void setId_Effectiveness_of_Actions(String id_Effectiveness_of_Actions) {
        this.id_Effectiveness_of_Actions = id_Effectiveness_of_Actions;
    }

    public String getId_Status() {
        return id_Status;
    }

    public void setId_Status(String id_Status) {
        this.id_Status = id_Status;
    }

    public Integer getPriority_order_identifier() {
        return priority_order_identifier;
    }

    public void setPriority_order_identifier(Integer priority_order_identifier) {
        this.priority_order_identifier = priority_order_identifier;
    }

    public String getTmp_comment() {
        return tmp_comment;
    }

    public void setTmp_comment(String tmp_comment) {
        this.tmp_comment = tmp_comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RiskDto)) return false;

        RiskDto riskDto = (RiskDto) o;

        if (getId() != null ? !getId().equals(riskDto.getId()) : riskDto.getId() != null) return false;
        if (getId_Proyect() != null ? !getId_Proyect().equals(riskDto.getId_Proyect()) : riskDto.getId_Proyect() != null)
            return false;
        if (getProyect_Name() != null ? !getProyect_Name().equals(riskDto.getProyect_Name()) : riskDto.getProyect_Name() != null)
            return false;
        if (getRisk() != null ? !getRisk().equals(riskDto.getRisk()) : riskDto.getRisk() != null) return false;
        if (getId_Phase() != null ? !getId_Phase().equals(riskDto.getId_Phase()) : riskDto.getId_Phase() != null)
            return false;
        if (getId_Type() != null ? !getId_Type().equals(riskDto.getId_Type()) : riskDto.getId_Type() != null)
            return false;
        if (getId_Source() != null ? !getId_Source().equals(riskDto.getId_Source()) : riskDto.getId_Source() != null)
            return false;
        if (getDetection_Date() != null ? !getDetection_Date().equals(riskDto.getDetection_Date()) : riskDto.getDetection_Date() != null)
            return false;
        if (getImpact() != null ? !getImpact().equals(riskDto.getImpact()) : riskDto.getImpact() != null) return false;
        if (getPotential_Causes() != null ? !getPotential_Causes().equals(riskDto.getPotential_Causes()) : riskDto.getPotential_Causes() != null)
            return false;
        if (getId_Probability() != null ? !getId_Probability().equals(riskDto.getId_Probability()) : riskDto.getId_Probability() != null)
            return false;
        if (getId_Impact() != null ? !getId_Impact().equals(riskDto.getId_Impact()) : riskDto.getId_Impact() != null)
            return false;
        if (getPriority() != null ? !getPriority().equals(riskDto.getPriority()) : riskDto.getPriority() != null)
            return false;
        if (getPriority_order_identifier() != null ? !getPriority_order_identifier().equals(riskDto.getPriority_order_identifier()) : riskDto.getPriority_order_identifier() != null)
            return false;
        if (getId_Strategy() != null ? !getId_Strategy().equals(riskDto.getId_Strategy()) : riskDto.getId_Strategy() != null)
            return false;
        if (getMitigation_Actions() != null ? !getMitigation_Actions().equals(riskDto.getMitigation_Actions()) : riskDto.getMitigation_Actions() != null)
            return false;
        if (getContingency_actions() != null ? !getContingency_actions().equals(riskDto.getContingency_actions()) : riskDto.getContingency_actions() != null)
            return false;
        if (getOwner() != null ? !getOwner().equals(riskDto.getOwner()) : riskDto.getOwner() != null) return false;
        if (getCommitment_Date() != null ? !getCommitment_Date().equals(riskDto.getCommitment_Date()) : riskDto.getCommitment_Date() != null)
            return false;
        if (getId_Frequency_of_Monitoring() != null ? !getId_Frequency_of_Monitoring().equals(riskDto.getId_Frequency_of_Monitoring()) : riskDto.getId_Frequency_of_Monitoring() != null)
            return false;
        if (getMonitoring_Owner() != null ? !getMonitoring_Owner().equals(riskDto.getMonitoring_Owner()) : riskDto.getMonitoring_Owner() != null)
            return false;
        if (getId_Effectiveness_of_Actions() != null ? !getId_Effectiveness_of_Actions().equals(riskDto.getId_Effectiveness_of_Actions()) : riskDto.getId_Effectiveness_of_Actions() != null)
            return false;
        if (getId_Status() != null ? !getId_Status().equals(riskDto.getId_Status()) : riskDto.getId_Status() != null)
            return false;
        return !(getCommentRisk() != null ? !getCommentRisk().equals(riskDto.getCommentRisk()) : riskDto.getCommentRisk() != null);

    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (id_Proyect != null ? id_Proyect.hashCode() : 0);
        result = 31 * result + (proyect_Name != null ? proyect_Name.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        result = 31 * result + (id_Phase != null ? id_Phase.hashCode() : 0);
        result = 31 * result + (id_Type != null ? id_Type.hashCode() : 0);
        result = 31 * result + (id_Source != null ? id_Source.hashCode() : 0);
        result = 31 * result + (detection_Date != null ? detection_Date.hashCode() : 0);
        result = 31 * result + (impact != null ? impact.hashCode() : 0);
        result = 31 * result + (potential_Causes != null ? potential_Causes.hashCode() : 0);
        result = 31 * result + (id_Probability != null ? id_Probability.hashCode() : 0);
        result = 31 * result + (id_Impact != null ? id_Impact.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (priority_order_identifier != null ? priority_order_identifier.hashCode() : 0);
        result = 31 * result + (id_Strategy != null ? id_Strategy.hashCode() : 0);
        result = 31 * result + (mitigation_Actions != null ? mitigation_Actions.hashCode() : 0);
        result = 31 * result + (contingency_actions != null ? contingency_actions.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (commitment_Date != null ? commitment_Date.hashCode() : 0);
        result = 31 * result + (id_Frequency_of_Monitoring != null ? id_Frequency_of_Monitoring.hashCode() : 0);
        result = 31 * result + (monitoring_Owner != null ? monitoring_Owner.hashCode() : 0);
        result = 31 * result + (id_Effectiveness_of_Actions != null ? id_Effectiveness_of_Actions.hashCode() : 0);
        result = 31 * result + (id_Status != null ? id_Status.hashCode() : 0);
        result = 31 * result + (commentRisk != null ? commentRisk.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RiskDto{" +
                "Id='" + Id + '\'' +
                ", id_Proyect=" + id_Proyect +
                ", proyect_Name='" + proyect_Name + '\'' +
                ", risk='" + risk + '\'' +
                ", id_Phase='" + id_Phase + '\'' +
                ", id_Type='" + id_Type + '\'' +
                ", id_Source='" + id_Source + '\'' +
                ", detection_Date=" + detection_Date +
                ", impact='" + impact + '\'' +
                ", potential_Causes='" + potential_Causes + '\'' +
                ", id_Probability=" + id_Probability +
                ", id_Impact='" + id_Impact + '\'' +
                ", priority='" + priority + '\'' +
                ", priority_order_identifier=" + priority_order_identifier +
                ", id_Strategy='" + id_Strategy + '\'' +
                ", mitigation_Actions='" + mitigation_Actions + '\'' +
                ", contingency_actions='" + contingency_actions + '\'' +
                ", owner='" + owner + '\'' +
                ", commitment_Date=" + commitment_Date +
                ", id_Frequency_of_Monitoring='" + id_Frequency_of_Monitoring + '\'' +
                ", monitoring_Owner='" + monitoring_Owner + '\'' +
                ", id_Effectiveness_of_Actions='" + id_Effectiveness_of_Actions + '\'' +
                ", id_Status='" + id_Status + '\'' +
                ", commentRisk=" + commentRisk +
                '}';
    }
}

