package com.spring.hitss.api.operations.dto.risk;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HItss on 19/01/2017.
 */
@Document(collection = "")
public class RiskDependeciesDto {

    private List<EffectivenessActionsDto> effectivenessActionsDtos = new ArrayList<>();
    private List<FrequencyMonitoringDto> frequencyMonitoringDtos = new ArrayList<>();
    private List<ImpactDto> impactDtos = new ArrayList<>();
    private List<PhaseDto> phaseDtos = new ArrayList<>();
    private List<ProbabilityDto> probabilityDtos = new ArrayList<>();
    private List<SourceDto> sourceDtos = new ArrayList<>();
    private List<StatusDto> statusDtos = new ArrayList<>();
    private List<StragegyDto> stragegyDtos = new ArrayList<>();
    private List<TypeDto> typeDtos = new ArrayList<>();

    public RiskDependeciesDto(List<EffectivenessActionsDto> effectivenessActionsDtos, List<StragegyDto> stragegyDtos, List<PhaseDto> phaseDtos, List<ImpactDto> impactDtos, List<FrequencyMonitoringDto> frequencyMonitoringDtos, List<ProbabilityDto> probabilityDtos, List<SourceDto> sourceDtos, List<StatusDto> statusDtos,List<TypeDto> typeDtos) {
        this.effectivenessActionsDtos = effectivenessActionsDtos;
        this.stragegyDtos = stragegyDtos;
        this.phaseDtos = phaseDtos;
        this.impactDtos = impactDtos;
        this.frequencyMonitoringDtos = frequencyMonitoringDtos;
        this.probabilityDtos = probabilityDtos;
        this.sourceDtos = sourceDtos;
        this.statusDtos = statusDtos;
        this.typeDtos = typeDtos;
    }

    public List<EffectivenessActionsDto> getEffectivenessActionsDtos() {
        return effectivenessActionsDtos;
    }

    public void setEffectivenessActionsDtos(List<EffectivenessActionsDto> effectivenessActionsDtos) {
        this.effectivenessActionsDtos = effectivenessActionsDtos;
    }

    public List<FrequencyMonitoringDto> getFrequencyMonitoringDtos() {
        return frequencyMonitoringDtos;
    }

    public void setFrequencyMonitoringDtos(List<FrequencyMonitoringDto> frequencyMonitoringDtos) {
        this.frequencyMonitoringDtos = frequencyMonitoringDtos;
    }

    public List<ImpactDto> getImpactDtos() {
        return impactDtos;
    }

    public void setImpactDtos(List<ImpactDto> impactDtos) {
        this.impactDtos = impactDtos;
    }

    public List<PhaseDto> getPhaseDtos() {
        return phaseDtos;
    }

    public void setPhaseDtos(List<PhaseDto> phaseDtos) {
        this.phaseDtos = phaseDtos;
    }

    public List<ProbabilityDto> getProbabilityDtos() {
        return probabilityDtos;
    }

    public void setProbabilityDtos(List<ProbabilityDto> probabilityDtos) {
        this.probabilityDtos = probabilityDtos;
    }

    public List<SourceDto> getSourceDtos() {
        return sourceDtos;
    }

    public void setSourceDtos(List<SourceDto> sourceDtos) {
        this.sourceDtos = sourceDtos;
    }

    public List<StatusDto> getStatusDtos() {
        return statusDtos;
    }

    public void setStatusDtos(List<StatusDto> statusDtos) {
        this.statusDtos = statusDtos;
    }

    public List<StragegyDto> getStragegyDtos() {
        return stragegyDtos;
    }

    public void setStragegyDtos(List<StragegyDto> stragegyDtos) {
        this.stragegyDtos = stragegyDtos;
    }

    public List<TypeDto> getTypeDtos() {
        return typeDtos;
    }

    public void setTypeDtos(List<TypeDto> typeDtos) {
        this.typeDtos = typeDtos;
    }
}

