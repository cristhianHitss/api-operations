package com.spring.hitss.api.operations.dao.Impl;

import com.spring.hitss.api.operations.dao.LogDao;
import com.spring.hitss.api.operations.dto.log.LogDto;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.util.DatabaseConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HItss on 20/01/2017.
 */
@Repository("LogDaoImpl")
public class LogDaoImpl implements LogDao {

    private static Logger logger = Logger.getLogger(LogDaoImpl.class);
    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    public void save(LogDto logDto) {
        databaseConnection.getDatabaseConnection().save(logDto);
    }

    @Override
    public List<LogDto> findById(String id) {
        Query filterByNameQuery = new Query();
        filterByNameQuery.addCriteria(Criteria.where("id_user").is(id));
        filterByNameQuery.with(new Sort(Sort.Direction.DESC, "date"));
        logger.info(filterByNameQuery);
        List<LogDto> useLogDtos = databaseConnection.getDatabaseConnection().find(filterByNameQuery, LogDto.class);
        logger.info(useLogDtos);
        return useLogDtos;
    }
}
