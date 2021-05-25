package com.todaylunch.main.user;

import java.sql.Date;

public class UserEntity {
	private int iuser;
	private String uid;
	private String upw;
	private String unm;
	private Date regdt;

	public int getIuser() {
		return iuser;
	}

	public void setIuser(int iuser) {
		this.iuser = iuser;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUnm() {
		return unm;
	}

	public void setUnm(String unm) {
		this.unm = unm;
	}

	public Date getRegdt() {
		return regdt;
	}

	public void setRegdt(Date regdt) {
		this.regdt = regdt;
	}
}
