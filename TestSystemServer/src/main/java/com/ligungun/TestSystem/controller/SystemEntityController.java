package com.ligungun.TestSystem.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ligungun.TestSystem.mapper.SystemEntityMapper;
import com.ligungun.TestSystem.model.SystemEntity;

@RestController
@RequestMapping("/api/systemEntity")
public class SystemEntityController {
	
	@Autowired
	SystemEntityMapper systemEntityMapper;
	
	// 查询系统实体
	@RequestMapping("/getsystemEntity")
	public List<SystemEntity> findSystemEntity(@RequestParam(value = "TestSystemid",required = false) String TestSystemid,
								@RequestParam(value = "entityName",required = false) String entityName,
								@RequestParam(value = "page",required = false ) String page,
								@RequestParam(value = "row",required = false) String row) {
		SystemEntity systemEntity= new SystemEntity();
		systemEntity.setTestSystemEntiyId(2); 
		return  systemEntityMapper.getSystemEntity(0, 0, systemEntity);
		
		
	
	
	}
	
	// 删除系统实体
	// 编辑系统实体	

}
