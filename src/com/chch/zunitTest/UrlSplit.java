package com.chch.zunitTest;

public class UrlSplit {
	public static void main(String[] args) {
		String url = "com.chch.urls.unfinished.Dangdang";
		String[] s = url.split("\\.");
		for(String _ : s)
			System.out.println(_);
		for(int i = 0;i < s.length;i++)
		{
			System.out.println(s[i]);
		}
	}
}
