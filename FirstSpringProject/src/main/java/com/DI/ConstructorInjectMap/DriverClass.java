package com.DI.ConstructorInjectMap;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverClass {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("ConstructorForMap.xml");
		Shop shop = (Shop) cApp.getBean("myShop");
		shop.display();
	}
}
