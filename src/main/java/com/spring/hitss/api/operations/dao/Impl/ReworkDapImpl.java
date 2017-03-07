package com.spring.hitss.api.operations.dao.Impl;

import com.spring.hitss.api.operations.dao.ReworkDao;
import com.spring.hitss.api.operations.dto.proyect.ProyectDto;
import com.spring.hitss.api.operations.dto.risk.TypeDto;
import com.spring.hitss.api.operations.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by HItss on 08/02/2017.
 */
@Repository("ReworkDapImpl")
public class ReworkDapImpl implements ReworkDao {

    @Autowired
    private DatabaseConnection databaseConnection;


    @Override
    @Transactional
    public List<ProyectDto> getAllReworkProyects() {
        AggregationOperation group = Aggregation.lookup("Rework", "proyect_Id", "id_Proyect", "proyect_Rework");
        Aggregation aggregation = Aggregation.newAggregation(group);
        AggregationResults<ProyectDto> result = databaseConnection.getDatabaseConnection().aggregate(aggregation, "Proyect", ProyectDto.class);
        return result.getMappedResults();
    }
}
