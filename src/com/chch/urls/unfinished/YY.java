package com.chch.urls.unfinished;

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
public class YY implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		//url
		String url = "https://zc.yy.com/reg/pc/chk.do";
		//参数列表，直接用&进行拼接
		String param = "passport="+ phoneNum + "&mobilefix=&appid=1";
		//不需要设置Header信息，直接设置为null
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Host", "zc.yy.com");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
		connection.setRequestProperty("Referer", ": https://zc.yy.com/reg/udb/reg4udb.do?mode=udb&type=Mobile&appid=1&foreignMb=1&action=3&busiurl=https%3A%2F%2Faq.yy.com&fromadv=&reqDomainList=");
		connection.setRequestProperty("Cookie", "JSESSIONID=ef565b1804e2579d7a5df9aa76dbc4aea8bcebaa; hiido_ui=0.7899147010683152; hd_newui=0.5566799732540983");
		
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new YY();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("该帐号已注册") != -1)
			return true;
		else 
			return false;
	}
	
}
