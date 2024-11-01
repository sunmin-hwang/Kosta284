import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요.");
		
		int games = sc.nextInt();
		while(!(games >= 1 && games <= 3)) {
			System.out.println("(1~3) 값으로 다시 입력해 주세요.");
			games = sc.nextInt();
		}
		int totalGame = -1, i = 0;
		
		if(games == 1) totalGame = 5;
		else if(games == 2) totalGame = 3;
		else totalGame = 1;
		
		int result_win = 0;
		int result_lose = 0;
		int result_tie = 0;
		
		while(i<totalGame){
			i++;
			if(result_win >= (totalGame/2+1)) {
				System.out.println("\n### 인간 승");
				return;
			} else if(result_lose >= (totalGame/2+1)) {
				System.out.println("\n### 컴퓨터 승");
				return;
			}
			
			System.out.println("가위바위보 중 하나 입력: ");
			String _input = sc.next();
			int com = (int) ((Math.random()*3) + 1);
			
			if(_input.equals("가위")) {
				if(com == 1) {
					System.out.println("비겼습니다!!!");
					result_tie += 1;
				}
				else if(com == 2) {
					System.out.println("졌습니다!!!");
					result_lose += 1;
				}
				else {
					System.out.println("이겼습니다!!!");
					result_win += 1;
				}
			}
			else if(_input.equals("바위")) {
				if(com == 2) {
					System.out.println("비겼습니다!!!");
					result_tie += 1;
				}
				else if(com == 3) {
					System.out.println("졌습니다!!!");
					result_lose += 1;
				}
				else {
					System.out.println("이겼습니다!!!");
					result_win += 1;
				}
			}
			else {
				if(com == 3) {
					System.out.println("비겼습니다!!!");
					result_tie += 1;
				}
				else if(com == 1) {
					System.out.println("졌습니다!!!");
					result_lose += 1;
				}
				else {
					System.out.println("이겼습니다!!!");
					result_win += 1;
				}
			}
		}
		
		if ( result_win > result_lose) {
			System.out.println("\n### 인간 승");
		}
		else if(result_win == result_lose) {
			System.out.println("\n### 비김");
		}
		else {
			System.out.println("\n### 컴퓨터 승");
		}
		System.out.println(result_tie);
		sc.close();
	}
	
}
