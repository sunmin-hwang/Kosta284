package com.edu.condition.test3;

public class OperatorTest1 {

	public static void main(String[] args) {
		
		int i = 5;
		int j = 3;
		
		// %  ..mod(ulus)...나머지
		
		
		System.out.println("연산자 % : " + i%j); //2
		System.out.println("연산자 / : " + i/j); //1
		
		/*
		 * 98
		 * 두자리 수
		 * 십의자리 : 9
		 * 일의자리 : 8
		 * */
		
		int num = 98;
		System.out.println("십의자리 => " + num/10);
		System.out.println("일의자리 => " + num%10);
		
		int k = 10;
		//1 씩 증가 -> ++, 1 씩 감소 -> --
		System.out.println(k++);//10 다음 라인으로 내려갈 때 증가
		System.out.println(k); //11
		
		int m = 10;
		System.out.println(++m);//11 증가 후 현재 줄 실행
		System.out.println(m); //11
		
		///////// same ///////////////////////////////////
		Operator1 o1 = new Operator1();
		Operator1 o2 = new Operator1();
		System.out.println(o1 + "\n" + o2);
		System.out.println(o1==o2); //false
		System.out.println(o1 != o2); //true
		
		//////// short circuit //////////////////////////
		System.out.println(o1.test1() | o1.test2()); //true
		System.out.println("##################################");
		System.out.println(o1.test2() & o1.test1()); //false
		
		System.out.println("===============================");
		System.out.println(o1.test1() || o1.test2()); // 앞에가 true면 뒤에 실행 X
		System.out.println("##################################");
		System.out.println(o1.test2() && o1.test1()); // 뒤에가 false면 뒤에 실행 X
		
		//equals()  ==
		System.out.println("===========Operator1 equals()===============");
		System.out.println(o1.equals(o2)); //false
		System.out.println(o1==o2); //false
		String msg1 = "Hello";
		String msg2 = "Hello";
		System.out.println("===========String equals()===============");
		System.out.println(msg1.equals(msg2));//true --> equals 함수는 주소값 비교하지만 String 에서는 문자열비교
		System.out.println(msg1 == msg2);//이건 사용 X
	}

}

class Operator1 {
	public boolean test1() {
		System.out.println("test1() calling.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling.....");
		return false;
	}
}

class Operator2 {
	public boolean test1() {
		System.out.println("test1() calling.....");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2() calling.....");
		return false;
	}
}