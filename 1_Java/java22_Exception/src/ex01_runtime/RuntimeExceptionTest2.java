package ex01_runtime;
/*
 try~catch 구문에서 catch는 여러번 잡을 수 있다.
 1. 단, 하나의 catch문만 돌아간다.
 2. 예외를 잡을 때 작은예외 --> 큰 예외 순으로 잡아야한다. 거꾸로 하면 에러난다.
 */
public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		String[] str = {
			"HEllo",
			"No, I mean it",
			"Nice to meet you"
		};
		
		int i = 0;
		while(i<=3) {
			try {
				System.out.println(str[i++]);
			} catch (NullPointerException e) { // 객체 생성하지 않고 멤버 접근했을 때 발생..폭탄
				System.out.println("NullPointerException...Nice Catch~~!!");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch~~!!");
			} catch (ArithmeticException e) { //분모를 0으로 했을 때 발생하는...폭탄
				System.out.println("ArithmeticException...Nice Catch~~!!");
			} catch (Exception e) {
				System.out.println("Exception Nice Catch~~!!");
			}
			
		}
		System.out.println("The  End...");
	}
}
