package com.chch.zunitTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TImeTest {
	public static void main(String[] args) {
		  Date nowTime = new Date(System.currentTimeMillis());
		  SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		  String retStrFormatNowDate = sdFormatter.format(nowTime);
		  System.out.println(System.currentTimeMillis());
	}
}
