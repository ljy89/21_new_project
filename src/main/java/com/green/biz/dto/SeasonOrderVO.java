package com.green.biz.dto;

import java.sql.Timestamp;

public class SeasonOrderVO {
    
    private int sedseq;
	private int seseq;
	private int season_order_seq;
	private int price;
	private Timestamp indate;
	private String result;
	private String seasonname;
	private String sid;
	private String sname;
	
	public int getSedseq() {
		return sedseq;
	}
	public void setSedseq(int sedseq) {
		this.sedseq = sedseq;
	}
	public int getSeseq() {
		return seseq;
	}
	public void setSeseq(int seseq) {
		this.seseq = seseq;
	}
	public int getSeason_order_seq() {
		return season_order_seq;
	}
	public void setSeason_order_seq(int season_order_seq) {
		this.season_order_seq = season_order_seq;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	
	@Override
	public String toString() {
		return "SeasonOrderVO [sedseq=" + sedseq + ", seseq=" + seseq + ", season_order_seq=" + season_order_seq
				+ ", price=" + price + ", indate=" + indate + ", result=" + result + ", seasonname=" + seasonname
				+ ", sid=" + sid + ", sname=" + sname + "]";
	}
	
	
	
}
