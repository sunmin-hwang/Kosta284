package com.edu.condition.test3;

import java.util.Scanner;

public class CatchAMouseTest {
	public static String solv(int catA, int catB, int mouse){
		int aDistance = Math.abs(catA - mouse);
		int bDistance = Math.abs(catB - mouse);
		
		if(aDistance > bDistance) {
			return "CatB Catch!";
		}else if(aDistance < bDistance) {
			return "CatA Catch!";
		}else {
			return "Mouse Escapes!!";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();
		
		
		String result = solv(catA, catB, mouse);
		System.out.println(result);
		
		sc.close();
	}
}
