package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackAlgo4_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> re = new Stack<Integer>();
		List<Integer> arr = new ArrayList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < num ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		while(--num>=1) {
			int n = arr.get(num);
			boolean isre = false;
			for(int i = num - 1 ; i >= 0; i--) {
				if(arr.get(i)>n) {
					re.push(i+1);
					isre = true;
					break;
				}
			}
			if(!isre) {
				re.push(0);
			}
		}
		re.push(0);
		while (!re.empty()) {
			sb.append(re.pop() + " ");
			
		}
		System.out.println(sb);
	}
}
