package com.pizza.online.serv;

import org.hibernate.SessionFactory;

import com.pizza.online.util.HBFactory;

public class FactoryService {
	protected SessionFactory factory;

	public FactoryService() {
		super();
		this.factory = HBFactory.get();
	}

	public SessionFactory get() {
		return factory;
	}

}
