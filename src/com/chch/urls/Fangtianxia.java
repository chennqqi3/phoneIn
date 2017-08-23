package com.chch.urls;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Fangtianxia implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		/*
		 * url
		 * param 直接将post的信息放入拼接好的字符串里即可
		 * 如果要设置header，依据如下步骤开始走，通过
		 * 1.构造一个URL对象
		 * 2.设置header里的其他属性
		 * 
		 */
		String url = "https://passport.fang.com/checkPhonebinding.api";
		//String param = "authType=email&stage=3&t=1502351153242&value="+ phoneNum +"&requestToken=&_rtk=cbe7ac30";
		String param = "MobilePhone=" + phoneNum +"&Service=soufun-passport-web";
		//设置header
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Host", "passport.fang.com");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		connection.setRequestProperty("Referer", "https://passport.fang.com/NewRegister.aspx?backurl=http://my.fang.com/");
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Fangtianxia();
		String result = judge.getWebString(phoneNum);
		System.out.println(result);
		if(result.contains("\"IsBingding\":true"))
			return true;
		return false;
	}
}
