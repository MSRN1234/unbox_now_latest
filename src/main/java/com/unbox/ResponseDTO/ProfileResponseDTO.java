package com.unbox.ResponseDTO;

public class ProfileResponseDTO {

	private Integer user_profile_id;
	private String full_name;
    private String message;
    
    
	public Integer getUser_profile_id() {
		return user_profile_id;
	}
	public void setUser_profile_id(Integer user_profile_id) {
		this.user_profile_id = user_profile_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
