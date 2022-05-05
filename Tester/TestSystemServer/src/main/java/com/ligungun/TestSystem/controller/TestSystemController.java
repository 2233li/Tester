package com.ligungun.TestSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.service.TestSystemService;


@RestController
@RequestMapping("/api/testsystem")
public class TestSystemController {
	
	@Autowired
	TestSystemService testSystemService;
	
	@RequestMapping("/findAll")
	public List<TestSystem> findAll(){
		return testSystemService.findAll();
	}
	
	//查询数据（分页、条件（系统名称、系统状态）
	//新增数据
	//失效数据
}
