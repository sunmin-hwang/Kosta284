package com.edu.condition.test1;

/*
 switch(조건에 해당하는 변수){
   case 90~100: --> X
   case 95:
   case 90:
     //실행문
     
     break; --> if
     
     
   case 80:
   case 85:
     //실행문
     break;
     
   default: --> else
     //실행문
 }
 switch 문에서 break 키워드는 해당 case 문을 빠져나가고 switch 문까지 빠져나간다.
*/
public class GradeSwitchTest3 {

	public static void main(String[] args) {
		int grade = 90;
		switch (grade) {
		case 90:
		case 95:
			System.out.println("A Grade~~");
			break;
		case 80:
		case 85:
			System.out.println("B Grade~~");
			break;
		case 70:
		case 75:
			System.out.println("C Grade~~");
			break;
			
		default:
			System.out.println("Nuts~~!!");
			
		}
	}

}
