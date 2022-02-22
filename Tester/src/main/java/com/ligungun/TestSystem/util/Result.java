package com.ligungun.TestSystem.util;

import java.util.Map;

public class Result {
	public int code; // 0 失败，1 成功
	public String describe="请求成功";
	public String originalParam;
	public Map<String, String> importantResult;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getOriginalParam() {
		return originalParam;
	}
	public void setOriginalParam(String originalParam) {
		this.originalParam = originalParam;
	}
	public Map<String, String> getImportantResult() {
		return importantResult;
	}
	public void setImportantResult(Map<String, String> importantResult) {
		this.importantResult = importantResult;
	}

}
