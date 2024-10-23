package test3;

import java.util.List;

abstract class Animal{
	public void eat() {
		System.out.println("Animal eating....");
	}
}

class Dog extends Animal{
	@Override
	public void eat() {
		System.out.println("Dog eat....");
	}
	
	void bark() {
		System.out.println("Dog Bark..");
	}
}

class CAt extends Animal{
	@Override
	public void eat() {
		System.out.println("Cat eat....");
	}
	
	void meow() {
		System.out.println("Cat Meow..");
	}
}

public class GenericWildCardTest4 {
	public static void main(String[] args) {
		List<Animal> animals = List.of(new Dog(), new CAt(), new Dog());
		takeAnimals(animals);
		System.out.println();
		
		List<Dog> dogs = List.of(new Dog(), new Dog());
		takeAnimals(dogs);
	}
	
	/*
	public static void takeAnimals(List<Animal> animals) {
		for(Animal a : animals) a.eat();
	}
	*/
	
	public static void takeAnimals(List<? extends Animal> animals) {
		for(Animal a : animals) a.eat();
	}
}
