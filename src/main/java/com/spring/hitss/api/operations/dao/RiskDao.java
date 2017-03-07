package com.spring.hitss.api.operations.dao;

import com.spring.hitss.api.operations.dto.proyect.ProyectDto;
import com.spring.hitss.api.operations.dto.risk.HistoricalModificationsDto;
import com.spring.hitss.api.operations.dto.risk.RiskDependeciesDto;
import com.spring.hitss.api.operations.dto.risk.RiskDto;

import java.util.List;

/**
 * Created by HItss on 09/01/2017.
 */
public interface RiskDao {

    RiskDto findById(String Id);

    ProyectDto findProyectRisksById(String Id);

    List<HistoricalModificationsDto> getAllHistoricById(String Id);

    List<ProyectDto> getAllRiskProyect();

    void save(RiskDto riskDto);

    void update(RiskDto riskDto);

    void saveHistorical(HistoricalModificationsDto historicalModificationsDto);

    RiskDependeciesDto getRiskDependencies();
}
