package com.ty.DI.ForObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Value(value = "BMW")
	String name;

//	Using Value /Field Injection
//	@Autowired
	Engine engine;

//	Using Setter Injection
//	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

//	Using Setter Injection
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
	}

	public void Display() {
		System.out.println("Name: " + name);
		System.out.println("CC: " + engine.cc);
	}
}
