package com.chch.urls.unfinished;

import java.io.IOException;
import java.net.URL;
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
		String param = "regphonecheck&token=&tpl=&apiver=v3&tt=&phone=" + phoneNum +"&countrycode=&gid=&exchange=&isexchangeable=1&callback=" + GenerateMD5.getMD5(phoneNum);
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
		connection.setRequestProperty("Referer", "https://passport.baidu.com/v2/?reg&tt=1503024868075&gid=4C39A6D-297E-4F3C-BEB7-134302973E69&tpl=mn&u=https%3A%2F%2Fwww.baidu.com%2F");
		String result = http.get(url, param, connection);
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
