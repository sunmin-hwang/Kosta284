package ex01_runtime;
/*
 try~catch 구문에서 catch는 여러번 잡을 수 있다.
 Exception으로 한번에 크게 잡을 수 있다.
 */
public class RuntimeExceptionTest3 {
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
			} catch (Exception e) {
				System.out.println("Exception Nice Catch~~!!");
			}
			
		}
		System.out.println("The  End...");
	}
}
