package com.ligungun.TestSystem.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ligungun.TestSystem.util.ResultData;
import com.ligungun.TestSystem.util.ReturnCode;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResultData<String> exception(Exception e){
		return ResultData.fail(ReturnCode.RC500.getCode(), e.getMessage());
		
		
	}

}
