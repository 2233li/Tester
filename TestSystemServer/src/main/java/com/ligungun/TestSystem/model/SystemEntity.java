package com.ligungun.TestSystem.model;

import java.io.Serializable;

// 测试系统实体类（比如 链接、酒景、都为mag 系统实体）
public class SystemEntity implements Serializable{
	int TestSystemEntiyId;
	String systemEntityName;
	int TestSystemId;
	int Status;
	public int getTestSystemEntiyId() {
		return TestSystemEntiyId;
	}
	public void setTestSystemEntiyId(int testSystemEntiyId) {
		TestSystemEntiyId = testSystemEntiyId;
	}
	public String getSystemEntityName() {
		return systemEntityName;
	}
	public void setSystemEntityName(String systemEntityName) {
		this.systemEntityName = systemEntityName;
	}
	public int getTestSystemId() {
		return TestSystemId;
	}
	public void setTestSystemId(int testSystemId) {
		TestSystemId = testSystemId;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}

}
