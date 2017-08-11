package com.chch.zunitTest;

import java.io.IOException;

import com.chch.interfaces.Judge;
import com.chch.urls.Sohu;

public class SohuTest {
	public static void main(String[] args) throws IOException {
		Judge j = new Sohu();
		boolean result = j.isRegister("15116954388");
		System.out.println(result);
	}
}
