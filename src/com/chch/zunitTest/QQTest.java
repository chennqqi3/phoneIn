package com.chch.zunitTest;

import java.io.IOException;

import com.chch.interfaces.Judge;
import com.chch.urls.QQ;

public class QQTest {
	public static void main(String[] args) throws IOException {
		Judge j = new QQ();
		boolean result = j.isRegister("15116954388");
		System.out.println(result);
	}
}
