package com.spring.hitss.api.operations.service;

import com.spring.hitss.api.operations.dao.UserDao;
import com.spring.hitss.api.operations.dto.risk.CommentRiskDto;
import com.spring.hitss.api.operations.dto.risk.HistoricalModificationsDto;
import com.spring.hitss.api.operations.dto.risk.RiskDto;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.facade.AuthenticationFacade;
import com.spring.hitss.api.operations.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by HItss on 07/02/2017.
 */
@Service("RiskService")
public class RiskService {

    @Autowired
    private AuthenticationFacade authenticationFacade;


    @Autowired
    private UserDao userDao;

    public CommentRiskDto getComment(String tmp_comment) {
        UserDto userDto = userDao.findByName(authenticationFacade.getAuthentication().getName());
        CommentRiskDto commentRiskDto = new CommentRiskDto();
        commentRiskDto.setId(UUID.randomUUID().toString());
        commentRiskDto.setId_User(userDto.getId());
        commentRiskDto.setUser_information(userDto.getName() + " " + userDto.getLastname());
        if (tmp_comment == null) commentRiskDto.setComment(Utils.INIT_COMMENT_MESSAGE_RISK);
        if (tmp_comment != null) commentRiskDto.setComment(tmp_comment);
        commentRiskDto.setCreated_At(new Date());
        return commentRiskDto;
    }


