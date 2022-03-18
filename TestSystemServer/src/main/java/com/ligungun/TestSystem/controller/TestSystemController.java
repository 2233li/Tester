package com.ligungun.TestSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ligungun.TestSystem.model.TestSystem;
import com.ligungun.TestSystem.service.TestSystemService;
import com.ligungun.TestSystem.util.ResultData;


@RestController
@RequestMapping("/api/testsystem")
public class TestSystemController {
	
	@Autowired
	TestSystemService testSystemService;
	
	@RequestMapping("/getList")
	public List<TestSystem> findAll(){
		return testSystemService.findAll();
	}
	
	@RequestMapping("/wula")
	public ResultData<String> getStr(){
		return ResultData.success("hello");
	}
}
