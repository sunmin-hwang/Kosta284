package com.edu.algo;

import java.util.Scanner;

public class ArrayAlgo8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] str = new int[26];
		int[] r = new int[26];
		String te = sc.next();
		String ene  = sc.next();
		for(int j = 0 ; j < te.length() ; j++) {
			str[(int)(te.charAt(j)) - 97]++;
		}
		for(int j = 0 ; j < ene.length() ; j++) {
			r[(int)(ene.charAt(j)) - 97]++;
		}
		int sum = 0;
		for(int j = 0 ; j < 26 ; j++) {
			if(str[j]!=r[j]) sum += Math.abs(str[j]-r[j]);
		}
		System.out.println(sum);
	}
}
