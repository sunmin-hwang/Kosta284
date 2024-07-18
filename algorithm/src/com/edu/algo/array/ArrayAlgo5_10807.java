package com.edu.algo.array;

import java.util.Scanner;

public class ArrayAlgo5_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			if(arr[i] == v) sum++;
		}
		System.out.println(sum);
	}
}
