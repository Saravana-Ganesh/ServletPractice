package com.sample.constants;

public class QueryConstants {
	public static String validateUser = "SELECT "+TableConstants.USER_MASTER_EMAIL+""
			+ "FROM "+TableConstants.USER_MASTER+" WHERE "+TableConstants.USER_MASTER_EMAIL+""
					+ "= ? AND "+TableConstants.USER_MASTER_PASSWORD+" = ?";
	
	public static String createUser = "insert into "+TableConstants.USER_MASTER+""
			+ "("+TableConstants.USER_MASTER_EMAIL+","+TableConstants.USER_MASTER_USERNAME+""
					+ ","+TableConstants.USER_MASTER_PHONE+","+TableConstants.USER_MASTER_PASSWORD+")"
							+ "VALUES(?,?,?,?)";
}
