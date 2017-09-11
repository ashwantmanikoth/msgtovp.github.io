package com.pizza.online.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@SuppressWarnings("deprecation")
@Entity
@org.hibernate.annotations.Entity(dynamicUpdate = true)
@Table(name = "pos_user_credential", catalog = "posdb")
public class UserCredential implements Serializable {

	private static final long serialVersionUID = 7496270742065252760L;

	private String emailId;
	private String password;
	private String authKey;
	private Boolean activated;
	private UserProfile profile;

	@Id
	@Column(name = "email_id", nullable = false)
	public String getEmailId() {
		return emailId;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "auth_key", length = 30)
	public String getAuthKey() {
		return authKey;
	}

	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "status", nullable = false)
	public Boolean getActivated() {
		return activated;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "credential")
	public UserProfile getProfile() {
		return profile;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

}
