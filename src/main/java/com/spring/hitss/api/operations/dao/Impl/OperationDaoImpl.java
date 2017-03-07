package com.spring.hitss.api.operations.dao.Impl;

import com.mongodb.BasicDBObject;
import com.spring.hitss.api.operations.dao.OperationDao;
import com.spring.hitss.api.operations.dto.operation.OperationDto;
import com.spring.hitss.api.operations.dto.operation.SearchEngineRequestDto;
import com.spring.hitss.api.operations.util.DatabaseConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HItss on 04/01/2017.
 */
@Repository("operationDao")
public class OperationDaoImpl implements OperationDao {

    private static Logger logger = Logger.getLogger(OperationDaoImpl.class);

    @Autowired
    DatabaseConnection databaseConnection;
    private Integer year;
    private String  list_of_Countries;
    private String  country;
    private String  group;
    private String  bussines_Line;
    private String  project_Type;
    private String  client;

    @Override
    @Transactional
    public List<OperationDto> getSearchResult(SearchEngineRequestDto searchEngineRequestDto) {
        Query filterQuery = new Query();
        if(searchEngineRequestDto.getYear() !=null)filterQuery.addCriteria(Criteria.where("Anio").is(searchEngineRequestDto.getYear()));
        if(searchEngineRequestDto.getList_of_Countries() !=null){
        }
        logger.info(filterQuery);
        List<OperationDto> userDto = databaseConnection.getDatabaseConnection().find(filterQuery, OperationDto.class);
        logger.info(userDto);

        return null;
    }

    @Override
    @Transactional
    public List<OperationDto> getSearchResultCountry(String country_column, Integer year) {
        BasicDBObject whereInstruction = new BasicDBObject();
        whereInstruction.append("Anio", year);
        List<OperationDto> operationDtoList = databaseConnection.getDatabaseConnection().getCollection("Operation").distinct(country_column, whereInstruction);
        logger.info(operationDtoList);
        return operationDtoList;
    }

    @Override
    @Transactional
    public List<List<OperationDto>> getGroupCustomerBussinesLineProjectTypeResult(String country_column, String country) {
        List<List<OperationDto>> groupCustomerBussinesLineProjectTypeList = new ArrayList<>();
        BasicDBObject whereInstruction = new BasicDBObject(country_column, country);
        logger.info(whereInstruction);
        groupCustomerBussinesLineProjectTypeList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Agrupacion", whereInstruction));
        groupCustomerBussinesLineProjectTypeList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Cliente", whereInstruction));
        groupCustomerBussinesLineProjectTypeList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Linea_Negocio", whereInstruction));
        groupCustomerBussinesLineProjectTypeList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Tipo_Proyecto", whereInstruction));
        logger.info(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Agrupacion", whereInstruction));
        return groupCustomerBussinesLineProjectTypeList;
    }

    @Override
    @Transactional
    public List<List<OperationDto>> getBussinesLineResult(String define_column_query, String params, String country_column, String country, Integer year) {
        List<List<OperationDto>> bussinesslineList = new ArrayList<>();
        BasicDBObject whereInstruction = new BasicDBObject();
        whereInstruction.append("Anio", year);
        whereInstruction.append(country_column, country);
        if (define_column_query.equalsIgnoreCase("GroupQuery")) whereInstruction.append("Agrupacion", params);
        if (define_column_query.equalsIgnoreCase("ClientQuery")) whereInstruction.append("Cliente", params);
        logger.info(whereInstruction);
        bussinesslineList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Linea_Negocio", whereInstruction));
        return bussinesslineList;
    }

    @Override
    @Transactional
    public List<List<OperationDto>> getProyectTypeResult(String define_column_query,String params,String country_column, String country, Integer year, String bussiness_line) {
        List<List<OperationDto>> proyecttimeList = new ArrayList<>();
        BasicDBObject whereInstruction = new BasicDBObject();
        whereInstruction.append("Anio", year);
        whereInstruction.append(country_column, country);
        whereInstruction.append("Linea_Negocio", bussiness_line);
        if (define_column_query.equalsIgnoreCase("GroupQuery")) whereInstruction.append("Agrupacion", params);
        if (define_column_query.equalsIgnoreCase("ClientQuery")) whereInstruction.append("Cliente", params);
        logger.info(whereInstruction);
        logger.info(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Tipo_Proyecto", whereInstruction));
        proyecttimeList.add(databaseConnection.getDatabaseConnection().getCollection("Operation").distinct("Tipo_Proyecto", whereInstruction));
        return proyecttimeList;
    }

}
