package com.green.biz.dto;

public class SubjectVO {

	private int sseq;
	private String subname;
	private String pname;
	private String dname;
	private String time;
	private String content;
	private int dseq;
	private String location;
	private String sid;
	private String pid;
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "SubjectVO [sseq=" + sseq + ", subname=" + subname + ", pname=" + pname + ", dname=" + dname + ", time="
				+ time + ", content=" + content + ", dseq=" + dseq + ", location=" + location + ", sid=" + sid
				+ ", pid=" + pid + "]";
	}
	
	

}
