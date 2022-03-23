package com.ligungun.TestSystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligungun.TestSystem.mapper.TestSystemMapper;
import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.service.TestSystemService;
import com.ligungun.TestSystem.util.ResultBody;

@Service("testSystemService")
public class TestSystemServiceimpl implements TestSystemService {

	@Autowired
	private TestSystemMapper testSystemMapper;
	
	@Override
	public List<TestSystem> findAll() {
		// TODO Auto-generated method stub
		return testSystemMapper.FindAll();
	}

	@Override
	public ResultBody getSystems(Map params) {
		int pageSize =(int) params.get("pageSize");
		int pageIndex=(int) params.get("pageIndex");
		params.put("offset", (pageIndex-1)*pageSize);
		params.put("rows", pageSize);
		// TODO Auto-generated method stub
		ResultBody resultBody=new ResultBody();
		resultBody.setItems(testSystemMapper.getTestSystems(params));
		resultBody.setRow(testSystemMapper.getCounts());
		return resultBody;
	}

	@Override
	public int getCounts() {
		// TODO Auto-generated method stub
		return 0;
	}

}
