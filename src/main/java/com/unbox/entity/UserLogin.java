package com.unbox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubn_user_login")
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	@Column(name="userName")
	private String name;
	@Column(name="userTypeId")
    private long userTypeId;
	@Column(name="validated")
    private boolean validated;
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
