package com.chch.urls;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

/**
 * @author pku-03
 * 注册：   CheckRegByTelNumCallbackFn({"data":1})
 * 未注册：CheckRegByTelNumCallbackFn({"data":0})
 * 在注册界面：http://www.kugou.com/reg/web/
 */
public class Kuwo implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "https://reg-user.kugou.com/v2/check/";
		//参数列表，直接用&进行拼接
		String param = "appid=1014&type=2&username=18703423624&callback=CheckRegByTelNumCallbackFn&mid=ff53fcab4631e50f22931f3bf6612fd9";
		//不需要设置Header信息，直接设置为null
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Host", "reg-user.kugou.com");
		connection.setRequestProperty("Cookie", "kg_mid=ff53fcab4631e50f22931f3bf6612fd9; Hm_lvt_aedee6983d4cfc62f509129360d6bb3d=1503472419; Hm_lpvt_aedee6983d4cfc62f509129360d6bb3d=1503472539");
//		connection.setRequestProperty("Referer", "");
		
		String result = http.get(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Kuwo();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("{\"data\":0}") != -1)
			return false;
		return false;
	}
	
}
