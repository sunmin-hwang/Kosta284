package com.edu.collection1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest2 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("이수근", 80);
		map.put("서장훈", 95);
		map.put("김희철", 60);
		
		int total = 0;
		System.out.println("============= keySet() =================");
		for(String key : map.keySet()) {
			int score = map.get(key);
			total += score;
		}
		System.out.println("모든 사람들의 성적의 총합은 " + total + "점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 " + total/map.size() + "점 입니다.");
		
		System.out.println("============= values() =================");
		int sum = 0;
		for(int v: map.values()) sum += v;
		System.out.println("모든 사람들의 성적의 총합은 " + sum + "점 입니다.");
		System.out.println("모든 사람들의 성적의 평균은 " + sum/map.size() + "점 입니다.");
		
		System.out.println("============= Collections =================");
		System.out.println("최고성적은 " + Collections.max(map.values()) + " 점입니다");
		System.out.println("최고성적은 " + Collections.min(map.values()) + " 점입니다");
		
	}
}
