package com.sample.bo;

import java.util.List;

public class ResponseBO {
	private int status;
	private List<CovidCaseDataBO> covidCaseDataBO;

	public List<CovidCaseDataBO> getCovidCaseDataBO() {
		return covidCaseDataBO;
	}

	public void setCovidCaseDataBO(List<CovidCaseDataBO> covidCaseDataBO) {
		this.covidCaseDataBO = covidCaseDataBO;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
