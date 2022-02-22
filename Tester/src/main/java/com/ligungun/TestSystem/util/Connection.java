package com.ligungun.TestSystem.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p>
 * Title: Connection
 * </p>
 * <p>
 * Description:��װhttp����
 * </p>
 * 
 * @author ligungun
 * @date 2021��9��30��
 */
public class Connection {
	private OkHttpClient client;
	private Cookies cookies = new Cookies();

	/**
	 * <p>
	 * Title:Ĭ�Ϲ�����
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public Connection() {
		client = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).cookieJar(cookies).build();
	}

	/**
	 * <p>
	 * Title: PostFormRquest
	 * </p>
	 * <p>
	 * Description:����post����
	 * </p>
	 * 
	 * @param url      ����ĵ�ַ
	 * @param FormData ����Ĳ���
	 * @param headers  ����ͷ
	 */
	public Map<String, Object> PostFormRquest(String url, Map<String, String> FormData, Map<String, String> headers) {
		Map<String, Object> resultMap= new HashMap<String, Object>();
		Request.Builder requestBuilder = new Request.Builder();
		if (!FormData.isEmpty()) {
			FormBody.Builder formbodybuilder = new FormBody.Builder();
			for (String key : FormData.keySet()) {
				formbodybuilder.add(key, FormData.get(key));
			}
			requestBuilder.post(formbodybuilder.build());

		}

		if (!headers.isEmpty()) {
			for (String headname : headers.keySet()) {
				requestBuilder.addHeader(headname, headers.get(headname));
			}
		}

		Request request = requestBuilder.url(url).build();
		Call call = client.newCall(request);
		try {
			Response response = call.execute();
			resultMap.put("code", response.code());
			resultMap.put("responsebody", response.body().string());
			
		
			return resultMap;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultMap;

	}

	/**  
	 * <p>Title: GetRequest</p>  
	 * <p>Description: </p>  
	 * @param url
	 * @param headers
	 * @return  
	 */  
	public String GetRequest(String url, Map<String, String> headers) {
		Request.Builder requestbuilder = new Request.Builder();
		if(!headers.isEmpty()) {
			for(String headname:headers.keySet()) {
				requestbuilder.addHeader(headname, headers.get(headname));
			}
		}
		Request request=requestbuilder.url(url).build();
		Call call = client.newCall(request);
		try {
			Response response = call.execute();
			return response.body().string();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "";

	}

	public String getCokie(String host, String cookieName) {
		String cookieString = cookies.getCookie(host, cookieName);
		return cookieString;
	}

}

class Cookies implements CookieJar {
	private final Map<String, Map<String, Cookie>> cookiesHostMap = new HashMap<String, Map<String, Cookie>>();

	public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
		if (!cookies.isEmpty()) {
			Map<String, Cookie> MapCokies = cookiesHostMap.get(url.host());
			MapCokies = MapCokies != null ? MapCokies : new HashMap<String, Cookie>();
			for (Cookie c : cookies) {
				MapCokies.put(c.name(), c);
			}
			cookiesHostMap.put(url.host(), MapCokies);
		}
	}

	public List<Cookie> loadForRequest(HttpUrl url) {
		// TODO Auto-generated method stub
		List<Cookie> cookieList = new ArrayList<Cookie>();
		Map<String, Cookie> MapsCookie = cookiesHostMap.get(url.host());
		if (MapsCookie != null && !MapsCookie.isEmpty()) {
			for (String s : MapsCookie.keySet()) {
				cookieList.add(MapsCookie.get(s));
			}
		}

		return cookieList;
	}

	public String getCookie(String host, String cookieName) {
		String cookieValue = "";
		Map<String, Cookie> cookies = cookiesHostMap.get(host);
		if (cookies != null) {
			cookieValue = cookies.get(cookieName) != null ? cookies.get(cookieName).value() : "";
		}
		return cookieValue;
	}
}

