package com.spring.hitss.api.operations.dao;

import com.spring.hitss.api.operations.dto.operation.OperationDto;
import com.spring.hitss.api.operations.dto.operation.SearchEngineRequestDto;

import java.util.List;

/**
 * Created by HItss on 04/01/2017.
 */
public interface OperationDao {

    List<OperationDto> getSearchResult(SearchEngineRequestDto searchEngineRequestDto);

    List<OperationDto> getSearchResultCountry(String country_column, Integer year);

    List<List<OperationDto>> getGroupCustomerBussinesLineProjectTypeResult(String country_column, String country);

    List<List<OperationDto>> getBussinesLineResult(String define_column_query, String params, String country_column, String country, Integer year);

    List<List<OperationDto>> getProyectTypeResult(String define_column_query, String params, String country_column, String country, Integer year, String bussiness_line);

}
