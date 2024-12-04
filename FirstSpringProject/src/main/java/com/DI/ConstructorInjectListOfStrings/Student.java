package com.DI.ConstructorInjectListOfStrings;

import java.util.List;

public class Student {
	int id;
	String name;
	List<String> subjects;

	public Student(int id, String name, List<String> subjects) {
		this.id = id;
		this.name = name;
		this.subjects = subjects;
	}

	public void display() {
		System.out.println("====== Student ======");
		System.out.println(id);
		System.out.println(name);

		System.out.println("====== Subjects ======");
		for (String sub : subjects) {
			System.out.println(sub);
		}
	}
}
