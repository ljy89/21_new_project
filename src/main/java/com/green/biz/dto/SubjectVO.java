package com.green.biz.dto;

public class SubjectVO {

	private int sseq;
	private String name;
	private String id;
	private String time;
	private String majoryn;
	private String content;
	private int dseq;
	private String location;
	private int number;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMajoryn() {
		return majoryn;
	}
	public void setMajoryn(String majoryn) {
		this.majoryn = majoryn;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "SubjectVO [sseq=" + sseq + ", name=" + name + ", id=" + id + ", time=" + time + ", majoryn=" + majoryn
				+ ", dseq=" + dseq + ", location=" + location + ", number=" + number + "]";
	}
	
	
}
