package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsingJ2EE {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Student s = (Student) app.getBean("myStudent");

		s.bunk();
	}
}
