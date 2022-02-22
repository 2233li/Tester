package com.ligungun.TestSystem.service;

import java.util.List;

import com.ligungun.TestSystem.model.SystemEntity;

public interface SystemEntityService {
	List<SystemEntity> getSystemEntity(int page,int pageSize, SystemEntity systemEntity);

}
