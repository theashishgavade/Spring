package com.DI.SetterInjectForListOfObjects;

import java.util.List;

public class Student {
	private String name;
	private int sid;
	private List<Subject> subjects;

	public void display() {
		System.out.println("========Student=========");
		System.out.println(name);
		System.out.println(sid);
		System.out.println("========Subject=========");
		for (Subject sub : subjects) {
			System.out.println(sub.getName());
			System.out.println(sub.getDays());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
