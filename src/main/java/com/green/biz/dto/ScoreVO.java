package com.green.biz.dto;

public class ScoreVO {
	
	private String sid;
	private String sname;
	private int dseq;
	private String dname;
	private int sseq;
	private String subname;
	private int rseq;
	private String score;
	private String completeyn;
	
	
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
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCompleteyn() {
		return completeyn;
	}
	public void setCompleteyn(String completeyn) {
		this.completeyn = completeyn;
	}
	@Override
	public String toString() {
		return "ScoreVO [sid=" + sid + ", sname=" + sname + ", dseq=" + dseq + ", dname=" + dname + ", sseq=" + sseq
				+ ", subname=" + subname + ", rseq=" + rseq + ", score=" + score + ", completeyn=" + completeyn + "]";
	}
	
	
}
