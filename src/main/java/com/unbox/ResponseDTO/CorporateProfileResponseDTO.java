package com.unbox.ResponseDTO;

public class CorporateProfileResponseDTO {

	private Integer corporate_id;
	private String business_name;
    private String message;
    private Integer user_Id;
	public Integer getCorporate_id() {
		return corporate_id;
	}
	public void setCorporate_id(Integer corporate_id) {
		this.corporate_id = corporate_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
    
}
