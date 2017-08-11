package com.chch.interfaces;

import java.io.IOException;

/*
 * 判断手机号是否注册接口
 */
public interface Judge {

	/*
	 * 获取指定url返回的信息，一般情况下是String类型的
	 * 比如输入：http://reg.renren.com/AjaxRegisterAuth.do&value=
	 */
	public String getWebString(String phoneNum) throws IOException;
	
	/*
	 * 根据访问URL返回的结果来判断该手机号在此网站注册
	 */
	public boolean isRegister(String phoneNum) throws IOException;

}
