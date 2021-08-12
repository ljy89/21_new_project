package com.green.biz.dto;

public class AdminVO {

	private String id;
	private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", pwd=" + pwd + "]";
	}
	
	
}
