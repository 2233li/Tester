package com.ligungun.TestSystem.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.ligungun.TestSystem.model.TestSystem;



@Mapper
public interface TestSystemMapper  {
	List<TestSystem> FindAll();
	List<TestSystem> getTestSystems(Map params);
	int  getCounts();
	
	
	

}
