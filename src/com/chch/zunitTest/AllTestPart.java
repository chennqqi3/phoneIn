package com.chch.zunitTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.chch.interfaces.Judge;


public class AllTestPart {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		
		LinkedList<String> testList = new LinkedList<>();
		Map<String, String> map = new HashMap<String,String>();
		map.put("Acfun", "A站");
		map.put("Dajie", "大街网");
		map.put("Jd", "京东");
		
		
//		testList.add("com.chch.urls.Jd");
//		testList.add("com.chch.urls.unfinished.F58");
//		testList.add("com.chch.urls.Wubatongcheng");
//		testList.add("com.chch.urls.Baidu");
//		testList.add("com.chch.urls.unfinished.YY");
//		testList.add("com.chch.urls.Chushou");
//		testList.add("com.chch.urls.Fangtianxia");
		testList.add("com.chch.urls.Kuwo");
		for(String test:testList)
		{
			Class myclass = Class.forName(test);
			Object o = myclass.newInstance();
			Judge x = (Judge)o;
//			System.out.println(map.get("Jd") + "\t-->" + x.isRegister("15116954388"));
			System.out.println(test + "\t-->" + x.isRegister("15116954388"));
		}
	}
}
