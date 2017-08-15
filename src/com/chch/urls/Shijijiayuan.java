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
public class Shijijiayuan implements Judge{

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		/*
		 * url
		 * param 直接将post的信息放入拼接好的字符串里即可
		 * 如果要设置header，依据如下步骤开始走，通过
		 * 1.构造一个URL对象
		 * 2.设置header里的其他属性
		 * 
		 */
		String url = "http://www.jiayuan.com/login/libs/xajax/reguser.server.php?method=login";
		String param = "xajax=processSendOrUpdateMessage&xajaxargs%5B%5D=%3Cxjxquery%3E%3Cq%3Efindpass%3D" + phoneNum + "%3C%2Fq%3E%3C%2Fxjxquery%3E&xajaxargs%5B%5D=findpass&xajaxr=1502787160928";
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Shijijiayuan();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("该手机号未注册") != -1)//可以找到
			return false;
		return true;
	}
	
}
