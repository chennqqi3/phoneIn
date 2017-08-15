package com.chch.urls;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

/**
 * @author pku-03
 * 一个手机号30天可以验证一次账户
 */
public class Tianya implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		String url = "http://passport.tianya.cn/fp/createsms.do";
		String param = "countryCode=%2B86&mobile=" + phoneNum +"&_r=1502788795983";
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
//		connection.setRequestProperty("Host", "login.weibo.cn");
//		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		connection.setRequestProperty("Referer", "http://passport.tianya.cn/fp/mobile.jsp");
		String result = http.get(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Tianya();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("只有认证手机才可操作") != -1)//没有认证，粗略以为没有注册过
			return false;
		return true;
	}

}
