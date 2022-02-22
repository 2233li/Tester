package com.ligungun.TestSystem.base;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.Interceptor.Chain;

public class MagSystem extends TestSystem {
	private static int logintimes=0;
	public String hostString = "http://mag-test5.yaochufa.com";
	public String loginUserString = "{\"ReturnUrl\":\"\",\"LoginAccount\":\"liyuan001\",\"Password\":\"ersansan@22\"}";
	public Map<String, String> headMaps = new HashMap<String, String>() {
		{
			put("User-Agent", "Mozilla/5.0");
			put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			put("Accept-Language", "zh-CN,zh;q=0.9");
			put("Connection", "keep-alive");
			
		}
	};

	public MagSystem() {

	}
	
	
	@Override
	public Map<String, Object> post(String url, Map<String, String> headers, Map<String, String> formdata) {
		// TODO Auto-generated method stub
		Map<String, Object> resultMap =super.post(url, headers, formdata);
		if(((String) resultMap.get("responsebody")).contains("后台管理-登录")&logintimes<3) {
			logintimes +=1;
			if(login()) {
				resultMap =super.post(url, headers, formdata);
			}
			
		}
		else logintimes=0;
		return resultMap;
	}

	private boolean login() {
		boolean result=false;
		String loginurl = hostString + "/Account/Auth";
		Map<String, String> loginForm = new HashMap<String, String>();
		loginForm.put("ReturnUrl", "/");
		String encryptData;

		// �����¼ҳ�棬��ȡ��̬__RequestVerificationToken&encryptKey
		String regex = "__RequestVerificationToken.*?value=\"(.*?)\"(?s).+var encryptKey = '(.*?)';";
		String loginBody = connection.GetRequest(loginurl, headMaps);
		Matcher matcher = Pattern.compile(regex).matcher(loginBody);
		if (matcher.find()) {
			loginForm.put("__RequestVerificationToken", matcher.group(1));
			String encryptKey = matcher.group(2);
			// encryptKey ����
			try {
				byte[] raw = encryptKey.getBytes("utf-8");
				SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "�㷨/ģʽ/���뷽ʽ"
				IvParameterSpec iv = new IvParameterSpec(encryptKey.getBytes());// ʹ��CBCģʽ����Ҫһ������iv�������Ӽ����㷨��ǿ��
				cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
				byte[] encrypted = cipher.doFinal(loginUserString.getBytes());
				encryptData = Base64.getEncoder().encodeToString(encrypted);
				loginForm.put("encryptData", encryptData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ��¼
			String resultbody=(String) connection.PostFormRquest(loginurl, loginForm, headMaps).get("responsebody");
			if (resultbody.contains("Mag门户首页")) {
				result=true;
			}

		}

		else {

		}
		return result;

	}

}


