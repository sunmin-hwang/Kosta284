package com.edu.algo.array;

import java.util.Scanner;

public class ArrayAlgo1_10808 {
	public static void main(String[] args) {
		int[][] alpa = new int[26][2];
		
		for(int i = 0; i < 26 ; i++) {
			alpa[i][0] = i + 97;
		}
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		for(int i = 0 ; i < s.length() ; i++) {
			for(int j = 0 ; j < 26 ; j++) {
				if(alpa[j][0] == (int)(s.charAt(i))) alpa[j][1] += 1;
			}
		}
		
		for(int i = 0; i < 25 ; i++) {
			System.out.print(alpa[i][1] + " ");
		}
		System.out.print(alpa[25][1]);
	}
}
