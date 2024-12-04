package com.ty;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UsingCore {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("config.xml");

		BeanFactory bf = new XmlBeanFactory(r);

		Student s = (Student) bf.getBean("myStudent");

		s.bunk();
	}
}
