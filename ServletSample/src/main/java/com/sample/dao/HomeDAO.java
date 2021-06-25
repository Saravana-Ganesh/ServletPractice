package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.bo.CovidCaseDataBO;
import com.sample.bo.ResponseBO;
import com.sample.constants.QueryConstants;
import com.sample.utils.DBUtils;

public class HomeDAO {
	public ResponseBO getCaseCount() {
		Connection con = DBUtils.getDbConnection();
		ResponseBO responseBO =  new ResponseBO();;
		try(PreparedStatement preparedStatement = con.prepareStatement(QueryConstants.getCaseCount)){			
			ResultSet resultSet = preparedStatement.executeQuery();	
			List<CovidCaseDataBO> caseDataList = new ArrayList<CovidCaseDataBO>();
			while(resultSet.next()) {
				CovidCaseDataBO covidCaseDataBO = new CovidCaseDataBO();
				covidCaseDataBO.setMonthValues(resultSet.getString(1));
				covidCaseDataBO.setCaseCount(resultSet.getString(2));
				caseDataList.add(covidCaseDataBO);
			}
			responseBO.setCovidCaseDataBO(caseDataList);
			responseBO.setStatus(1);
			return responseBO;
		}catch (SQLException e) {
			e.printStackTrace();
			responseBO.setStatus(-1);
			return responseBO;
		} 
	}
}
