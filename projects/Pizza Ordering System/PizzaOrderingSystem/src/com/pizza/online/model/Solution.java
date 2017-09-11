package com.pizza.online.model;

import com.pizza.online.serv.CredentialService;

public class Solution {

	public static void main(String[] args) {
		new CredentialService().create("msgtovp@gmail.com", "justpass");
	}

}
