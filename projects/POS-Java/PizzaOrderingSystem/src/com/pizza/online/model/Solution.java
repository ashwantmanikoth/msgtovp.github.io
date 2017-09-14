package com.pizza.online.model;

import org.hibernate.SessionFactory;

import com.pizza.online.serv.FactoryService;

public class Solution {

	public static void main(String[] args) {
		SessionFactory sf = new FactoryService().get();
		System.out.println("Hello");
		sf.close();
	}

}
