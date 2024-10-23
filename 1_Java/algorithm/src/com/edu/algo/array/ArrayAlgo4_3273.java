package com.edu.algo.array;

import java.util.Scanner;

public class ArrayAlgo4_3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int x = sc.nextInt();
		int[] sum = new int[x];
		int re = 0;
		for(int i = 0 ; i < n ; i++) {
			if(x > arr[i]) {
			    if(sum[x-arr[i]-1] == 1) {
				    re++;
			    }
			    sum[arr[i]-1]++;
			}
		}
		System.out.println(re);
	}
}
