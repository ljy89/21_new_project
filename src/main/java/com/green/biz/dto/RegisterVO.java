package com.green.biz.dto;

public class RegisterVO {

	// s.time
	private int rseq;
	private int sseq;
	private int pseq;
	private String subname;
	private String pname;
	private String result;
	private String time;
	private String completeyn;
	private String sid;
	
	
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCompleteyn() {
		return completeyn;
	}
	public void setCompleteyn(String completeyn) {
		this.completeyn = completeyn;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "RegisterVO [rseq=" + rseq + ", sseq=" + sseq + ", pseq=" + pseq + ", subname=" + subname + ", pname="
				+ pname + ", result=" + result + ", time=" + time + ", completeyn=" + completeyn + ", sid=" + sid + "]";
	}
	
	
	
}
