package com.chch.urls;

/*
 * 
京东
https://reg.jd.com/validateuser/isMobileEngaged?phone=%2B008615116954388&mobile=%2B008615116954388&_=1501755046265
get
注册：{"success":1}
未注册:{"success":0}

 */
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

/**
 * @author pku-03
 *
 */
public class Jd implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		/*
		 * url param 直接将post的信息放入拼接好的字符串里即可 如果要设置header，依据如下步骤开始走，通过 1.构造一个URL对象
		 * 2.设置header里的其他属性
		 * 
		 */
		String url = "https://reg.jd.com/validateuser/isMobileEngaged";
		String param = "phone=%2B0086" + phoneNum + "&mobile=%2B0086" + phoneNum + "&_=1501755046265";
		
		// 设置header
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Host", "reg.jd.com");
		
		String result = http.get(url, param, connection);
		System.out.println("getWebString:" + phoneNum + " " + result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Jd();
		String result = judge.getWebString(phoneNum);
		if (result.indexOf("1") != -1)
			return true;
		return false;
	}

}
