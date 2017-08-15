package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Tuniu implements Judge {

	@Override
	public String getWebString(String phoneNum) {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "https://passport.tuniu.com/register/isPhoneAvailable";
		//参数列表，直接用&进行拼接
		String param = "intlCode=0086&&tel=" + phoneNum;
		//不需要设置Header信息，直接设置为null
		URLConnection conn = null;
		String result = http.post(url,param,conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Tuniu();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("true") != -1)
			return false;
		return true;
	}


}
