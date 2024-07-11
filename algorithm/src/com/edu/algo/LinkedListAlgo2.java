package com.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListAlgo2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<String> left = new LinkedList<String>();
		LinkedList<String> right = new LinkedList<String>();
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < m ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < str.length() ; j++) {
				switch (str.substring(j, j+1)) {
				    case ">" : {
					    if(right.size() != 0) {
					    	if(right.getFirst().equals("\n")) {
					    		left.add(right.remove());
					    	}
					    	left.add(right.remove());
					    }
					    break;
				    } case "<" : {
				    	if(left.size() != 0) {
				    		if(left.getLast().equals("\n")) {
				    			right.add(left.remove());
					    	}
				    		right.addFirst(left.removeLast());
				    	}
					    break;
				    } case "-" : {
				    	if(left.getLast().equals("\n")) {
			    			right.add(left.remove());
				    	}
					    if(left.size() != 0) left.removeLast();
					    break;
				    }
				    default:
					    left.add(str.substring(j, j+1));
				}
			}
			if(right.size() == 0) {
				left.add("\n");
			}else {
				left.add(" ");
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
