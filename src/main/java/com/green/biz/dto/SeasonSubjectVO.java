package com.green.biz.dto;

public class SeasonSubjectVO {

	private int seseq;
	private int dseq;
	private int price;
	private String seasonname;
	private String pname;
	private String dname;
	private String time;
	private String content;
	private String location;
	private String sid;
	private String pid;
	
	public int getSeseq() {
		return seseq;
	}
	public void setSeseq(int seseq) {
		this.seseq = seseq;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSeasonname() {
		return seasonname;
	}
	public void setSeasonname(String seasonname) {
		this.seasonname = seasonname;
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
		return "SeasonSubjectVO [seseq=" + seseq + ", dseq=" + dseq + ", price=" + price + ", seasonname=" + seasonname
				+ ", pname=" + pname + ", dname=" + dname + ", time=" + time + ", content=" + content + ", location="
				+ location + ", sid=" + sid + ", pid=" + pid + "]";
	}
	
	
}
