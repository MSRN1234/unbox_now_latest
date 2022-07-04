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
    private  String gender;
    private String address_Line_1;
    private String address_Line_2;
    private String city;
    private String state;
    private String country;
    private Integer zipCode;
    private String email;
    private String mobile_No;
    private String alternate_Mobile_No;
	public Integer getUser_profile_id() {
		return user_profile_id;
	}
	public void setUser_profile_id(Integer user_profile_id) {
		this.user_profile_id = user_profile_id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}
	public String getAlternate_Mobile_No() {
		return alternate_Mobile_No;
	}
	public void setAlternate_Mobile_No(String alternate_Mobile_No) {
		this.alternate_Mobile_No = alternate_Mobile_No;
	}
    

}