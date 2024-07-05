package com.edu.condition.test3;

import java.util.Scanner;

public class Pattern369Test {

	public static void solv(int number){
		String atSign = "";
		if(number / 10 % 3 == 0) {
			atSign += "@";
			if(number % 10 % 3 == 0) {
				atSign += "@";
			}
		}else {
			if(number % 10 % 3 == 0) {
				atSign += "@";
			}else {
				System.out.println(number);
				System.exit(0);
			}
		}
		
		System.out.println(atSign);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2자리 숫자 입력 >> ");
		int n = sc.nextInt();
		
		solv(n);
		
		sc.close();
	}

}
