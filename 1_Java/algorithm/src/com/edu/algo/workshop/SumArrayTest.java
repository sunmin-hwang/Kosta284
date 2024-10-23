package com.edu.algo.workshop;

import java.util.Scanner;

public class SumArrayTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int[] results = new int[10];
		
		for(int k = 0 ; k < 10 ; k++ ) {
			sc.nextInt();
			int[][] arr = new int[100][100];
			int max = 0;
			int width = 0;
			int height = 0;
			int right = 0;
			int left = 0;
			for(int i = 0 ; i < 100 ; i++) {
				for(int j  = 0 ; j < 100 ; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for(int i = 0 ; i < 100 ; i++) {
				for(int j  = 0 ; j < 100 ; j++) {
					width += arr[i][j]; 
					height += arr[j][i];
					if(i == j) right += arr[i][j];
					if(i + j == 9) left += arr[i][j];
				}
				if(max <= width) max = width;
				if(max <= height) max = height;
				if(max <= right) max = right;
			    if(max <= left) max = left;
				width = 0;
				height = 0;
			}
			results[k] = max;
		}
		for(int i = 0 ; i < 10 ; i++) System.out.println("#" + (i+1) + " " + results[i]);
	}

}
