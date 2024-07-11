package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListAlgo2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < m ; i++) {
			LinkedList<String> left = new LinkedList<String>();
			LinkedList<String> right = new LinkedList<String>();
			String str = br.readLine();
			for(int j = 0 ; j < str.length() ; j++) {
				switch (str.substring(j, j+1)) {
				    case ">" : {
					    if(!right.isEmpty()) {
					    	left.add(right.remove());
					    }
					    break;
				    } case "<" : {
				    	if(!left.isEmpty()) {
				    		right.addFirst(left.removeLast());
				    	}
					    break;
				    } case "-" : {
					    if(!left.isEmpty()) {
					    	left.removeLast();
					    }
					    break;
				    }
				    default:
					    left.add(str.substring(j, j+1));
				}
			}
			
			right.addLast("\n");
			
			
			while(!left.isEmpty()) {
				sb.append(left.remove());
			}
			while(!right.isEmpty()) {
				sb.append(right.remove());
			}
			
		}
		
		
		System.out.print(sb);
	}
}