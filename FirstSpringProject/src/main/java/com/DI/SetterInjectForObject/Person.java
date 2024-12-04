package com.DI.SetterInjectForObject;

public class Person {
	private String name;
	private Mobile mobile;

	public Person() {
		System.out.println("Person Object is created");
	}

	public void display() {
		System.out.println(name + " is using phone.");
		mobile.getBrand();
		mobile.ring();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

}
