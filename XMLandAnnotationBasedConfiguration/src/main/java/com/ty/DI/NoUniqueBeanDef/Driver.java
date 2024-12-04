package com.ty.DI.NoUniqueBeanDef;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new AnnotationConfigApplicationContext(AppConfig.class);
		Industry industry = (Industry) cApp.getBean("industry");
		industry.budget();
	}
}
