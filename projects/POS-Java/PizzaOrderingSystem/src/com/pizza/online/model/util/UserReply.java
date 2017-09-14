package com.pizza.online.model.util;

import com.pizza.online.model.UserCredential;

public class UserReply {
	private boolean status;
	private UserCredential credential;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserCredential getCredential() {
		return credential;
	}

	public void setCredential(UserCredential credential) {
		this.credential = credential;
	}

}
