package com.ty.XMLandAnnotationConfig;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("config.xml");
		RCB rcb = (RCB) cApp.getBean("RCB");
		rcb.play();

		PersonApp person = (PersonApp) cApp.getBean("personApp");
		person.dance();

		Student student = (Student) cApp.getBean("student");
		student.play();
	}
}
