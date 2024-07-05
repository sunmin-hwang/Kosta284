package com.edu.vo;
/*
 * Notebok의 정보를 저장하고있는 클래스(VO) --> table의 하나의 줄을 instance 시키는 class
 * 
 * */
public class NoteBook {
	//field 선언
	public int serialNumber;
	public String brand;
	public double price;
	
	public NoteBook() { } //기본 생성자
	
	//명시적 생성자.. setter 기능과 동일
	//필드 초기화
	public NoteBook(int serialNumber, String brand, double price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}

	//기능 추가...필드에 값을 할당,주입, setter(inject)
	/*
	 * field와 local V의 이름이 동일할 때 이 둘을 구분하기 위해서 필드 앞에 this를 지정
	 * this는 해당 객체의 주소값을 참조하고 있다.
	 * */
	public void setNoteBookField(int serialNumber, String brand, double price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}
	
	//기능 추가...필드에 주입된 값을 받아옴, getter(reading)
	public String getNoteBookInfo() {
		//String과 NonString이 만나면 String으로 바뀜
		return serialNumber + "," + brand + "," + price;
	}
	
	//method 정의(선언 + 구현부)
	//void : 반환타입 - 해당 기능을 수행한 후 반환되는 데이터가 없다는 의미의 반환타입
	public void printNoteBookInfo() {
		System.out.println(serialNumber+","+brand+","+price);
	}
}
