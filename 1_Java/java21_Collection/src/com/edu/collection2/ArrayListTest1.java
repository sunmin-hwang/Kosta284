package com.edu.collection2;

import java.util.ArrayList;

import com.edu.vo.Person;

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		//ArrayList list = new ArrayList();
		
	    list.add(new Person(11, "AA"));
	    list.add(new Person(22, "BB"));
	    list.add(new Person(33, "CC"));
	    list.add(new Person(44, "DD"));
	    list.add(new Person(55, "EE"));
	    
	    System.out.println(list);
	    System.out.println(list.size());
	    list.trimToSize();// size와 Capacity가 동일해진다.
	    
	    //리스트에 있는 사람중에서 2번째 사람의 정보를 출력
	    Person secondPerson = list.get(1);
	    //Person secondPerson = (Person)list.get(1);
	    
	    System.out.println(secondPerson);
	    
	    //list에 들어있는 사람들의 평균나이를 구해서 출력
	    int sum = 0;
	    for(Person p : list) {
	    	sum += p.getAge();
	    }
	    /*
	    for(Object o : list) {
	    	sum += ((Person) o).getAge();
	    }
	    */
	    System.out.println("평균 연령은 " + sum/list.size());
	}

}
