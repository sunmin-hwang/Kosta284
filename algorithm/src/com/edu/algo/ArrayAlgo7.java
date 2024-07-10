package com.edu.algo;

import java.util.Scanner;

public class ArrayAlgo7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] res = new String[n];
		
		for(int i = 0 ; i < n ; i++) {
			int[] str = new int[26];
			int[] r = new int[26];
			String te = sc.next();
			String strfry  = sc.next();
			for(int j = 0 ; j < te.length() ; j++) {
				str[(int)(te.charAt(j)) - 97]++;
			}
			for(int j = 0 ; j < strfry.length() ; j++) {
				r[(int)(strfry.charAt(j)) - 97]++;
			}
			boolean p = true;
			for(int j = 0 ; j < 26 ; j++) {
				if(str[j]!=r[j]) p = false;
			}
			if(p) {
				res[i] = "Possible";
			}else {
				res[i] = "Impossible";
			}
		}
		
		for(String re : res) {
			System.out.println(re);
		}
		
	}
}
