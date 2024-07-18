package com.edu.algo.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class LinkedListAlgo3_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<Integer> list = new LinkedList<Integer>();
		List<Integer> re = new LinkedList<Integer>();
		
		String input = br.readLine();
		int n = Integer.parseInt((input.split(" ")[0]));
		int k = Integer.parseInt((input.split(" ")[1]));
		int k1 = 1;
		
		for(int i = 1 ; i <= n ; i++) {
			list.add(i);
		}
		
		while(!list.isEmpty()) {
			k1 += k-1;
			if(k1 > list.size()) {
				if(k<=list.size()) k1 -= list.size();
				else {
					while(k1 > list.size()) k1 -= list.size();
				}
			}
			re.add(list.remove(k1-1));
		}
		sb.append("<");
		for(int i = 0 ; i < re.size() - 1 ; i++) {
			sb.append(re.get(i) + ", ");
		}
		sb.append(re.get(re.size()-1) + ">");
		System.out.println(sb);
	}
}
//1 2 3 4 5 6 7 3
//1 2 4 5 6 7   5 
//1 2 4 5 7     2
//1 4 5 7       4
//1 4 5         3
//1 4           1
//4