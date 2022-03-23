package com.ligungun.TestSystem.util;

public enum ReturnCode {
	RC100(100,"操作成功"),
	RC999(999,"操作失败"),
	RC500(500,"服务端错误");
	
	private final int code;
	private final String message;
	
	private ReturnCode(int code,String message) {
		this.code=code;
		this.message=message;
		
	}
	
	public int getCode() {
		return code;
	}
	public String  getMessage() {
		return message;
		
	}

}
