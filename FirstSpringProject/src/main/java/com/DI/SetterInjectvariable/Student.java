package com.DI.SetterInjectvariable;

public class Student {
	private int sId;
	private String name;

	public Student() {
		System.out.println("Student Object Has Been Created");
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
