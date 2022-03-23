package com.ligungun.TestSystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.service.TestSystemService;
import com.ligungun.TestSystem.util.ResultBody;
import com.ligungun.TestSystem.util.ResultData;


@RestController
@RequestMapping("/api/testsystem")
public class TestSystemController {
	
	@Autowired
	TestSystemService testSystemService;
	
	// 查询配置数据 (pagesize pageindex status systemName)
	@RequestMapping("/getLists")
	public List<TestSystem> geTestSystems (){
		return testSystemService.findAll();
	}
	
	// 查询数据
	@RequestMapping(value = "/getList",method = RequestMethod.POST)
	public ResultBody getTestSystem(@RequestBody Map o){
		return testSystemService.getSystems(o);
	}
	
	// 新增配置数据
	// 编辑配置数据
	
}
