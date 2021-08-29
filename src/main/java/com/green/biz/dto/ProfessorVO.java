package com.green.biz.dto;

public class ProfessorVO {
	//  s.content, s.location, s.majoryn
	private String pid;
	private String pname;
	private String dname;
	private String pwd;
	private String subname;
	private String time;
	private String content;
	private String location;
	private String majoryn;
	private int sseq;
	private int dseq;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMajoryn() {
		return majoryn;
	}
	public void setMajoryn(String majoryn) {
		this.majoryn = majoryn;
	}
	@Override
	public String toString() {
		return "ProfessorVO [pid=" + pid + ", pname=" + pname + ", dname=" + dname + ", pwd=" + pwd + ", subname="
				+ subname + ", time=" + time + ", content=" + content + ", location=" + location + ", majoryn="
				+ majoryn + ", sseq=" + sseq + ", dseq=" + dseq + "]";
	}
	
	
	
}
