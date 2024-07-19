package test2;

import java.util.ArrayList;
import java.util.List;

/*
* 해당 클래스에서는 Generic 기법을 사용
* 1. 뭐든지 담긴다.
* 2. 꺼낼때마다 Object Casting 해주지 않아도 된다.
* */
class Box<T>{ //T라는 클래스는 실제로 존재하지 않지만 Type을 의미한다.
	T content; //Box엔 T타입의 내용들이 담겨진다. T타입은 나중(사용시)에 구체적인 타입으로 대체된다.
	
	public T selectContent(){
		return content;
	}
}

public class GenericUpdateTest1 {
	public static void main(String[] args) {
		Box<String> box = new Box();
		box.content = "곰인형";
		
		String bear = box.selectContent();
		System.out.println("담겨진 것은 " + bear); // Object Casting을 할 필요없다.
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(10); //Auto Boxing
		list.add(20);
		list.add(30);
		
		System.out.println(list); //10,20,30...UnBoxing
	}
}
