package com.chch.zunitTest;

import java.io.IOException;

import com.chch.info.IsRegisterJson;

public class JsonDemo {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String result = IsRegisterJson.get("18801015896");
		System.out.println(result);
	}
}
