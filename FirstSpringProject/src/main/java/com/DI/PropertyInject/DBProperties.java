package com.DI.PropertyInject;

public class DBProperties {
	String url;

	String username;

	String password;

	public DBProperties(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public void display() {
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
}
