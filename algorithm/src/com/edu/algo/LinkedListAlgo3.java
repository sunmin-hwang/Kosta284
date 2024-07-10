package com.edu.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListAlgo3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new LinkedList<Integer>();
		List<Integer> re = new LinkedList<Integer>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int k1 = k;
		
		for(int i = 1 ; i < n ; i++) {
			list.add(i);
		}
		
		while(list.isEmpty()) {
			//if(k >= list.size())
		}
	}
}
//1 2 3 4 5 6 7 3
//1 2 4 5 6 7   5 
//1 2 4 5 7     2
//1 4 5 7       4
//1 4 5         3
//1 4           1
//4