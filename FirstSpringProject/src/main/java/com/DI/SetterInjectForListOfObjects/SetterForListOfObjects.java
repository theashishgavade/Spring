package com.DI.SetterInjectForListOfObjects;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterForListOfObjects {
	public static void main(String[] args) {
		ConfigurableApplicationContext capp = new ClassPathXmlApplicationContext("ListOfObjectSetter.xml");

		Student student = (Student) capp.getBean("myStudent");

		student.display();
	}
}
