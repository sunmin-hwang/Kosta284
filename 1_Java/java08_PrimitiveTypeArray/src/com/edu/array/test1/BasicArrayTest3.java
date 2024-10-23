package com.edu.array.test1;
/*
  배열
  1) 선언
  2) 생성    --- 반드시 배열의 사이즈가 명시
  3) 초기화
*/
public class BasicArrayTest3 {

	public static void main(String[] args) {
		int[] scores = {95, 78, 66, 90, 87};
		
		//향상된 for 문을 이용해서 성적둘의 총합 / 평균값을 출력
		int sum = 0;
		for(int score : scores) sum += score;
		System.out.println("성적둘의 총합 : " + sum + ", 평균 : " + sum/scores.length);
	}

}
