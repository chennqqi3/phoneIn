package com.chch.urls.unfinished;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.chch.interfaces.Judge;
import com.chch.tools.GenerateMD5;
import com.chch.tools.GenerateRandomString;

public class Baidu3 implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		String url = "https://passport.baidu.com/v2/";
		String param = 
		"regphonecheck&token=" + GenerateMD5.getMD5(phoneNum) 
		+ "&tpl=&apiver=v3"
		+ "&tt=" + System.currentTimeMillis() 
		+"&phone=" + phoneNum 
		+"&countrycode=00&gid=&exchange=0&isexchangeable=1&callback=" 
//		+ GenerateMD5.getMD5(phoneNum);
		+ "bd__cbs__" + GenerateRandomString.getRandomString(6);
		
		URL myurl = new URL(url + "?" + param);
		HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();

		conn.setRequestMethod("GET");
		conn.connect();
		
		BufferedReader in = null;
		String result = "";
		in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
//		System.out.println(result);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Baidu();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("手机号已被注册，请直接登录或更换手机号注册") != -1)//可以找到
			return true;
		return false;
	}
	
}
