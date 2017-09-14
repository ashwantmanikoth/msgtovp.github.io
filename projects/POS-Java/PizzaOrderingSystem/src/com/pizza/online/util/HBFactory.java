package com.pizza.online.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HBFactory is class which provied hibernate session factory as static method
 * get() method returns SessionFactory Object, You can use a method as
 * <b>HBFactory.get()</b>
 * 
 * @author vijay
 *
 */
public class HBFactory {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * This method returns sessionFactory as static service
	 * 
	 * @return SessionFactory Object
	 */
	public static SessionFactory get() {
		return sessionFactory;
	}
}
