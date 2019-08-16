package com.test07;

import org.springframework.stereotype.Component;

@Component
public class IgTv implements TV {

	public IgTv() {
		System.out.println("Ig tv 생성!!!");
	}
	
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
