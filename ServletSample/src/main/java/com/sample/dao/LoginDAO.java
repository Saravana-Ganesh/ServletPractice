package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.bo.LoginBO;
import com.sample.constants.QueryConstants;
import com.sample.utils.DBUtils;

public class LoginDAO {

	public boolean validateUser(LoginBO loginBO) {
		Connection con = DBUtils.getDbConnection();
		try(PreparedStatement preparedStatement = con.prepareStatement(QueryConstants.validateUser)){			
			preparedStatement.setString(1,loginBO.getUserEmail());
			preparedStatement.setInt(2, loginBO.getUserPassword());
			return preparedStatement.executeQuery().next();			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

}
