package com.chch.zunitTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

public class F58 {

	public static void main(String[] args) throws IOException {
		String url = "https://passport.58.com/login/dologin";
		// 参数列表，直接用&进行拼接
		String param = "source=pc-login&path=http%3A%2F%2Fmy.58.com%2F%3Fpts%3D1503366380907&password=5f4f034d5a756426985bb05847138c4c3892834d5aa61900d583cfb3bd159477ea0815a8e8df8c2c516a838b1dfc27ae95dc79a405dfd2ea83b8c4eebedc18d66637bb0172bcb58d34d5d3aad7303060b11359e26e5bf104ebd4383fea79c9bd58cf145db64af0c631fc58554210c74b363d78d15694488978a83d0154904b5a&timesign=&isremember=false&callback=successFun&yzmstate=&fingerprint=2A1AD549D93D4FA140A8ECBCB0C0BBEA0745D6FD43DAFCBE_011&finger2=zh-CN%7C24%7C1%7C8%7C1680_1050%7C1615_1050%7C-480%7C1%7C1%7C1%7Cundefined%7C1%7Cunknown%7CWin32%7Cunknown%7C4%7Cfalse%7Cfalse%7Cfalse%7Cfalse%7Cfalse%7C0_false_false%7Cd41d8cd98f00b204e9800998ecf8427e%7C5c84d7c2b09ab01d3e8f3965b00a096a&tokenId=&token=XFMKfgYl4Nyika9Z_UKtW1K6aYVKdtmZ&username=188024528456&validcode=&vcodekey=&btnSubmit=%E7%99%BB%E5%BD%95%E4%B8%AD...";
		URL myurl = new URL(url + "?" + param);
		HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();

		conn.setRequestMethod("POST");
		conn.connect();
		Map headers = conn.getHeaderFields();
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			String val = conn.getHeaderField(key);
			System.out.println(key + "    " + val);
		}
		
		String location = conn.getHeaderField("location");
		//URL redlocation = new URL(location);
		HttpURLConnection newUrl = (HttpURLConnection) new URL(location).openConnection();
		newUrl.setRequestMethod("GET");
		newUrl.connect();
		System.out.println(newUrl.getInputStream());
		
		
		BufferedReader in = null;
		String result = "";
		in = new BufferedReader(new InputStreamReader(newUrl.getInputStream(), "UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
	}

}
