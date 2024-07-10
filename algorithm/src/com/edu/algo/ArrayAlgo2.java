package com.edu.algo;

import java.util.Scanner;

public class ArrayAlgo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[10];
		
		String sum = Long.toString(a*b*c);
		for(int i = 0 ; i < sum.length() ; i++) {
			int re = Integer.parseInt(sum.substring(i, i+1));
			for(int j = 0 ; j < 10 ; j++) {
				if(j==re) arr[j]++;
		    }
		}
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(arr[i]);
	    }
		
		
		
	}
}
