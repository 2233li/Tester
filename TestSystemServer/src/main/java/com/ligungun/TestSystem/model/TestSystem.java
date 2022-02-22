package com.ligungun.TestSystem.model;

import java.io.Serializable;

public class TestSystem implements Serializable   {
	public int testSystemId;
	public String testSystemName;
	
	public int getTestSystemId() {
		return testSystemId;
	}
	public void setTestSystemId(int testSystemId) {
		this.testSystemId = testSystemId;
	}
	public String getTestSystemName() {
		return testSystemName;
	}
	public void setTestSystemName(String testSystemName) {
		this.testSystemName = testSystemName;
	}
	
	
		

}
