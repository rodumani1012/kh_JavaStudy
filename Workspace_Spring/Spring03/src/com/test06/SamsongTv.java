package com.test06;

public class SamsongTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("Samsong tv power on!");
	}

	@Override
	public void powerOff() {
		System.out.println("Samsong tv power off!");
	}

	@Override
	public void volumeUp() {
		System.out.println("Samsong tv volume up!");
	}

	@Override
	public void volumeDown() {
		System.out.println("Samsong tv volume down!!");
	}

}
