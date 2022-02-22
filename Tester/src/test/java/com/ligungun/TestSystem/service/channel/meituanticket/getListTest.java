package com.ligungun.TestSystem.service.channel.meituanticket;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class getListTest {
	@Test
	public void  defualtRequest() {
		Map<String, String> requestparaMap = new HashMap<String, String>();
		GetList getList = new GetList();
		Map<String,Object> result=getList.Run(requestparaMap);
		GetList ohtergetList = new GetList();
		ohtergetList.Run(requestparaMap);
		

		
		
		
	}
	

}
