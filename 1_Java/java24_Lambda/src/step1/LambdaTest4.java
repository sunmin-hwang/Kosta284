package step1;
/*
    LambdaTest2에서 기능의 매개변수로 인터페이스를 주입
    훤씬 더 간단한 코드로 다시 작성해보자.
    
    @FunctionalInterface
    
    0) 매개변수 x, 반환타입 x
    1) 매개변수 o, 반환타입 x
    2) 매개변수 x, 반환타입 o
    3) 매개변수 o, 반환타입 o
    4) 매개변수 o, 반환타입 boolean
    
 */

@FunctionalInterface
interface Calculable{
	void calculate(int a, int b); // 매개변수 2, 반환타입 X
}

public class LambdaTest4 {
	public static void main(String[] args) {
		//1. 함수형 인터페이스를 바로 사용....람다식
		Calculable c = (x, y) -> System.out.println(x + y);
		c.calculate(3, 4);
		
		//2.
		action((x, y) -> {
			int result = x + y;
			System.out.println("Result => " + result);
		});
		
		action((x, y) -> {
			int result = x * y;
			System.out.println("Result2 => " + result);
		});
	}
	
	//2. 메소드의 매개변수로 Hasing
	public static void action(Calculable cal) {
		System.out.println("action...method...");
		int a = 11;
		int b = 22;
		
		cal.calculate(a, b);
	}
}
