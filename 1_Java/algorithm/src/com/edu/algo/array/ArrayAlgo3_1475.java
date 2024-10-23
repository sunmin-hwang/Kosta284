package com.edu.algo.array;

import java.util.Scanner;

public class ArrayAlgo3_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = Integer.toString(sc.nextInt());
		int[] arr = new int[10];
		
		for(int i = 0 ; i < a.length() ; i++) {
			int re = Integer.parseInt(a.substring(i, i+1));
			for(int j = 0 ; j < 10 ; j++) {
				if(j==re) arr[j]++;
		    }
		}
		
		if((arr[6] + arr[9])%2 == 0) {
			arr[6] = (arr[6] + arr[9])/2;
		}else {
			arr[6] = (arr[6] + arr[9])/2 + 1;
		}
		
		arr[9] = 0;
		
		int max = 0;
		
		for(int i : arr) {
			if(i >= max) max = i;
		}
		
		System.out.println(max);
	}
}
