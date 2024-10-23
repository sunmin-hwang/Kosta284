package com.edu.collection2;

import java.util.Collections;
import java.util.HashMap;

import com.edu.vo.Customer;

public class HashMapTest3 {
	public static void main(String[] args) {
		HashMap<String, Customer> map = new HashMap<>();
		map.put("111", new Customer("111", 11, "AAA"));
		map.put("222", new Customer("222", 22, "BBB"));
		map.put("333", new Customer("333", 33, "CCC"));
		
		//1. map에 들어있는 사람중에서 222
		if(map.containsKey("222")) {
			System.out.println(map.get("222"));
		}
		
		//2. 이름이 CCC인 사람을 찾아서 그 사람의 나이를 콘솔로 출력
		for(Customer c : map.values()) {
			if(c.getName().equals("CCC")) System.out.println(c.getAge());
		}
		
		//3. map에 있는 사람중에서 최고연령과 최소연령의 사람을 각각 출력
//		int max = 0;
//		int min = 100;
//		Customer maxCus = null;
//		Customer minCus = null;
//		for(Customer c : map.values()) {
//			if(c.getAge()>=max) {
//				max = c.getAge();
//				maxCus = c;
//			}
//			if(c.getAge()<=min) {
//				min = c.getAge();
//				minCus = c;
//			}
//		}
//		System.out.println(maxCus);
//		System.out.println(minCus);
		//System.out.println(Collections.max(map.values()));
		
	}
}
