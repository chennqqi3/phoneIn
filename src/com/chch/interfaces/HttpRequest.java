package com.chch.interfaces;

import java.net.URLConnection;

/*
 * 发送post和get请求
 */
public interface HttpRequest {
	public String get(String url,String param,URLConnection connection);
	public String post(String url,String param, URLConnection conn);
}
