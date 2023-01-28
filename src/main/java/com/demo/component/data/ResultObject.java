package com.demo.component.data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.demo.component.constant.ResultStatus;

import lombok.Data;

@Data
public class ResultObject<T> {

	@Enumerated(EnumType.STRING)
	ResultStatus resultStatus;
	T result;
	String message;
	long responseTime;

	public ResultObject(ResultStatus resultStatus, T result, String message) {
		super();
		this.resultStatus = resultStatus;
		this.result = result;
		this.message = message;
		responseTime = System.currentTimeMillis();

	}

}
