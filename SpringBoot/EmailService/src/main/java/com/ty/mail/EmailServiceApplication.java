package com.ty.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ty.mail.service.EmailService;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(EmailServiceApplication.class, args);
		EmailService bean = run.getBean(EmailService.class);
		String to = "ashugavade67@gmail.com";
		String subject="Your email is registered in IT app";
		String body = "This is email confirmation for registering into the IT app";
		bean.send(to, subject, body);
		System.out.println("sent");
	}

}
