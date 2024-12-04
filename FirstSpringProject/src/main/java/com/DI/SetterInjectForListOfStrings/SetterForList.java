package com.DI.SetterInjectForListOfStrings;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterForList {
	public static void main(String[] args) {
		ConfigurableApplicationContext capp = new ClassPathXmlApplicationContext("ListSetter.xml");

		Student student = (Student) capp.getBean("myStudent");

		student.display();
	}
}
