package com.chch.zunitTest;
/*
 * 加入使用反射来批量化调用
 */
import java.io.IOException;
import java.util.LinkedList;
import com.chch.interfaces.Judge;

public class AllTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		
		LinkedList<String> testList = new LinkedList<>();

		testList.add("com.chch.urls.Dajie");
		testList.add("com.chch.urls.Iqiyi");
		testList.add("com.chch.urls.Jd");
		testList.add("com.chch.urls.Kanzhun");
		testList.add("com.chch.urls.Qichezhijia");
		testList.add("com.chch.urls.QQ");
		testList.add("com.chch.urls.Quna");
		testList.add("com.chch.urls.Renren");
		testList.add("com.chch.urls.Sina");
		testList.add("com.chch.urls.Sohu");
		testList.add("com.chch.urls.Zhonghuayingcai");
		
		
		for(String test:testList)
		{
			Class<?> myclass = Class.forName(test);
			Object o = myclass.newInstance();
			Judge x = (Judge)o;
			System.out.println(test + "\t-->" + x.isRegister("18801017533"));
		}
	}
}
