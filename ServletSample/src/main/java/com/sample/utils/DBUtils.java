package com.sample.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.sample.constants.DBConstants;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;
/*
 * author Saravana Ganesh
 * created on 24-June-2021
 */
public class DBUtils {
	static OracleConnectionPoolDataSource dataSource = null;
	static {		
			OracleConnectionPoolDataSource dataSource;
			try {
				dataSource = new OracleConnectionPoolDataSource();
				dataSource.setURL(DBConstants.URL);
				dataSource.setUser(DBConstants.USERNAME);
				dataSource.setPassword(DBConstants.PASSWORD);	
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
	}	  
	public static Connection getDbConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
	}
} 