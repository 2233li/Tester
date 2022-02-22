package com.ligungun.TestSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Run {

	String packagename="com.ligungun.TestSystem.service";
	

	/**  
	 * <p>Title: run</p>  
	 * <p>Description:通过类名，以及参数，执行对应操作 </p>  
	 * @param service 包名称
	 * @param operationName 方法名称（操作名称）
	 * @param param 方法参数
	 * @return  返回操作执行的结果Map<string,string>
	 */  
	public Map<String, String> run(String service,String operationName,Map<String, String> param) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			Class<?> class1 =Class.forName(packagename+service);
			Method method = class1.getMethod(operationName, Map.class);
			Object object=class1.getConstructor().newInstance();
			resultMap=(Map<String, String>) method.invoke(object, param);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	
	}
	
	public Map<String, Object> runs(Map<String, String> CommonParamData,Map<String,Object> operations) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		for(String service:operations.keySet()) {
			Map<String, Object> operationMap=(Map<String, Object>) operations.get(service);
			// 处理param 参数，如果参数value为CommonParam ,则从CommonParamData 取出对应的value
			Map<String, String> operationParamMap=(Map<String, String>)operationMap.get("operationPara");
			if(!operationParamMap.isEmpty()) {
				for(String param:operationMap.keySet()) {
					if(operationMap.get(param).equals("CommonParamData")) {
						operationParamMap.put(param, CommonParamData.get("param"));
					}
				}
				
			}
			
		}
		return resultMap;

	}

}
