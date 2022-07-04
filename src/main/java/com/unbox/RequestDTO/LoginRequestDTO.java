package com.unbox.RequestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequestDTO {

	private Integer user_id;
	private String user_name;
	private Integer user_type_id;
	private boolean validated;
	@NotBlank
	@Size(min = 4, message = "Password must be 4 characters")
	private String password;
	@NotNull
	private String signupWith;

	

	public String getSignupWith() {
		return signupWith;
	}

	public void setSignupWith(String signupWith) {
		this.signupWith = signupWith;
	}

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
