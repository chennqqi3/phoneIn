package com.chch.zunitTest;

import java.io.IOException;

import com.chch.interfaces.Judge;
import com.chch.urls.Renren;

public class RenrenTest {
	public static void main(String[] args) throws IOException {
		Judge j = new Renren();
		boolean result = j.isRegister("18801017532");
		System.out.println(result);
	}
}
