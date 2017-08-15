package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

/**
 * @author pku-03
 *
 */
public class Dajie implements Judge{

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
		String url = "https://www.dajie.com/account/newloginsubmitm";
		String param = "callback=NEW_VERSION_LOGIN_CALLBACK&_CSRFToken=&ajax=1&phoneNumber=" + phoneNum + "&password=1234654&captcha=&rememberMe=1";
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Dajie();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("该手机号未进行过注册") == -1)
			return true;
		return false;
	}
	
}
