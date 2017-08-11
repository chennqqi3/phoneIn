package com.chch.zunitTest;

import java.io.IOException;

import com.chch.interfaces.Judge;
import com.chch.urls.Iqiyi;

public class IqiyiTest {
	public static void main(String[] args) throws IOException {
		Judge j = new Iqiyi();
		boolean result = j.isRegister("18810427381");
		System.out.println(result);
	}
}
