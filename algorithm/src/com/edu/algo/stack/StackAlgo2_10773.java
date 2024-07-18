package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackAlgo2_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		Stack<Integer> st = new Stack<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			int x = Integer.parseInt(br.readLine());
			switch (x) {
				case 0: {
					st.pop();
					break;
				}default:{
					st.add(x);
				}
			}
		}
		while(!st.empty()) sum += st.pop();
		System.out.println(sum);
	}
}
