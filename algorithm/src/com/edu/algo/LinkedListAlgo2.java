package com.edu.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListAlgo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new LinkedList<String>();
		String str = sc.next();
		for(int i = 0 ; i < str.length() ; i++) {
			list.add(str.substring(i, i+1));
		}
		int cusur = str.length();
		int m = sc.nextInt();
		for(int i = 0 ; i < m ; i++) {
			String s = sc.next();
			if(s.equals("P")) {
				String ch = sc.next();
				list.add(cusur++, ch);
			}else if (s.equals("L")) {
				if(cusur!=0) cusur--;
			}else if (s.equals("D")) {
				if(cusur!=list.size()) cusur++;
			}else if (s.equals("B")) {
				if(cusur!=0) list.remove(--cusur);
			}
		}
		for(int i = 0 ; i < list.size() ; i++)
		System.out.print(list.get(i));
	}
}
