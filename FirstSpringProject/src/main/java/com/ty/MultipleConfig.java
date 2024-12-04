package com.ty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleConfig {
	public static void main(String[] args) {
		// For First config where 2 objects are set
		ApplicationContext app = new ClassPathXmlApplicationContext("config.xml");

		Student s = (Student) app.getBean("myStudent");

		s.bunk(); //Failed in exam

		Person p = (Person) app.getBean("myPerson");

		p.run(); //person running

		// For Second config where 2 objects are set
		ApplicationContext app1 = new ClassPathXmlApplicationContext("config1.xml");

		Student s1 = (Student) app1.getBean("myStudent");

		s.bunk(); //Failed in exam

		Person p1 = (Person) app1.getBean("myPerson");

		p.run();// Exception NoSuchBeanDefinitionException

	}
}
