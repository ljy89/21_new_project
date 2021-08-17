package com.green.biz.dto;

public class ProfessorVO {
	
	private String pid;
	private String pwd;
	private String type;
	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
		return "ProfessorVO [pid=" + pid + ", pwd=" + pwd + ", type=" + type + "]";
	}
	
	
}
