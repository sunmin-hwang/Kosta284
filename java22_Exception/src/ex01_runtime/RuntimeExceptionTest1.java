package ex01_runtime;
/*
 Runtime 계열 예외
 예외처리를 직접적으로 할 필요가 없이 바로 소스를 수정하면 된다.
 하지만 이 코드를 가지고 직접적으로 예외처리하는 방법을 익혀보도록한다.
 */
public class RuntimeExceptionTest1 {
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
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch~~!!");
			}
		}
		System.out.println("The  End...");
	}
}
