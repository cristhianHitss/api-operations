package com.spring.hitss.api.operations.service;

import com.spring.hitss.api.operations.dao.OperationDao;
import com.spring.hitss.api.operations.dto.operation.OperationDto;
import com.spring.hitss.api.operations.dto.operation.SearchEngineRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HItss on 05/01/2017.
 */
@Service
public class OperationService {

    @Autowired
    OperationDao operationDao;

    public List<List<OperationDto>> delegateSearch(SearchEngineRequestDto searchEngineRequestDto) {
        List<List<OperationDto>> tmplist = new ArrayList<>();
        if (searchEngineRequestDto.getYear() != null && searchEngineRequestDto.getCountry() != null) {
            if (searchEngineRequestDto.getGroup() != null) {
                if (searchEngineRequestDto.getBussines_Line() != null) {
                    return obtainProyectTypeResult(searchEngineRequestDto, "GroupQuery", searchEngineRequestDto.getGroup());
                }
                return obtainBussinesLineResult(searchEngineRequestDto, "GroupQuery", searchEngineRequestDto.getGroup());
            }
            if (searchEngineRequestDto.getClient() != null) {
                if (searchEngineRequestDto.getBussines_Line() != null) {
                    return obtainProyectTypeResult(searchEngineRequestDto, "ClientQuery", searchEngineRequestDto.getClient());
                }
                return obtainBussinesLineResult(searchEngineRequestDto, "ClientQuery", searchEngineRequestDto.getClient());
            }
            if (searchEngineRequestDto.getBussines_Line() != null) {
                return obtainProyectTypeResult(searchEngineRequestDto, "", null);
            }
            return obtainGroupCustomerBussinesLineProjectTypeResult(searchEngineRequestDto);
        } else if (searchEngineRequestDto.getList_of_Countries() != null) {
            tmplist.add(obtainSearchCountryResult(searchEngineRequestDto));
            return tmplist;
        }
        return null;
    }

    public List<OperationDto> obtainSearchCountryResult(SearchEngineRequestDto searchEngineRequestDto) {
        return operationDao.getSearchResultCountry(searchEngineRequestDto.getList_of_Countries(), searchEngineRequestDto.getYear());
    }

    public List<List<OperationDto>> obtainGroupCustomerBussinesLineProjectTypeResult(SearchEngineRequestDto searchEngineRequestDto) {
        return operationDao.getGroupCustomerBussinesLineProjectTypeResult(searchEngineRequestDto.getList_of_Countries(), searchEngineRequestDto.getCountry());
    }

    public List<List<OperationDto>> obtainBussinesLineResult(SearchEngineRequestDto searchEngineRequestDto, String define_column_query, String define_column_value) {
        return operationDao.getBussinesLineResult(define_column_query, define_column_value, searchEngineRequestDto.getList_of_Countries(), searchEngineRequestDto.getCountry(), searchEngineRequestDto.getYear());
    }

    public List<List<OperationDto>> obtainProyectTypeResult(SearchEngineRequestDto searchEngineRequestDto, String define_column_query, String define_column_value) {
        return operationDao.getProyectTypeResult(define_column_query, define_column_value, searchEngineRequestDto.getList_of_Countries(), searchEngineRequestDto.getCountry(), searchEngineRequestDto.getYear(), searchEngineRequestDto.getBussines_Line());
    }
}
