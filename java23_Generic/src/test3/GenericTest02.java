package test3;
/*
 제한된 파라미터 타입
 ::
 메소드 반환타입, 메소드 매개변수 타입으로 가능....
 클래스 타입에서는 적용될 수 없다.
 ::
 <T extends Number>
 T에 올 수 있는 클래스 타입은 Number의 자식클래스...
 Long, Integer, Double, Float, Byte, Short, Number...이런 값들은 다룰 때 사용된다.
 ::
 
 */

public class GenericTest02 {
	//제한된 파라미터 타입을 갖는 제너릭 메소드 정의
	public static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + 
	                                    t2.getClass().getSimpleName() + ")");
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return (v1==v2);
	}
	
	public static void main(String[] args) {
		boolean result = compare(10, 20);
		System.out.println(result);
		
		boolean result2 = compare(4.5, 4.5);
		System.out.println(result2);
	}
}
