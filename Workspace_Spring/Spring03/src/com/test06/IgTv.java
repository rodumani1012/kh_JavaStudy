package com.test06;

public class IgTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("Ig tv power on!");
	}

	@Override
	public void powerOff() {
		System.out.println("Ig tv power off!");
	}

	@Override
	public void volumeUp() {
		System.out.println("Ig tv volume up!");
	}

	@Override
	public void volumeDown() {
		System.out.println("Ig tv volume down!");
	}

}
