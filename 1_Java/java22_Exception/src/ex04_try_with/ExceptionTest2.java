package ex04_try_with;
import java.io.BufferedReader;
//try~with~resource 구문 활용하기
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 try 문 () 괄호 안에 자원을 열어서 생성하는 문장을 넣으면 자동으로 close()를 호출하지 않아도
 try문을 벗어나는 순간 자동적으로 close()가 호출된다.
 그런 다음에 catch블럭이 차례로 수행된다...
 만약에 ()안에 다른 스트림 생성해서 여러개 넣을수도 있다. ;세미콜론으로 구분만 하면 된다.
 */
public class ExceptionTest2 {
	public static void main(String[] args){
		try(FileWriter file = new FileWriter("data.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			;//출력용 파일은 자동으로 기본경로에 생성된다.
			file.write("Hello World");
			System.out.println("파일 출력.");
		} catch (IOException e) {
			System.out.println("잡았다.");
		}
	}
}
