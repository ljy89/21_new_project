package com.green.biz.dto;

import java.sql.Timestamp;

public class CartVO {
	
	private int cseq;
	private int dseq;
	private int pseq;
	private String dname;
	private String pname;
	private String time;
	private int sseq;
	private String subname;
	private String sid; 
	private int rseq;
	private String result;
	private Timestamp indate;
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getRseq() {
		return rseq;
	}
	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "CartVO [cseq=" + cseq + ", dseq=" + dseq + ", pseq=" + pseq + ", dname=" + dname + ", pname=" + pname
				+ ", time=" + time + ", sseq=" + sseq + ", subname=" + subname + ", sid=" + sid + ", rseq=" + rseq
				+ ", result=" + result + ", indate=" + indate + "]";
	}
	
	
}
