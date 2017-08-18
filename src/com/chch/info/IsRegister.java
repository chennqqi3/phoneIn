package com.chch.info;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.chch.interfaces.Judge;

public class IsRegister {
	public IsRegister(String phoneNum) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("Acfun", "A站");
		map.put("Dajie", "大街网");
		map.put("Iqiyi", "爱奇艺");
		map.put("Jd", "京东");
		map.put("Kanzhun", "看准网");
		map.put("Lvmama", "驴妈妈旅游");
		map.put("Qichezhijia", "汽车之家");
		map.put("QQ", "QQ");
		map.put("Quna", "去哪儿");
		map.put("Renren", "人人网");
		map.put("Shijijiayuan", "世纪佳缘网");
		map.put("Sina", "新浪微博");
		map.put("Sohu", "搜狐");
		map.put("Tianya", "天涯社区");
		map.put("Tuniu", "途牛旅游网");
		map.put("Zhonghuayingcai", "中华英才网");
		map.put("Ziroom", "自如");
		
		
		
		
		LinkedList<String> testList = new LinkedList<>();
		testList.add("com.chch.urls.Acfun");
		//testList.add("com.chch.urls.Dajie");
		testList.add("com.chch.urls.Iqiyi");
		testList.add("com.chch.urls.Jd");
		testList.add("com.chch.urls.Kanzhun");
		testList.add("com.chch.urls.Lvmama");
		testList.add("com.chch.urls.Qichezhijia");
		testList.add("com.chch.urls.QQ");
		testList.add("com.chch.urls.Quna");
		testList.add("com.chch.urls.Renren");
		testList.add("com.chch.urls.Shijijiayuan");
		testList.add("com.chch.urls.Sina");
		testList.add("com.chch.urls.Sohu");
		testList.add("com.chch.urls.Tianya");
		testList.add("com.chch.urls.Tuniu");
		testList.add("com.chch.urls.Zhonghuayingcai");
		testList.add("com.chch.urls.Ziroom");
		
		
		for(String test:testList)
		{
			Class<?> myclass = Class.forName(test);
			Object o = myclass.newInstance();
			Judge x = (Judge)o;
			//System.out.println(test.split("\\.")[3] + "\t-->" + x.isRegister("13805044961"));
			//System.out.println(map.get(test.split("\\.")[3]) + ":" + x.isRegister("13719000885"));
			System.out.println(map.get(test.split("\\.")[3]) + ":" + x.isRegister(phoneNum));
		}
	}
}
