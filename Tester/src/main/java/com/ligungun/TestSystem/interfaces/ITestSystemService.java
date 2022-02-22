package com.ligungun.TestSystem.interfaces;

import java.util.Map;

/** 
* <p>Title: ITestSystemService</p>  
* <p>Description: </p>  
* @author ligungun
* @date 2021年10月15日  
*/  
public interface ITestSystemService {
	
	/**  
	 * <p>Title: Run</p>  
	 * <p>Description:运行对应操作 </p>  
	 * @param commonparam 获取公共数据
	 * @return  
	 */  
	public Map<String, Object> Run(Map<String, String>commonparam);
	/**  
	 * <p>Title: RunandCheck</p>  
	 * <p>Description: </p>  
	 * @param commonparam 公共数据
	 * @param string 校验请求后的结果
	 * @return  
	 */  
	public Map<String,String> RunandCheck(Map<String, String>commonparam,String string);
	/**  
	 * <p>Title: checkData</p>  
	 * <p>Description:检查数据，比如下单接口中，对于公共参数中下单价格和实际价格进行对比 </p>  
	 * @return  
	 */  
	public boolean checkData();
	

}
