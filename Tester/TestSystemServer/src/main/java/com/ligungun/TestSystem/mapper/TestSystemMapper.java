package com.ligungun.TestSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ligungun.TestSystem.model.TestSystem;



@Mapper
public interface TestSystemMapper  {
	@Select("select * from testsystem")
	List<TestSystem> FindAll();
	
	
	

}
