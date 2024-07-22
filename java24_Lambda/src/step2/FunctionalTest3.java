package step2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 Collection :: 객체를 저장하는 방법론
 List | Map | Set | Iterable
 
  8버전 이후에 함수형 인터페이스를 Hasing하면서 제공되는 기능이 추가..
  
  Collection : boolean removeIf(Predicate p)
  List : void replaceAll()
  Map : compute(), forEach(!!!!!), merge()
 */
public class FunctionalTest3 {
	public static void main(String[] args) {
		//List 생성(1,2,3,4,5,6,7,8,9,10 값 담김)
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10 ; i++) list.add(i);
		
		//Map 생성
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(111, "SCOTT");
		map.put(222, "BLAKE");
		map.put(333, "KING");
		
		// 1. 리스트에 담긴 객체를 뽑아서 정보 출력
		/*
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
		System.out.println("1. 리스트에 담긴 객체를 뽑아서 정보 출력 ===> forEach()");
		list.forEach(i -> System.out.print(i + " "));
		//list.forEach(System.out::print);
		
		// 2. list에 담긴 값중에서 2의 배수 혹은 3의 배수를 제거한후 출력...removeIf(Predicate p)
		System.out.println("\n2. list에 담긴 값중에서 2의 배수 혹은 3의 배수를 제거한후 출력 ===> removeIf");
		list.removeIf(i-> i % 2 == 0 || i % 3 == 0);
		list.forEach(i->System.out.print(i + " "));
		
		System.out.println("\n3. list의 모든 값들을 10 곱한다 ===> replaceAll()");
		list.replaceAll(i -> i * 10);
		list.forEach(i->System.out.print(i + " "));
		
		System.out.println("------------------ map ---------------------");
		System.out.println("\n4. Map에 있는 모든 key, value값을 출력 ===> iterator()");
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			System.out.println("key : " + key + ", " + "value : " + map.get(key) + " ");
		}
		
		System.out.println("\n5. Map에 있는 모든 key, value값을 출력 ===> forEach()");
		map.forEach((key, value) -> System.out.println("key : " + key + ", " + "value : " + value + " "));;
	}
}
