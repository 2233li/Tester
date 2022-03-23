package com.ligungun.TestSystem.util;

import java.util.List;

import lombok.Data;

@Data
public class ResultBody<T> {
	private int row;// 查询数据总数
	private List<T> items;
	

}
