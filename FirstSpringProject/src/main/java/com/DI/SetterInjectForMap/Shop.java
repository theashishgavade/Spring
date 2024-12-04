package com.DI.SetterInjectForMap;

import java.util.Map;

public class Shop {

	private String name;

	private Map<String, Double> items;

	public void display() {
		System.out.println("Welcome to " + name + "Shop!");
		System.out.println("**********ITEMS************");
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}
	}

	public Map<String, Double> getItems() {
		return items;
	}

	public void setItems(Map<String, Double> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
