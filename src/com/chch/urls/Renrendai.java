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
public class Renrendai implements Judge{

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
		String url = "https://www.renrendai.com/pc/passport/index/doLogin";
		String param = "j_username= "+ phoneNum + "&j_password=sjp2jVBXMNfvbjCtTKUFnIo3zitBSIxN6mqXFqmkX7KK3ySh4lGOlXUoka0lAODlOCR0r9WhpzrP6U6Q18kzHwpLW4WqvL3ZBfMlxW3wzv1cz7aQXW4JjzDqROsZOS4bz4LXNRS2Pgfga4nGKrLYWBFQkUXVC0uugtnkTolF6ls%3D&\r\n" + 
				"j_code=&\r\n" + 
				"rememberme=&\r\n" + 
				"targetUrl=&returnUrl=" ;
		//设置header，不需要设置
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Renrendai();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("用户不存在") == -1)
			return false;
		return true;
	}
}
