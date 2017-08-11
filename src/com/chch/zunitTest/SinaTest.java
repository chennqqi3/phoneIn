package com.chch.zunitTest;

import java.io.IOException;

import com.chch.interfaces.Judge;
import com.chch.urls.Renren;
import com.chch.urls.Sina;

public class SinaTest {
	public static void main(String[] args) throws IOException {
		Judge j = new Sina();
		boolean result = j.isRegister("18801017533");
		System.out.println(result);
	}
}
