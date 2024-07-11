package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListAlgo1final {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<String> left = new LinkedList<String>();
		LinkedList<String> right = new LinkedList<String>();
		
		String str = br.readLine();
		for(int i = 0 ; i < str.length() ; i++) {
			left.add(str.substring(i, i+1));
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			String s = br.readLine();
			if((s.charAt(0)) == ('P')) {
				left.add(s.split(" ")[1]);
			}else if (s.equals("L")) {
				if(left.size() != 0) right.addFirst(left.removeLast());
			}else if (s.equals("D")) {
				if(right.size() != 0) left.add(right.remove());
			}else if (s.equals("B")) {
				if(left.size() != 0) left.removeLast();
			}
		}
		while(!left.isEmpty()) {
			sb.append(left.remove());
		}
		while(!right.isEmpty()) {
			sb.append(right.remove());
		}
		System.out.print(sb);
	}
}
