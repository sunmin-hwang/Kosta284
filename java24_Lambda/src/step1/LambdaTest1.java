package step1;
/*
 람다, 람다식
 ::
 함수형 프로그래밍
 자바는 자바8버전부터 함수형 프로그래밍 람다식을 제공
 ::
 1) 익명함수(함수명이 없다)
 2) 코드가 간결하고 성능적으로는 불리한 부분이 있다.
 3) 병렬처리 가능하다
 ::
 
 <일반적인 함수 형식>
 public int max(int a, int b){
     return a>b? a : b;
     
 <람다식>
 (int a, int b) -> { return a>b? a : b ; }
 (int a, int b) -> a>b? a : b ; (return 생략 가능 ;는 생략 안됨)
 (a, b) -> a>b? a : b ;
 
 ------------------------------------------------------------------------
 @FunctionalInterface의 구현체를 우리는 람다식으로 만들어야한다.
 그렇기 때문에 @FunctionalInterface는 단 하나의 추상메소드만 가져야 한다.
 
 */

@FunctionalInterface
interface MyFunction{ //추상메소드..단 하나인 인터페이스
	int max(int a, int b); //2개의 수중 더 큰수를 반환하는 기능 Template
}

public class LambdaTest1 {
	public static void main(String[] args) {
		//1. 익명클래스로 구현
		MyFunction f = new MyFunction() {
			
			@Override
			public int max(int a, int b) {
				return a>b? a : b ;
			}
		};
		
		int result1 = f.max(5, 3);
		System.out.println("Result1 => " + result1);
		
		//2. 람다식으로 구현(매개변수 -> 구현부;)
		MyFunction f2 = (a,b) -> a>b? a : b ;
		
		int result2 = f2.max(3, 5);
		System.out.println("Result2 => " + result2);
	}
}
