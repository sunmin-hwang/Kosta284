package step2;

import java.util.function.Predicate;

/*
 Predicate 함수의 결합
 default method :: and(), or(), negate() 2개를 사용해서 하나의 Predicate로 결합 가능
 
 함수형인터페이스의 구성 요소
 1)추상메소드 (1)
 ---------------------
 2)static 메소드
 3)default 메소드
 하지만 가장 핵심은 추상메소드이다!!!
 */
public class FunctionalTest2 {
	public static void main(String[] args) {
		Predicate<Integer> p = i -> i<100; //100보다 작은수
		Predicate<Integer> q = i -> i<200; //200보다 작은수
		Predicate<Integer> r = i -> i%2==0; //짝수
		
		//default 함수의 결합
		Predicate<Integer> notP = p.negate(); //100보다 큰 수
		Predicate<Integer> all = notP.and(q).or(r); //i>=100 && i<200 || i%2==0
		Predicate<Integer> all2 = notP.and(q.or(r)); //i>=100 && (i<200 || i%2==0)
		
		//Predicate를 사용할때는 test() 사용
		System.out.println(all.test(2)); //true
		System.out.println(all2.test(2)); //false
	}
}
