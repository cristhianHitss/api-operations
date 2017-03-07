package com.spring.hitss.api.operations.configuration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Properties;

/**
 * Created by HItss on 22/12/2016.
 */
@Component
public class ConfigurationValues {

    private static Logger logger = Logger.getLogger(ConfigurationValues.class);

    public String getPropertieValues(String KeyValue) {
        //logger.info("Loading configuration value ["+KeyValue+"]");
        File file = new File("/home/casta9410/application/config/configuration.properties");
        //File file = new File("C:\\configuration\\configuration.properties");
        InputStream input = null;
        Properties properties = new Properties();
        try {
            input = new FileInputStream(file);
            properties.load(input);
            input.close();
        }catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
        String result = properties.getProperty(KeyValue);
        return result;
    }

}
