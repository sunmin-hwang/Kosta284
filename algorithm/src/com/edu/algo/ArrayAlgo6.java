package com.edu.algo;

import java.util.Scanner;

public class ArrayAlgo6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[6][2];
		int k = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			arr[grade-1][gender]++;
		}
		
		int sum = 0;
		for(int i = 0 ; i < 6 ; i++) {
			if(arr[i][0] % k == 0) sum += arr[i][0] / k;
			else sum += arr[i][0] / k + 1;
			if(arr[i][1] % k == 0) sum += arr[i][1] / k;
			else sum += arr[i][1] / k + 1;
		}
		System.out.println(sum);
	}
}
