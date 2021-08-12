package com.green.biz.dto;

public class ProfessorVO {
	
	private String id;
	private int sseq;
	private String name;
	private String phone;
	private String pwd;
	private String image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "ProfessorVO [id=" + id + ", sseq=" + sseq + ", name=" + name + ", phone=" + phone + ", pwd=" + pwd
				+ ", image=" + image + "]";
	}
	
	
}
