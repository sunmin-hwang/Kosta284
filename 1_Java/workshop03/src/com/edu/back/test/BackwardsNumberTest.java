package com.edu.back.test;

import java.util.Scanner;

public class BackwardsNumberTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String result = "";
		while(true) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			int number = sc.nextInt();
			if(number >= 1) {
				for(int i = number; i >= 1 ; i--) {
				    result += i + " ";
			    }
			    System.out.println(result);
			    result = "";
			}else {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}
			
		}
	}

}
