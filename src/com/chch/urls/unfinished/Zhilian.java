package com.chch.urls.unfinished;

import java.io.IOException;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;

public class Zhilian implements Judge{

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
		String url = "https://passport.zhaopin.com/account/checkexist";
		//String param = "MmEwMD=1jS79g3yl70WnUmDNdlwYVGmSpHztfHFHPknM.Fq66lUjrdsUZB9SqCmCh.XTyOaZiHc7CN0SdzFrFX4pN4_uM9DsWYXMCR8dJijMSVfQRpPA0wjImbxVCHPWS7XWutbvsE8TcmbxN41CNUPVntUWAe9TCCOG7waLOQQgwA830tK8ZbT3VjPSJVt6Tn0RisiJYUUwhTBNDA8W2UvOOYIwnbxwPzJSc3NQikE34_GE0Sc31Ol4p4UtDF_iY3zKQekOJlC9uECOsIQyd7CvL7bEVrLw7gEEzxWf5_67Fx_BplkpG4OodLLDX.ZpaN8H_WaoLBrmJ_yaWbuO2Tgfqo9sPDaxBxkRJs9BAgATGIfmmNi7IK3MfEVOzaCyIkl0mj28ffpMJNirQY7uG2By.AI5QZuRQP6RTHo.pvZ&Receiver=" + phoneNum + "&registername=" + phoneNum;
		String param = "MmEwMD=1jS79g3yl70WnUmDNdlwYVGmSpHztfHFHPknM.Fq66lUjrdsUZB9SqCmCh.XTyOaZiHc7CN0SdzFrFX4pN4_uM9DsWYXMCR8dJijMSVfQRpPA0wjImbxVCHPWS7XWutbvsE8TcmbxN41CNUPVntUWAe9TCCOG7waLOQQgwA830tK8ZbT3VjPSJVt6Tn0RisiJYUUwhTBNDA8W2UvOOYIwnbxwPzJSc3NQikE34_GE0Sc31Ol4p4UtDF_iY3zKQekOJlC9uECOsIQyd7CvL7bEVrLw7gEEzxWf5_67Fx_BplkpG4OodLLDX.ZpaN8H_WaoLBrmJ_yaWbuO2Tgfqo9sPDaxBxkRJs9BAgATGIfmmNi7IK3MfEVOzaCyIkl0mj28ffpMJNirQY7uG2By.AI5QZuRQP6RTHo.pvZ&Receiver=18703423624&registername=18703423624"; 
		URLConnection connection = null;
		String result = http.post(url,param,connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Zhilian();
		String result = judge.getWebString(phoneNum);
		if("手机号已经绑定，不能注册".equals(result))
			return true;
		return false;
	}
}
