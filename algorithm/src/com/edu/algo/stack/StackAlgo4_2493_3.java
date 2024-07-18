package com.edu.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackAlgo4_2493_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<int[]> arr = new ArrayList<>();
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> re = new Stack<>();
		for(int i = 0 ; i < num ; i++) {
			int[] a = new int[2];
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = i;
			arr.add(a);
			while(!re.empty()&&re.peek()[0]<arr.get(i)[0]) {
				re.pop();
			}
			if(re.empty()) {
				sb.append("0 ");
			}else {
				sb.append((re.peek()[1]+1)+ " ");
			}
			re.push(a);
		}
		System.out.println(sb);
	}
}
