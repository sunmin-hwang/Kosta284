package com.edu.collection1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//시스템 위에 탑재된 자바 관련 환경변수들이 어떤 값들이 있는지
//전부다 가져와서 콘솔로 출력
public class PropertiesTest1 {
	public static void main(String[] args) {
		Properties p = System.getProperties();
		
		//1. Enumeration 사용법
		/*Enumeration e = p.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = (String)p.get(key);
			
			System.out.println(key + "========================" + value);
		}*/
		
		//2. Iterator 사용법
		/*Set set = p.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = (String)p.get(key);
			
			System.out.println(key + "========================" + value);
		}*/
		
		
		//3. 
		/*Iterator it = p.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = (String)p.get(key);
			
			System.out.println(key + "========================" + value);
		}*/
		
		//4.
		/*for(Object key : p.keySet()) {
			String value = (String)p.get(key);
			
			System.out.println(key + "========================" + value);
		}*/
		
		//5. forEach 람다식. java 1.8버전 이상에서만 사용 가능하다.
		p.forEach((key, value)->
		    System.out.println(key + "========================" + value)
		);
	}
}
