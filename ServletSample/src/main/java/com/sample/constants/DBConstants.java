package com.sample.constants;

import com.sample.config.DBPropertiesConfig;

public class DBConstants {

	public static final String URL = DBPropertiesConfig.getProperties().getProperty("url").trim();   
	public static final String DRIVER_NAME = DBPropertiesConfig.getProperties().getProperty("driverName").trim(); 
	public static final String USERNAME = DBPropertiesConfig.getProperties().getProperty("userName").trim();
	public static final String PASSWORD = DBPropertiesConfig.getProperties().getProperty("password").trim();

}
