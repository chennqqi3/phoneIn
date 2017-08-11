package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Sohu implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		String url = "http://passport.sohu.com/signup/check_mobile";
		String param = "mobile=" + phoneNum;
		URLConnection conn = null;
		String result = http.get(url, param, conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Sohu();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("该手机号码已被绑定过，请直接登录") != -1)//可以找到
			return true;
		return false;
	}

}
