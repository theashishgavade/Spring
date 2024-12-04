package com.DI.SetterInjectForMap;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopDetails {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("SetterForMap.xml");

		Shop shop = (Shop) cApp.getBean("myShop");

		shop.display();
	}
}
