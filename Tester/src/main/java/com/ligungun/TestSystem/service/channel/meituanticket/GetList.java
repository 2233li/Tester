package com.ligungun.TestSystem.service.channel.meituanticket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ligungun.TestSystem.base.MagSystem;
import com.ligungun.TestSystem.interfaces.ITestSystemService;
import com.ligungun.TestSystem.util.Connection;

public class GetList extends MagSystem implements ITestSystemService {
	private String url= "/ota/meituan/getlist";	
	public Map<String, String> formdata = new HashMap<String, String>();
	public Map<String, String> result = new HashMap<String, String>();
	
	public GetList() {
		formdata.put("keyword", "");
		formdata.put("keyWordId", "");
		formdata.put("channelId", "43");
		formdata.put("PushData", "-1");
		formdata.put("liuLiangId", "0");
		formdata.put("GoodsCode", "");
		formdata.put("GroupType", "0");
		formdata.put("page", "1");
		formdata.put("rows", "50");
		formdata.put("sort", "ID");
		formdata.put("order", "asc");	
	}
	


	public Map<String, Object> Run( Map<String, String> commonparam) {
		// 覆盖默认的请求参数
		if (!commonparam.isEmpty()) {
			for(String paramKey :formdata.keySet() ) {
				if(commonparam.get(paramKey)!=null) {
					formdata.put(paramKey, commonparam.get(paramKey));
				}
			}
		}
		// TODO Auto-generated method stub
		
		
		return post(hostString+url, headMaps, formdata);
	}



	public Map<String, String> RunandCheck(Map<String, String> commonparam, String checkRules) {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean checkData() {
		// TODO Auto-generated method stub
		return false;
	}



}
