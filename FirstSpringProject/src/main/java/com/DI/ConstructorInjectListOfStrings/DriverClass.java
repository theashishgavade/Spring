package com.DI.ConstructorInjectListOfStrings;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("ConstructorForStrings.xml");
		Student student = (Student) cApp.getBean("myStudent");
		student.display();
	}
}
