package com.DI.ConstructorInjectValue;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisplayStudent {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("ConstructorForVal.xml");

		Student student = (Student) cApp.getBean("myStudent");
		
		student.display();
	}
}
