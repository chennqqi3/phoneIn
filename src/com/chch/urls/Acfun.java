package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Acfun implements Judge {

	@Override
	public String getWebString(String phoneNum) {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "http://www.acfun.cn/mobileUnique.aspx";
		//参数列表，直接用&进行拼接
		String param = "mobile=" + phoneNum;
		//不需要设置Header信息，直接设置为null
		URLConnection conn = null;
		String result = http.get(url,param,conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Acfun();
		String result = judge.getWebString(phoneNum);
		if(result.equals("true"))//没有注册过
			return false;
		return true;
	}

}
