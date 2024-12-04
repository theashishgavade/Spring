package com.DI.PropertyInject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("DBConfig.xml");

		DBProperties dbProperties = (DBProperties) cApp.getBean("myDB");

		dbProperties.display();
	}
}
