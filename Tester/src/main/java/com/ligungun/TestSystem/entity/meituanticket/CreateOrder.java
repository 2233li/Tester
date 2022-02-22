package com.ligungun.TestSystem.entity.meituanticket;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.ligungun.TestSystem.util.Result;

public class CreateOrder {
	private String urlString="/meituanV2/CreateLvOrder";
	public String requestParam;
	public Map<String, String>importantResultMap = new HashMap<String, String>(){
	
	};
	
	
	public CreateOrder(String requestParam) {
		this.requestParam=requestParam;	
		
	}
	
	public Result run() {
		Result result = new Result();
		
		return result;
	}
	
}