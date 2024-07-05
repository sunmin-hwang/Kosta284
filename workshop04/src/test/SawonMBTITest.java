package test;
import java.util.Scanner;
/*
6
1 4 4 4 5 3
*/
public class SawonMBTITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("K전자 신입사원수 입력 >>> ");
		int num = sc.nextInt();//배열의 사이즈
		int[ ] people =new int[num]; //6
		
	    System.out.println("공백을 기준으로 각 사원에 대한 성격 유형을 직접 입력 >>> ");
		//배열 초기화
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt(); //1,4,4,4,5,3(5가지의 타입이 있음)
		}//사람들의 타입 지정이 끝났음...
		
			
		
		// 코드 작성
		int[] mbtiArr = new int[5];
		for(int type : people) {
			mbtiArr[type-1]++;
		}
		
		int answer = 0;
		int maxNum = 0;
		int mbtiNum = 1;
		for(int mbti : mbtiArr) {
			if(mbti > maxNum) {
				maxNum = mbti;
				answer = mbtiNum;
			}
			mbtiNum++;
		} 
		
		
		
		
		System.out.println("정답 :: "+answer);
		sc.close();
	}
}










