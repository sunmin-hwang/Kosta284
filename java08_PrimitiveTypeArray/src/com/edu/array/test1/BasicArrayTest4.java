package com.edu.array.test1;

import java.util.Scanner;

/*
  Scanner를 사용해서 맨 처음 입력받는 값으로 배열의 크기를 받아오자
  int size = sc.nextInt();
  3칸짜리 String 배열을 생성
  향상된 for문을 통해서 3명의 고객명을 배열릐 요소값으로 입력
  
  반복문을 통해서 입력된 고객이름을 출력
*/
public class BasicArrayTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("크기 입력 : ");
		int size = sc.nextInt();
		
		String[] names = new String[size];
		
		for(int i = 0 ; i < names.length ; i++) {
			System.out.print("고객이름 입력 : ");
			String name = sc.next();
			names[i] = name;
		}
		
		for(String name : names) {
			System.out.print(name + " ");
		}
		
		sc.close();
	}

}
