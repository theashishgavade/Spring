package com.DI.ConstructorInjectMap;

import java.util.Map;

public class Shop {

	String name;
	Map<String, Double> items;

	public Shop() {
	}

	public Shop(String name, Map<String, Double> items) {
		this.name = name;
		this.items = items;
	}

	public void display() {
		System.out.println("Welcome to " + name + " Shop!");
		System.out.println("*********** ITEMS ***********");
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
	}
}
