package step1;

@FunctionalInterface
interface Attackable{
	void attack(); //인자값 x | 반환타입 x
}

@FunctionalInterface
interface Moveable{
	void move(int right, int left);//인자값 2개 | 반환타입 x
}

class Fighter {
	public void action(Attackable a) {
		a.attack();
	}
	public void action(Moveable m) {
		m.move(10, 20);
	}
}

public class LambdaTest5 {
	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		
		//실행문이 하나일때...
		//fighter.action(() -> System.out.println("다 뒤졌다"));
		
		fighter.action(()->{
			System.out.println("어떻게 됐을까");
			System.out.println("다 뒤졌다");
		});
		System.out.println("========================================\n");
		
		//2...Moveable을 람다식으로 구현...
		//오른쪽으로 1000km이동합니다.
		//왼쪽으로 2000km이동합니다.
		fighter.action((right, left) -> {
			System.out.println("오른쪽으로 " + right * 100 + "km이동합니다.");
			System.out.println("왼쪽으로 " + left * 100 + "km이동합니다.");
		});
	}
}
