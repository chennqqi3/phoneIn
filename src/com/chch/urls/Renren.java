package com.chch.urls;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Renren implements Judge{

	@Override
	public String getWebString(String phoneNum) {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "http://reg.renren.com/AjaxRegisterAuth.do";
		//参数列表，直接用&进行拼接
		String param = "authType=email&stage=3&t=1502351153242&value="+ phoneNum +"&requestToken=&_rtk=cbe7ac30";
		//不需要设置Header信息，直接设置为null
		URLConnection conn = null;
		String result = http.post(url,param,conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Renren();
		String result = judge.getWebString(phoneNum);
		if("手机号已经绑定，不能注册".equals(result))
			return true;
		else 
			return false;
	}
	
}
