package test1;
	
//Generic 사용안함
//Box에 뭐든지 담을 수 있도록 설계했을때의 상황...
/*
 * 1. 뭐든지 담긴다.
 * 2. 꺼낼때마다 Object Casting 해줘야한다.
 * */
class Box{
	Object content;
	
	public Object selectContent(){
		return content;
	}
}

public class GenericTest01 {
	public static void main(String[] args) {
		Box box = new Box();
		box.content = "곰돌이인형";
		
		String bearDoor = (String) box.selectContent();
		System.out.println("박스안의 내용물은..." + bearDoor);
	}
}
