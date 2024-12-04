package com.DI.SetterInjectForObject;

public class Mobile {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void ring() {
		System.out.println("Phoen is ringing");
	}
}
