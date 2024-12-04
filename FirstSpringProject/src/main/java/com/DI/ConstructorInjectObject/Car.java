package com.DI.ConstructorInjectObject;

public class Car {
	String brand;
	String colour;

	Engine engine;

	public Car(String brand, String colour, Engine engine) {
		super();
		this.brand = brand;
		this.colour = colour;
		this.engine = engine;
	}

	public void display() {
		System.out.println("Brand : " + brand);
		System.out.println("Colour : " + colour);
		System.out.println("===========");
		System.out.println("CC : " + engine.cc);
	}

}