    public HistoricalModificationsDto CheckChangesFields(RiskDto dbriskDto, RiskDto requestriskDto, RiskDto tmp_riskDto) {
        UserDto userDto = userDao.findByName(authenticationFacade.getAuthentication().getName());
        HistoricalModificationsDto historicalModificationsDto = new HistoricalModificationsDto(userDto.getName() + " " + userDto.getLastname(), new Date(), tmp_riskDto.getId(), tmp_riskDto.getTmp_comment());
        RiskDto riskDto = requestriskDto;

        if (dbriskDto.getId() != null ? !dbriskDto.getId().equals(riskDto.getId()) : riskDto.getId() != null)
            historicalModificationsDto.setModificationFieldDtos("Id", dbriskDto.getId(), requestriskDto.getId());
        if (dbriskDto.getId_Proyect() != null ? !dbriskDto.getId_Proyect().equals(riskDto.getId_Proyect()) : riskDto.getId_Proyect() != null)
            historicalModificationsDto.setModificationFieldDtos("Id Proyecto", dbriskDto.getId_Proyect().toString(), requestriskDto.getId_Proyect().toString());
        if (dbriskDto.getProyect_Name() != null ? !dbriskDto.getProyect_Name().equals(riskDto.getProyect_Name()) : riskDto.getProyect_Name() != null)
            historicalModificationsDto.setModificationFieldDtos("Nombre Proyecto", dbriskDto.getProyect_Name(), requestriskDto.getProyect_Name());
        if (dbriskDto.getRisk() != null ? !dbriskDto.getRisk().equals(riskDto.getRisk()) : riskDto.getRisk() != null)
            historicalModificationsDto.setModificationFieldDtos("Riesgo", dbriskDto.getRisk(), requestriskDto.getRisk());
        if (dbriskDto.getId_Phase() != null ? !dbriskDto.getId_Phase().equals(riskDto.getId_Phase()) : riskDto.getId_Phase() != null)
            historicalModificationsDto.setModificationFieldDtos("Fase", dbriskDto.getId_Phase(), requestriskDto.getId_Phase());
        if (dbriskDto.getId_Type() != null ? !dbriskDto.getId_Type().equals(riskDto.getId_Type()) : riskDto.getId_Type() != null)
            historicalModificationsDto.setModificationFieldDtos("Tipo", dbriskDto.getId_Type(), requestriskDto.getId_Type());
        if (dbriskDto.getId_Source() != null ? !dbriskDto.getId_Source().equals(riskDto.getId_Source()) : riskDto.getId_Source() != null)
            historicalModificationsDto.setModificationFieldDtos("Fuente", dbriskDto.getId_Source(), requestriskDto.getId_Source());
        if (dbriskDto.getDetection_Date() != null ? !dbriskDto.getDetection_Date().equals(riskDto.getDetection_Date()) : riskDto.getDetection_Date() != null)
            historicalModificationsDto.setModificationFieldDtos("Fecha Deteccion", dbriskDto.getDetection_Date().toString(), requestriskDto.getDetection_Date().toString());
        if (dbriskDto.getImpact() != null ? !dbriskDto.getImpact().equals(riskDto.getImpact()) : riskDto.getImpact() != null)
            historicalModificationsDto.setModificationFieldDtos("Impacto", dbriskDto.getImpact(), requestriskDto.getImpact());
        if (dbriskDto.getPotential_Causes() != null ? !dbriskDto.getPotential_Causes().equals(riskDto.getPotential_Causes()) : riskDto.getPotential_Causes() != null)
            historicalModificationsDto.setModificationFieldDtos("Causas Potenciales", dbriskDto.getPotential_Causes(), requestriskDto.getPotential_Causes());
        if (dbriskDto.getId_Probability() != null ? !dbriskDto.getId_Probability().equals(riskDto.getId_Probability()) : riskDto.getId_Probability() != null)
            historicalModificationsDto.setModificationFieldDtos("Probabilidad", dbriskDto.getId_Probability().toString(), requestriskDto.getId_Probability().toString());
        if (dbriskDto.getId_Impact() != null ? !dbriskDto.getId_Impact().equals(riskDto.getId_Impact()) : riskDto.getId_Impact() != null)
            historicalModificationsDto.setModificationFieldDtos("Impacto", dbriskDto.getId_Impact(), requestriskDto.getId_Impact());
        if (dbriskDto.getId_Strategy() != null ? !dbriskDto.getId_Strategy().equals(riskDto.getId_Strategy()) : riskDto.getId_Strategy() != null)
            historicalModificationsDto.setModificationFieldDtos("Estrategia", dbriskDto.getId_Strategy(), requestriskDto.getId_Strategy());
        if (dbriskDto.getMitigation_Actions() != null ? !dbriskDto.getMitigation_Actions().equals(riskDto.getMitigation_Actions()) : riskDto.getMitigation_Actions() != null)
            historicalModificationsDto.setModificationFieldDtos("Acciones de Mitigacion", dbriskDto.getMitigation_Actions(), requestriskDto.getMitigation_Actions());
        if (dbriskDto.getContingency_actions() != null ? !dbriskDto.getContingency_actions().equals(riskDto.getContingency_actions()) : riskDto.getContingency_actions() != null)
            historicalModificationsDto.setModificationFieldDtos("Acciones de Contingencia", dbriskDto.getContingency_actions(), requestriskDto.getContingency_actions());
        if (dbriskDto.getOwner() != null ? !dbriskDto.getOwner().equals(riskDto.getOwner()) : riskDto.getOwner() != null)
            historicalModificationsDto.setModificationFieldDtos("Responsable", dbriskDto.getOwner(), requestriskDto.getOwner());
        if (dbriskDto.getCommitment_Date() != null ? !dbriskDto.getCommitment_Date().equals(riskDto.getCommitment_Date()) : riskDto.getCommitment_Date() != null)
            historicalModificationsDto.setModificationFieldDtos("Fecha Compromiso", dbriskDto.getCommitment_Date().toString(), requestriskDto.getCommitment_Date().toString());
        if (dbriskDto.getId_Frequency_of_Monitoring() != null ? !dbriskDto.getId_Frequency_of_Monitoring().equals(riskDto.getId_Frequency_of_Monitoring()) : riskDto.getId_Frequency_of_Monitoring() != null)
            historicalModificationsDto.setModificationFieldDtos("Frecuencia de Monitoreo", dbriskDto.getId_Frequency_of_Monitoring(), requestriskDto.getId_Frequency_of_Monitoring());
        if (dbriskDto.getMonitoring_Owner() != null ? !dbriskDto.getMonitoring_Owner().equals(riskDto.getMonitoring_Owner()) : riskDto.getMonitoring_Owner() != null)
            historicalModificationsDto.setModificationFieldDtos("Responsable Monitoreo", dbriskDto.getMonitoring_Owner(), requestriskDto.getMonitoring_Owner());
        if (dbriskDto.getId_Effectiveness_of_Actions() != null ? !dbriskDto.getId_Effectiveness_of_Actions().equals(riskDto.getId_Effectiveness_of_Actions()) : riskDto.getId_Effectiveness_of_Actions() != null)
            historicalModificationsDto.setModificationFieldDtos("Efectividad de las Acciones", dbriskDto.getId_Effectiveness_of_Actions(), requestriskDto.getId_Effectiveness_of_Actions());
        if (dbriskDto.getId_Status() != null ? !dbriskDto.getId_Status().equals(riskDto.getId_Status()) : riskDto.getId_Status() != null)
            historicalModificationsDto.setModificationFieldDtos("Estatus", dbriskDto.getId_Status(), requestriskDto.getId_Status());
        return historicalModificationsDto;
    }
}
