package com.edu.collection3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortTest1 {
	public static void main(String[] args) {
		System.out.println("List 정렬하기");
		
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(9);
		list.add(3);
		list.add(33);
		
		System.out.println(list); // [11, 9, 3, 33] --> [3, 9, 11, 33]
		
		System.out.println("======= 오름차순 정렬 ===========");
		
		Collections.sort(list);//정렬 진행
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) System.out.println(it.next()); //출력해서 확인
		
		System.out.println("======= 내림차순 정렬 ===========");
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 큰수 - 작은수..양수..내림차순 정렬 / 작은수 - 큰수..음수..오름차순 정렬 
			}
		});//내림차순
		
		Iterator<Integer> it2 = list.iterator();
		while(it2.hasNext()) System.out.println(it2.next()); //출력해서 확인
	}
	
}
