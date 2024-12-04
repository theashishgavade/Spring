package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleBean {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Student s = (Student) app.getBean("myStudent");

		s.bunk();

		Person p = (Person) app.getBean("myPerson");

		p.run();
	}
}
