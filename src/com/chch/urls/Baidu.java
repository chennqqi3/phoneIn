package com.chch.urls;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import com.chch.interfaces.HttpRequest;
import com.chch.interfaces.Judge;
import com.chch.interfaces.impl.HttpRequestImpl;
import com.chch.tools.GenerateMD5;
import com.chch.tools.GenerateRandomString;

/**
 * @author pku-03
 *
 */
public class Baidu implements Judge {

	@Override
	public String getWebString(String phoneNum) throws IOException {
		HttpRequest http = new HttpRequestImpl();
		String url = "https://passport.baidu.com/v2/";
		String param = "regphonecheck&token=97d1e5fe2fe8c982ee5de77f842b1440&tpl=&apiver=v3"
				+ "&tt=" + System.currentTimeMillis() 
		+"&phone=" + phoneNum 
		+"&countrycode=&gid=&exchange=0&isexchangeable=1&callback=" 
		+ GenerateMD5.getMD5(phoneNum);
		URL realUrl = new URL(url + "?" + param);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
		connection.setRequestProperty("Referer", "https://passport.baidu.com/v2/?reg&tt=1503024868075&gid=4C39A6D-297E-4F3C-BEB7-134302973E69&tpl=mn&u=https%3A%2F%2Fwww.baidu.com%2F");
		connection.setRequestProperty("Cookie", "BAIDUID=A246DB81386B91594721C997C424A58B:FG=1; BIDUPSID=A246DB81386B91594721C997C424A58B; PSTM=1501034395; __cfduid=d5594f56b0a8fd1ab4ca9d6997a1897261502267525; UBI=fi_PncwhpxZ%7ETaKAe626A-wCjXtb9FxR3N6AbdRMctkf8esOWcx8XKN4GKgMcRExfTymO5W53CZ-0ftHdLH; HISTORY=4f456ead5e47971f739f4983604ae17ee4c6f966718a6735e5473b9468bed3ba; SAVEUSERID=ea21fdef197f3453e2fc0d5f896a252c; USERNAMETYPE=1; FP_UID=4a69aff9616317ab864eb285f25ff6a9; BCLID=3425337398369792780; BDSFRCVID=5lksJeC62iFnCsJZwX0WhFjio9DgR03TH6aomFj97e2gWwgOp52bEG0Pqf8g0Kubof3rogKK0mOTHUvP; H_BDCLCKID_SF=tR-e_K_2tK-3fP36q4JqbJ08Kp8X5-RLfbTQB-OF5l8-hRTDhxb5ylIWWa3UaU5B2C88Kn34tIOxOKQphPcPM6cWbH5MLbbMB54toJoN3KJmqJL9bT3v5tDebGbH2-biWbRL2MbdQ4QmbRO4-TFMj63-DxK; PSINO=2; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_PSSID=1436_21096; FP_UID=af9a308a3e2a8bcbbe161c704395c210; Hm_lvt_90056b3f84f90da57dc0f40150f005d5=1503366206,1503374149,1503384674,1503468293; Hm_lpvt_90056b3f84f90da57dc0f40150f005d5=1503468293; HOSUPPORT=1; nocaptcha_hit=");
		String result = http.get(url, param, connection);
		System.out.println("getWebString:" + phoneNum + " "+ result);
		return result;
	}

	@Override
	public boolean isRegister(String phoneNum) throws IOException {
		Judge judge = new Baidu();
		String result = judge.getWebString(phoneNum);
		if(result.indexOf("手机号已被注册，请直接登录或更换手机号注册") != -1
				|| result.indexOf("已被其他帐号绑定") != -1)//可以找到
			return true;
		return false;
	}

}
