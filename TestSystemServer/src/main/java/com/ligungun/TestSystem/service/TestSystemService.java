package com.ligungun.TestSystem.service;

import java.util.List;
import java.util.Map;

import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.util.ResultBody;

public interface TestSystemService {
	
	List<TestSystem> findAll();
	ResultBody getSystems(Map params);
	int getCounts();

}
