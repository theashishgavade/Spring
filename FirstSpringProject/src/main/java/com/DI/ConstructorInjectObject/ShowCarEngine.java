package com.DI.ConstructorInjectObject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShowCarEngine {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("ConstructorForObj.xml");
		Car car = (Car) cApp.getBean("myCar");

		car.display();
	}
}
