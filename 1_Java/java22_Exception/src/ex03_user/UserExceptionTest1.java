package ex03_user;

class Boom extends Exception{
	
	public Boom() {
		this("This is Boom Exception");
	}

	public Boom(String message) {
		super(message);
	}
	
}

class User{
	public void calc(int x, int y) throws Boom{//임의의 값 x,y가 인자값...호출시
		System.out.println("2. calc 함수 호출....");
		if(x==0) 
		//ArithmeticException 을 발생시킨다..
			throw new Boom("0이지롱");
		//연산이 진행... y/x
		System.out.println("3. calc 함수 호출....x는 0이 아닙니다.");
	}
}

public class UserExceptionTest1 {
	public static void main(String[] args) {
		System.out.println("1. User 객체 생성...");
		User user = new User();
		try {
			user.calc(0, 12);			
		} catch (Boom e) {
			System.out.println("3. 폭탄처리....x는 0이었네요");
			
			System.out.println(e.getMessage());
		}
		System.out.println("4. 폭탄처리 성공....");
	}
}
