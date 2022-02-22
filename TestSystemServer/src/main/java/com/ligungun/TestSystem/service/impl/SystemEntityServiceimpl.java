package com.ligungun.TestSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligungun.TestSystem.mapper.SystemEntityMapper;
import com.ligungun.TestSystem.model.SystemEntity;
import com.ligungun.TestSystem.service.SystemEntityService;

@Service("SystemEntityService")
public class SystemEntityServiceimpl implements SystemEntityService {
	
	@Autowired
	SystemEntityMapper systemEntityMapper;
	

	@Override
	public List<SystemEntity> getSystemEntity(int page, int pageSize, SystemEntity systemEntity) {
		// TODO Auto-generated method stub
		//System.out.println(systemEntity.getTestSystemEntiyId());
		return systemEntityMapper.getSystemEntity(page, pageSize, systemEntity);
	}

}
