package com.kosta.test;

import java.util.Arrays;

public class ArrayElementTest {

	public static void main(String[] args) {
		double[] salaries = {300000.0, 450000.0, 570000.0};
		System.out.println(salaries);
		
		//배열안에 있는 여러개의 값들을 출력할때 Arrays.toString()
		System.out.println(Arrays.toString(salaries));
	}

}
