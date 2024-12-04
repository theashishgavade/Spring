package com.DI.SetterInjectForObject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterForObject {
	public static void main(String[] args) {
		ConfigurableApplicationContext capp = new ClassPathXmlApplicationContext("ObjectSetter.xml");

		Person person = (Person) capp.getBean("myPerson");
		
		
		person.display();
	}
}
