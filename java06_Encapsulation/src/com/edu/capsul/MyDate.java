package com.edu.capsul;
//오늘 날짜정보를 저장하는 클래스
public class MyDate {
	 
	int month; //--> 같은 패키지 안에서 접근을 허용 (디폴트 허용 범위)
	private int day; //--> 해당 클래스에서 접근을 허용
	
	/*
	 * 1~12에 해당하는 월 값이 들어올때만 필드에 값을 할당
	 * 아니면 에러메시지 출력
	 * */
	public void setMonth(int month) {
		if(month <= 12 && month >= 1)this.month = month;
		else {
			errorMsg("%d월은 없습니다.", month);
		}
	} 
	public int getMonth() {
		return month;
	}
	
	/*
	 * 월에 따라서 날짜가 달라진다.
	 * 1,3,5,7,8,10,12 -> 1~31
	 * 2 - > 1~28
	 * 4,6,9,11 - 1~30
	 * */
	public void setDay(int day) {
		switch (month) {
		case 2: {
			if(day <= 28 && day >= 1) this.day = day;
			else {
				errorMsg("%d월은 28일까지 입니다.", month);
			}
			break;
		}
		case 4: case 6: case 9: case 11: {
			if(day <= 30 && day >= 1) this.day = day;
			else {
				errorMsg("%d월은 30일까지 입니다.", month);
			}
			break;
		}
		
		default:
			if(day <= 31 && day >= 1) this.day = day;
			else {
				errorMsg("%d월은 31일까지 입니다.", month);
			}
		}
		
	}
	public int getDay() {
		return day;
	}
	
	//에러메세지를 출력하는 기능을 추가
	private void errorMsg(String err, int month) {
		System.out.printf(err, month);
		System.exit(0);
	}
}
