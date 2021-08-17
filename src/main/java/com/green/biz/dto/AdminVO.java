package com.green.biz.dto;

public class AdminVO {

	private String admin_id;
	private String pwd;
	private String type;
	
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AdminVO [admin_id=" + admin_id + ", pwd=" + pwd + ", type=" + type + "]";
	}
	
	
	
	
	
}
