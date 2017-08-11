package com.chch.urls;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class QQ implements Judge{

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
		String url = "https://aq.qq.com/cn2/reset_pwd/pc/pc_reset_pwd_get_uin_by_input_ajax";
		String param = "aq_account=" + phoneNum + "&qq_txwb_user_choice=0&_=1501744594284";
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new QQ();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("0") != -1)
			return true;
		return false;
	}
}
