package com.unbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubn_corporate_profile")
public class CorporateProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer corporate_id;
	private Integer user_Id;
	private String business_name;
	private String website;
	private String point_of_contact;
	private String business_email;
	private String mobile_no;
//	private Integer enter_the_otp;
	private String gst_no;
	private String pan_no;
	public Integer getCorporate_id() {
		return corporate_id;
	}
	public void setCorporate_id(Integer corporate_id) {
		this.corporate_id = corporate_id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPoint_of_contact() {
		return point_of_contact;
	}
	public void setPoint_of_contact(String point_of_contact) {
		this.point_of_contact = point_of_contact;
	}
	public String getBusiness_email() {
		return business_email;
	}
	public void setBusiness_email(String business_email) {
		this.business_email = business_email;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	
}
