package com.ligungun.TestSystem.base;

import java.util.Map;

import com.ligungun.TestSystem.util.Connection;

public abstract class TestSystem {
	public static Connection connection=new Connection();
	Map<String, String> headersMap;
	
	
	public String get(String url, Map<String,String> headers) {
		
		return connection.GetRequest(url, headers);
		
	}
	
	public Map<String, Object> post(String url,Map<String, String> headers,Map<String, String> formdata) {
		return connection.PostFormRquest(url, formdata, headers);
		
	}
	

	

}
