package com.DI.SetterInjectvariable;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext capp = new ClassPathXmlApplicationContext("VariableSetter.xml");

		Student student = (Student) capp.getBean("myStudent");

		System.out.println("---------Student----------");
		System.out.println(student.getsId());
		System.out.println(student.getName());
	}
}
