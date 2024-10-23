package com.edu.array.test1;
/*
  배열
  1) 선언
  2) 생성    --- 반드시 배열의 사이즈가 명시
  3) 초기화
*/
public class BasicArrayTest2 {

	public static void main(String[] args) {
		//1) 선언 + 2)생성(size 명시)
		int[] arr = new int[3];
		
		//3) 명시적 초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		//for(int i = 0 ; i < arr.length ; i++) System.out.print(arr[i] + " ");
		//향상된 for 문 사용.."뭐가 어디서 돌아가는가"
		for(int value : arr) System.out.println(value);
	}

}
