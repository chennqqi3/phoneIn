package com.chch.urls;
/*
中华英才
http://passport.chinahr.com/ajax/m/existLoginName?input=18801017533&_=1501754443158
get
注册：{"isSuccess":true,"returnMessage":"用户存在"}
未注册：{"isSuccess":false,"returnMessage":"帐号不存在，请确认是否填写错误"}

*/


import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

/**
 * @author pku-03
 *
 */
public class Zhonghuayingcai implements Judge{

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
		String url = "http://passport.chinahr.com/ajax/m/existLoginName";
		String param = "input=" + phoneNum + "&_=1501754443158";
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.get(url,param,connection);
		//System.out.println(url + param);
		System.out.println("getWebString:zhonghuayingcai" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Zhonghuayingcai();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("用户存在") != -1)
			return true;
		return false;
	}	
}
