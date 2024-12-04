package com.ty.DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Using Constructor injection
@Component
public class StudentDIVariable {
	@Value(value = "Ashish")
	String name;
	@Value(value = "24")
	int age;

	public void Display() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}

}
