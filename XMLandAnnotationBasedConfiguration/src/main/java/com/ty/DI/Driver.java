package com.ty.DI;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new ClassPathXmlApplicationContext("configDI.xml");

		StudentDISetter studentDiSetter = (StudentDISetter) cApp.getBean("studentDISetter");
		System.out.println("Name : " + studentDiSetter.getName());
		System.out.println("Name : " + studentDiSetter.getAge());

		System.out.println("==================================");

		StudentDIConstructor studentDIConstructor = (StudentDIConstructor) cApp.getBean("studentDIConstructor");
		studentDIConstructor.Display();
		System.out.println("==================================");

		StudentDIVariable studentDIVariable = (StudentDIVariable) cApp.getBean("studentDIVariable");
		studentDIVariable.Display();

	}
}
