package com.chch.zunitTest;

import java.io.IOException;
import java.util.LinkedList;
import com.chch.interfaces.Judge;


public class AllTestPart {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		
		LinkedList<String> testList = new LinkedList<>();
		testList.add("com.chch.urls.Tianya");
		
		for(String test:testList)
		{
			Class myclass = Class.forName(test);
			Object o = myclass.newInstance();
			Judge x = (Judge)o;
			System.out.println(test + "\t-->" + x.isRegister("18811076523"));
		}
	}
}
