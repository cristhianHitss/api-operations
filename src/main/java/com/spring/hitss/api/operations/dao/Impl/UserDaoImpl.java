package com.spring.hitss.api.operations.dao.Impl;

import com.spring.hitss.api.operations.dao.UserDao;
import com.spring.hitss.api.operations.dto.user.UserDto;
import com.spring.hitss.api.operations.util.DatabaseConnection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by HItss on 22/12/2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    @Transactional
    public UserDto findById(String id) {
        Query filterByNameQuery = new Query();
        filterByNameQuery.addCriteria(Criteria.where("_id").is(id));
        UserDto userDto = databaseConnection.getDatabaseConnection().findOne(filterByNameQuery, UserDto.class);
        logger.info(userDto);
        return userDto;
    }

    @Override
    @Transactional
    public UserDto findByName(String name) {
        Query filterByNameQuery = new Query();
        filterByNameQuery.addCriteria(Criteria.where("username").is(name));
        UserDto userDto = databaseConnection.getDatabaseConnection().findOne(filterByNameQuery, UserDto.class);
        logger.info(userDto);
        return userDto;
    }

    @Override
    @Transactional
    public void save(UserDto user) {
        databaseConnection.getDatabaseConnection().save(user);
    }

    @Override
    @Transactional
    public void update(UserDto user) {
        databaseConnection.getDatabaseConnection().save(user);
    }

    @Override
    @Transactional
    public void delete(UserDto user) {
        databaseConnection.getDatabaseConnection().remove(user);
    }

    @Override
    @Transactional
    public List<UserDto> findAllUsers() {
        return  databaseConnection.getDatabaseConnection().findAll(UserDto.class);
    }

    @Override
    @Transactional
    public boolean isUserExist(UserDto user) {
        if(findByName(user.getUsername()) == null){
            return false;
        }else {
            return true;
        }
    }
}
