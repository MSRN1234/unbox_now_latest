package com.unbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubn_user_profile")
public class Profile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer user_profile_id;
    private Integer user_Id;
    private String name;
    private String email;
    private String mobile_no;
    private String address_Line_1;
    private String address_Line_2;
    private String city;
    private String state;
    private Integer zipCode;
	public Integer getUser_profile_id() {
		return user_profile_id;
	}
	public void setUser_profile_id(Integer user_profile_id) {
		this.user_profile_id = user_profile_id;
	}
	public Integer getUser_id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_id) {
		this.user_Id = user_id;
	}
	public String getFull_name() {
		return name;
	}
	public void setFull_name(String full_name) {
		this.name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress_Line_1() {
		return address_Line_1;
	}
	public void setAddress_Line_1(String address_Line_1) {
		this.address_Line_1 = address_Line_1;
	}
	public String getAddress_Line_2() {
		return address_Line_2;
	}
	public void setAddress_Line_2(String address_Line_2) {
		this.address_Line_2 = address_Line_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
    
   

}