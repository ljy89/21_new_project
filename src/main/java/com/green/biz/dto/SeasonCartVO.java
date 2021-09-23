package com.green.biz.dto;

import java.sql.Timestamp;

public class SeasonCartVO {

	private int secseq;
	private int seseq;
	private int price;
	private String seasonname;
	private String sid;
	private String sname;
	private Timestamp indate;
	private String result;
	
	public int getSecseq() {
		return secseq;
	}
	public void setSecseq(int secseq) {
		this.secseq = secseq;
	}
	public int getSeseq() {
		return seseq;
	}
	public void setSeseq(int seseq) {
		this.seseq = seseq;
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
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "SeasonCart [secseq=" + secseq + ", seseq=" + seseq + ", price=" + price + ", seasonname=" + seasonname
				+ ", sid=" + sid + ", sname=" + sname + ", indate=" + indate + ", result=" + result + "]";
	}
	
	
}
