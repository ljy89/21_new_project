package com.green.biz.dto;

public class ScoreVO {
	
	private int rseq;
	private int dseq;
	private int sseq;
	private int rdseq;
	private String sid;
	private String sname;
	private String dname;
	private String pname;
	private String subname;
	private int score;
	private String completeyn;
	private String time;
	
	
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getRdseq() {
		return rdseq;
	}
	public void setRdseq(int rdseq) {
		this.rdseq = rdseq;
	}
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCompleteyn() {
		return completeyn;
	}
	public void setCompleteyn(String completeyn) {
		this.completeyn = completeyn;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	@Override
	public String toString() {
		return "ScoreVO [rseq=" + rseq + ", dseq=" + dseq + ", sseq=" + sseq + ", rdseq=" + rdseq + ", sid=" + sid
				+ ", sname=" + sname + ", dname=" + dname + ", pname=" + pname + ", subname=" + subname + ", score="
				+ score + ", completeyn=" + completeyn + ", time=" + time + "]";
	}
	
	
	
}
