package com.pizza.online.util;

import java.security.SecureRandom;

public class Utility {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();

	public static String generateKey(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
