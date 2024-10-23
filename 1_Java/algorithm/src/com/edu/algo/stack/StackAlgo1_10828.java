package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackAlgo1_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			String x = br.readLine();
			switch (x) {
				case "pop": {
					if(!st.empty()) {
						sb.append(st.pop() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}case "size": {
					sb.append(st.size() + "\n");
					break;
				}case "empty": {
					if(st.empty()) {
						sb.append(1 + "\n");
					}else sb.append(0 + "\n");
					break;
				}case "top": {
					if(!st.empty()) {
						sb.append(st.lastElement() + "\n");
					}else sb.append(-1 + "\n");
					break;
				}default:{
					int n = Integer.parseInt(x.split(" ")[1]);
					st.push(n);
				}
			}
		}
		System.out.println(sb);
	}
}
