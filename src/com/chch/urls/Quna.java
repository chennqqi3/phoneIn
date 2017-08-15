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
public class Quna implements Judge{

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
		String url = "https://user.qunar.com/ajax/validator.jsp";
		String param = "method=" + phoneNum + "&prenum=86&vcode=null";
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Quna();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("用户已存在") != -1)//可以找到
			return true;
		return false;
	}
	
}
