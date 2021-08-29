package com.green.biz.dto;

public class StudentVO {
	
	private String sid;
	private String sname;
	private String email;
	private int dseq;
	private String phone;
	private String dname;
	private String pwd;
	private String type;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
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
		return "StudentVO [sid=" + sid + ", sname=" + sname + ", email=" + email + ", dseq=" + dseq + ", phone=" + phone
				+ ", dname=" + dname + ", pwd=" + pwd + ", type=" + type + "]";
	}
	

	
	
}
