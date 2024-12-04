package com.InitDestroy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("InitDestroy.xml");
		Person person = (Person) cApp.getBean("myPerson");
		cApp.close();
	}
}
