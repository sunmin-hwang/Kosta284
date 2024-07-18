package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackAlgo4_2493_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> arr = new ArrayList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> re = new Stack<Integer>();
		for(int i = 0 ; i < num ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
			while(!re.empty()&&re.peek()<arr.get(i)) {
				re.pop();
			}
			if(re.empty()) {
				sb.append("0 ");
			}else {
				sb.append((arr.indexOf(re.peek())+1)+ " ");
			}
			re.push(arr.get(i));
		}
		System.out.println(sb);
	}
}
