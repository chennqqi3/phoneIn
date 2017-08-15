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
public class Kanzhun implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		String url = "http://www.kanzhun.com/account/checkAccountBind.json";
		String param = "account=" + phoneNum;
		URLConnection conn = null;
		String result = http.get(url, param, conn);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Kanzhun();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("\"result\":true") != -1)//可以找到
			return true;
		return false;
	}

}
