package step1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest3 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(100,45,200,33,44,3,1,99);
		
		Collections.sort(list, (o1, o2) -> o2 - o1);
		System.out.println(list);
	}
}
