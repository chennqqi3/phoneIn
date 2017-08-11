package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Iqiyi implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "http://passport.iqiyi.com/apis/user/check_account.action";
		//参数列表，直接用&进行拼接
		String param = "account=" + phoneNum + "&agenttype=1&area_code=86&callback=window.Q.__callbacks__.cbi0gphv&t=";
		//不需要设置Header信息，直接设置为null
		URLConnection conn = null;
		String result = http.post(url,param,conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Iqiyi();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("true") != -1)//可以找到
			return true;
		return false;
	}

}
