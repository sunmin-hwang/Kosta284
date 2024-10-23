package step1;
/*
 스트림의 특징
 1. Read Only - 스트림은 데이터소스로부터 데이터를 읽어들이기만 할뿐 변경하지 않는다.
 2. 일회용이다 - Iterator처럼 일회용이다. 최종연산 진행되면 닫힌다(필요하면 다시 생성해서 사용)
 3. 최종연산 전까지 스트림의 중간연산이 수행되지 않는다 - 지연연산
 4. 병렬처리 작업이 가능하다 - 멀티 스레드 지원
    FP(함수현 언어)는 빅데이터(대용량 작업)를 빠르게 처리하기 위해서 발전되어온 기술이다.AI
     그러기 위해서는 직렬적작업보다는 병렬작업으로 많은 양의 데이터를 효율적으로 처리하는 기술이 필수
 5. Stream<Integer>  VS    IntStream
    Stream<Double>         DoubleStream
    Stream<Long>           LongStream
    Stream<Float>          FloatStream
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionStreamTest2 {
	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Apple");
		fruits.add("Melon");
		fruits.add("Orange");
		fruits.add("Melon");
		fruits.add("Grape");
		
		//1.
		System.out.println("원본 리스트1 ::: " + fruits);
		
		Stream<String> stream = fruits.stream();
		stream.distinct().limit(3).sorted((o1, o2) -> -o1.compareTo(o2)).forEach(i -> System.out.println(i + " "));
		
		System.out.println("원본 리스트2 ::: " + fruits);
		
		
		System.out.println("\n---------------------------------------------------------------------------\n");
		//2. 문자열 배열이 소스인 스트림
		String[] strArr = {"dd", "aaa", "CC", "cc", "b"};
		Stream<String> strStream = Stream.of(strArr);
		strStream.forEach(System.out::println); // 여기서 이미 최종연산 진행됐다.(스트림 요소를 꺼냈다)
		
		/*long count = strStream.count();// 스트림이 닫혔다. 다시 사용할수 없다.
		System.out.println("남은 데이터 갯수 : " + count);*/
		
		System.out.println("\n---------------------------------------------------------------------------\n");
		//3. 1~45까지의 값을 무한반복 출력
		IntStream intStream = new Random().ints(1, 46);
		//intStream.forEach(i -> System.out.print(i + " "));
		intStream.distinct().limit(6).sorted().forEach(i -> System.out.print(i + " "));
		
		System.out.println("\n---------------------------------------------------------------------------\n");
		//4.
		String[] strArr2 = {"dd", "aaa", "CC", "cc", "b"};
		Stream<String> strStream2 = Stream.of(strArr2);
		
		//해당작업을 병렬처리로 만들수있다.
		int sum = strStream2.parallel().mapToInt(s->s.length()).sum();
		System.out.println("모든 문자열의 길이의 합 : " + sum);
	}
}
