package com.DI.ConstructorInjectValue;

import java.util.jar.Attributes.Name;

public class Student {
	String name;
	String mail;
	int age;

	public Student(String name, String mail, int age) {
		super();
		this.name = name;
		this.mail = mail;
		this.age = age;
	}

	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Mail : " + mail);
		System.out.println("Phone : " + age);
	}

}
