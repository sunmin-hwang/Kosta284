package com.edu.dice.impl;

import java.util.Random;

import com.edu.dice.Dice;

public class DiceDImpl implements Dice {
	private int value;
	
	public DiceDImpl() {
		System.out.println("::"+getClass().getName()+" 기본 생성자...");
	}
	
	public DiceDImpl(int value) {
		System.out.println("::"+getClass().getName()+" 명시적 생성자...");
		this.value = value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}
	
	@Override
	public int getValue() {
		return value;
	}

}
