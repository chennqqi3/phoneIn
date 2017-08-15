package com.chch.urls.unfinished;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;
import com.chch.tools.GenerateMD5;
import com.chch.tools.GenerateRandomString;

/**
 * @author pku-03
 *
 */
public class Baidu implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		String url = "https://passport.baidu.com/v2/";
		String param = "regphonecheck&token=&tpl=&apiver=v3&tt=&phone=15116954388&countrycode=&gid=&exchange=0&isexchangeable=1&callback=" + GenerateMD5.getMD5(phoneNum);
		URLConnection conn = null;
		String result = http.get(url, param, conn);
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
