package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.bo.RegisterBO;
import com.sample.constants.QueryConstants;
import com.sample.utils.DBUtils;

public class RegisterDAO {

	public boolean createUser(RegisterBO registerBO) {
		Connection con = DBUtils.getDbConnection();
		try(PreparedStatement preparedStatement = con.prepareStatement(QueryConstants.createUser)){			
			preparedStatement.setString(1,registerBO.getUserEmail());
			preparedStatement.setString(2, registerBO.getUserName());
			preparedStatement.setString(3, registerBO.getUserPhone());
			preparedStatement.setInt(4, registerBO.getUserPassword());
			int a = preparedStatement.executeUpdate();
			return a==1;			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}

}
