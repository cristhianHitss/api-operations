package com.spring.hitss.api.operations.dao;

import com.spring.hitss.api.operations.dto.log.LogDto;

import java.util.List;

/**
 * Created by HItss on 20/01/2017.
 */
public interface LogDao {

    void save(LogDto logDto);

    List<LogDto> findById(String id);
}
