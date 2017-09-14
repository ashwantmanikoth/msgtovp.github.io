package com.pizza.online.serv;

public enum CredentialStatus {
	NOT_ACTIVATED(""), SUCCESS(""), ERROR(""), NOT_AVAILABLE(""), LOGGED("");
	private String authKey;

	private CredentialStatus(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

}
