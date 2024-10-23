package com.edu.algo.workshop;

import java.util.Scanner;

public class FlattenBoxTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int[] results = new int[10];
		for(int k = 0 ; k < 10 ; k++) {
			int dumpNum = sc.nextInt();
		    int[] heights = new int[100];
		    int maxNum = 0;
		    int max = 0;
		    int minNum = 0;
		    int min = 100;
		
		    for(int i = 0 ; i < 100 ; i++) {
		    	heights[i] = sc.nextInt();
		    }
		    for(int i = 0 ; i < dumpNum ; i++) {
			    for(int j = 0 ; j < 100 ; j++) {
				    if(heights[j] >= max) {
				    	maxNum = j;
					    max = heights[j];
				    }
				    if(heights[j] <= min) {
					    minNum = j;
					    min = heights[j];
				    }
			    }
			    heights[maxNum] -= 1;
			    heights[minNum] += 1;
			    results[k] = max-min;
			    maxNum = 0; max = 0; minNum = 0; min = 100;
		    }
		}
		for(int i = 0 ; i < 10 ; i++) System.out.println("#" + (i+1) + " " + results[i]);
	}
}
