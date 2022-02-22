package com.ligungun.TestSystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ligungun.TestSystem.model.SystemEntity;

@Mapper
public interface SystemEntityMapper {
	
	public List<SystemEntity> getSystemEntity(@Param("page") int page,
											  @Param("pageSize") int pageSize,
											  @Param("systemEntity") SystemEntity systemEntity);

}
