package com.spring.hitss.api.operations.dao.Impl;

import com.spring.hitss.api.operations.dao.RiskDao;
import com.spring.hitss.api.operations.dto.proyect.ProyectDto;
import com.spring.hitss.api.operations.dto.risk.*;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.util.DatabaseConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HItss on 09/01/2017.
 */
@Repository("RiskDao")
public class RiskDaoImpl implements RiskDao {

    private static Logger logger = Logger.getLogger(RiskDaoImpl.class);
    @Autowired
    DatabaseConnection databaseConnection;

    @Override
    @Transactional
    public RiskDto findById(String id) {
        Query filterByIdQuery = new Query();
        filterByIdQuery.addCriteria(Criteria.where("_id").is(id));
        RiskDto riskDto = databaseConnection.getDatabaseConnection().findOne(filterByIdQuery, RiskDto.class);
        logger.info(riskDto);
        return riskDto;
    }

    @Override
    public List<HistoricalModificationsDto> getAllHistoricById(String Id) {
        Query filterByIdQuery = new Query();
        filterByIdQuery.addCriteria(Criteria.where("id_risk").is(Id));
        return databaseConnection.getDatabaseConnection().find(filterByIdQuery, HistoricalModificationsDto.class);
    }

    @Override
    public ProyectDto findProyectRisksById(String id) {
        AggregationOperation group = Aggregation.lookup("Risk", "proyect_Id", "id_Proyect", "proyect_Risk");
        Aggregation aggregation = Aggregation.newAggregation(group);
        AggregationResults<ProyectDto> result = databaseConnection.getDatabaseConnection().aggregate(aggregation, "Proyect", ProyectDto.class);
        List<TypeDto> typeDtos = databaseConnection.getDatabaseConnection().findAll(TypeDto.class);
        for (int i = 0; i < result.getMappedResults().size(); i++) {
            for (TypeDto typeDto : typeDtos) {
                Integer err = 0;
                for (int j = 0; j < result.getMappedResults().get(i).getProyect_Risk().size(); j++) {
                    if (result.getMappedResults().get(i).getProyect_Risk().get(j).getId_Type().equalsIgnoreCase(typeDto.gettype_Name())) {
                        err++;
                    }
                }
                result.getMappedResults().get(i).setRisk_type(typeDto.gettype_Name(), err);
            }
            if (result.getMappedResults().get(i).getId().equalsIgnoreCase(id)) return result.getMappedResults().get(i);
        }
        return null;
    }

    @Override
    @Transactional
    public List<ProyectDto> getAllRiskProyect() {
        AggregationOperation group = Aggregation.lookup("Risk", "proyect_Id", "id_Proyect", "proyect_Risk");
        Aggregation aggregation = Aggregation.newAggregation(group);
        AggregationResults<ProyectDto> result = databaseConnection.getDatabaseConnection().aggregate(aggregation, "Proyect", ProyectDto.class);
        return result.getMappedResults();
    }

    @Override
    @Transactional
    public void save(RiskDto riskDto) {
        databaseConnection.getDatabaseConnection().save(riskDto);
    }

    @Override
    public void update(RiskDto riskDto) {
        databaseConnection.getDatabaseConnection().save(riskDto);
    }

    @Override
    @Transactional
    public RiskDependeciesDto getRiskDependencies() {
        List<EffectivenessActionsDto> effectivenessActionsDtos = databaseConnection.getDatabaseConnection().findAll(EffectivenessActionsDto.class);
        List<FrequencyMonitoringDto> frequencyMonitoringDtos = databaseConnection.getDatabaseConnection().findAll(FrequencyMonitoringDto.class);
        List<ImpactDto> impactDtos = databaseConnection.getDatabaseConnection().findAll(ImpactDto.class);
        List<PhaseDto> phaseDtos = databaseConnection.getDatabaseConnection().findAll(PhaseDto.class);
        List<ProbabilityDto> probabilityDtos = databaseConnection.getDatabaseConnection().findAll(ProbabilityDto.class);
        List<SourceDto> sourceDtos = databaseConnection.getDatabaseConnection().findAll(SourceDto.class);
        List<StatusDto> statusDtos = databaseConnection.getDatabaseConnection().findAll(StatusDto.class);
        List<StragegyDto> stragegyDtos = databaseConnection.getDatabaseConnection().findAll(StragegyDto.class);
        List<TypeDto> typeDtos = databaseConnection.getDatabaseConnection().findAll(TypeDto.class);
        return new RiskDependeciesDto(effectivenessActionsDtos, stragegyDtos, phaseDtos, impactDtos, frequencyMonitoringDtos, probabilityDtos, sourceDtos, statusDtos, typeDtos);
    }

    @Override
    public void saveHistorical(HistoricalModificationsDto historicalModificationsDto) {
        databaseConnection.getDatabaseConnection().save(historicalModificationsDto);
    }
}
