package com.pizza.online.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "pos_user_profile", catalog = "posdb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "mobile_no", name = "pos_user_profile_mobile_unq") })
@TableGenerator(name = "prof_tab_gen", allocationSize = 1, initialValue = 100, catalog = "posdb", table = "pos_table_gen", pkColumnName = "name", valueColumnName = "value", pkColumnValue = "prof_id")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 976295143483042584L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private Address address;
	private UserCredential credential;

	@Id
	@Column(name = "prof_id")
	@GeneratedValue(generator = "prof_tab_gen", strategy = GenerationType.TABLE)
	public Integer getId() {
		return id;
	}

	@Column(name = "first_name", nullable = false, length = 100)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "last_name", nullable = false, length = 100)
	public String getLastName() {
		return lastName;
	}

	@Column(name = "mobile_no", nullable = false, length = 50)
	public String getMobileNo() {
		return mobileNo;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public UserCredential getCredential() {
		return credential;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCredential(UserCredential credential) {
		this.credential = credential;
	}

}
