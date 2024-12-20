package com.edu.child;

import com.edu.parent.Flyer;

public class Bird implements Flyer {
	/*
	 1step--- void fly();
	 2step--- public void fly() {}
	 */
	@Override
	public void fly() {
		//Bird fly...
		System.out.println("Bird fly...");
	}

	@Override
	public void land() {
		System.out.println("Bird land...");
	}

	@Override
	public void takeOff() {
		System.out.println("Bird takeOff...");
	}
	
	//자식만의 멤버 추가...
	public String layEggs() {
		return "새가 알을 낳다";
	}
	
	public String buildNest() {
		return "둥지를 짓다";
	}
}
