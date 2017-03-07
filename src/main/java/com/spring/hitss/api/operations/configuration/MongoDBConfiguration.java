package com.spring.hitss.api.operations.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by HItss on 22/12/2016.
 */
@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    private static Logger logger = Logger.getLogger(MongoDBConfiguration.class);

    @Autowired
    ConfigurationValues configurationValues;

    @Override
    protected String getDatabaseName() {
        return configurationValues.getPropertieValues("com.spring.hitss.operations.database.databasename");
    }

    @Override
    @Bean
    public Mongo mongo(){
        return new MongoClient(configurationValues.getPropertieValues("com.spring.hitss.operations.database.host"));
    }

}
