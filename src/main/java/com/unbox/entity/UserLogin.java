package com.unbox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ubn_user_login")
public class UserLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="user_name")
	@NotBlank
	@Email(message="user_name must be in proper email format")
	private String user_name;
	@Column(name="user_type_id")
	@NotNull
	private Integer user_type_id;
	@Column(name="validated")
	private boolean validated;
	@Column(name="password")
	@NotBlank
	@Size(min = 4, message = "Password must be 4 characters")
	private String password;
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_type_id() {
		return user_type_id;
	}
	public void setUser_type_id(Integer user_type_id) {
		this.user_type_id = user_type_id;
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
