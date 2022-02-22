package com.ligungun.TestSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligungun.TestSystem.mapper.TestSystemMapper;
import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.service.TestSystemService;

@Service("testSystemService")
public class TestSystemServiceimpl implements TestSystemService {

	@Autowired
	private TestSystemMapper testSystemMapper;
	
	@Override
	public List<TestSystem> findAll() {
		// TODO Auto-generated method stub
		return testSystemMapper.FindAll();
	}

}
