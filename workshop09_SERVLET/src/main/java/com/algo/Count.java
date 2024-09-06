package com.algo;

import java.util.ArrayList;

public class Count {

	public String execute(String book) {
		//구현하세요
		String[] words = book.toLowerCase().split(" ");
		ArrayList<String[]> arr = new ArrayList<String[]>();
		for(String word : words) {
			boolean exist = false;
			for(String[] a : arr) {
				if(word.equals(a[0])) {
					a[1] = Integer.toString((Integer.parseInt(a[1])+1));
					exist = true;
				}
			}
			if(!exist) {
				arr.add(new String[] {word, "1"});
			}
		}
		String[] maxWord = arr.get(0);
		for(String[] a : arr) {
			if(Integer.parseInt(a[1])==Integer.parseInt(maxWord[1])) {
				if(a[0].compareTo(maxWord[0])<0) {
					maxWord = a;
				}
			}else if(Integer.parseInt(a[1])>Integer.parseInt(maxWord[1])) {
				maxWord = a;
			}
		}
		return maxWord[0];
	}

// public static void main(String[] args) {
//		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
//		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
//		String book3 ="I like cat. I like cat. I like cat. ";
//		Count c = new Count();
//		System.out.println(c.execute(book1));
//		System.out.println(c.execute(book2));
//		System.out.println(c.execute(book3));
//
//	}

}
