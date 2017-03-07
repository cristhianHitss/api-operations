package com.spring.hitss.api.operations.util;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by HItss on 22/12/2016.
 */
@Component
public class DatabaseConnection {

    @Autowired
    private ApplicationContext applicationContext;

    public MongoOperations getDatabaseConnection(){
        MongoOperations mongoOperation = applicationContext.getBean(MongoTemplate.class);
        return  mongoOperation;
    }
}
