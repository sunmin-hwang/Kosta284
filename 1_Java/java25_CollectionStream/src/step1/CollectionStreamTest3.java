package step1;

import java.util.*;

//병렬처리 작업 코드로 확인
public class CollectionStreamTest3 {
	public static void main(String[] args) {
		//직렬처리...main스레드 혼자 작업
		/*
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		long start = System.currentTimeMillis();
		numbers.forEach(number -> {
		    try {
			    Thread.sleep(1000);
			    System.out.println(number + ": " + Thread.currentThread().getName());
		    } catch (InterruptedException e) {}	
		});
		long duration = (System.currentTimeMillis() - start);
		double seconds = duration / 1000.0;
		System.out.printf("Done in %.2f sec\n", seconds);
		*/
		
		//병렬처리
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		long start = System.currentTimeMillis();
		numbers.parallelStream().forEach(number -> {
		    try {
			    Thread.sleep(1000);
			    System.out.println(number + ": " + Thread.currentThread().getName());
		    } catch (InterruptedException e) {}	
		});
		long duration = (System.currentTimeMillis() - start);
		double seconds = duration / 1000.0;
		System.out.printf("Done in %.2f sec\n", seconds);
	}
}
