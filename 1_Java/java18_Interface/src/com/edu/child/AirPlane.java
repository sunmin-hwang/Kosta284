package com.edu.child;

import com.edu.parent.Flyer;

public class AirPlane implements Flyer {
	@Override
	public void fly() {
		//AirPlane fly...
		System.out.println("AirPlane fly...");
	}

	@Override
	public void land() {
		System.out.println("AirPlane land...");
	}

	@Override
	public void takeOff() {
		System.out.println("AirPlane takeOff...");
	}
	
}
