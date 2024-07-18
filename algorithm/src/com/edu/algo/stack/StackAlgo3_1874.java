package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackAlgo3_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		int idx = 1;
		
		for(int i = 1 ; i <= num ; i++) {
			int x = Integer.parseInt(br.readLine());
			for(int j = idx ; j <= x ; j++) {
				st.add(j);
				idx++;
				sb.append("+\n");
			}
			if(st.lastElement()>x) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			st.pop();
			sb.append("-\n");
			
		}
		System.out.println(sb);
	}
}
