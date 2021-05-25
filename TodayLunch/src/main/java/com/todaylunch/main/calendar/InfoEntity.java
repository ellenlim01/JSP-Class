package com.todaylunch.main.calendar;

import java.sql.Date;

public class InfoEntity {
	private int idetail;
	private Date regdate;
	private String place;
	private String address;
	private String picture;
	private int iuser;
	
	public int getIdetail() {
		return idetail;
	}
	public void setIdetail(int idetail) {
		this.idetail = idetail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
}
