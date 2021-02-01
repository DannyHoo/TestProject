package com.code.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * @author danny
 * @date 2021/1/31下午3:21
 */
public class PropertyUtil {
    private static String DEFAULT_PROPERTY_NAME = "application.yml";

    public static String getStringProperty(String key) throws Exception {
        Resource resource = new ClassPathResource(DEFAULT_PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
            Object result = properties.get(key);
            if (result == null) {
                throw new Exception("property " + key + " does not exist");
            } else {
                return result.toString();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getStringProperty(String propertyName, String key) throws Exception {
        Resource resource;
        if (StringUtils.isEmpty(propertyName)) {
            resource = new ClassPathResource(DEFAULT_PROPERTY_NAME);
        } else {
            resource = new ClassPathResource(propertyName);
        }
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
            Object result = properties.get(key);
            if (result == null) {
                throw new Exception("property " + key + " does not exist");
            } else {
                return result.toString();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static Integer getIntegerProperty(String key) throws Exception {
        Resource resource = new ClassPathResource(DEFAULT_PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
            Object result = properties.get(key);
            if (result == null) {
                throw new Exception("property " + key + " does not exist");
            } else {
                return Integer.valueOf(result.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static Long getLongProperty(String key) throws Exception {
        Resource resource = new ClassPathResource(DEFAULT_PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
            Object result = properties.get(key);
            if (result == null) {
                throw new Exception("property " + key + " does not exist");
            } else {
                return Long.valueOf(result.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getStringProperty("custom.datasource.pool.nodename"));
    }

}
