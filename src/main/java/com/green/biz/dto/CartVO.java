package com.green.biz.dto;

public class CartVO {

	private int cseq;
	private int sseq;
	private String id;
	private String result;
	private int resq;
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public int getSseq() {
		return sseq;
	}
	public void setSseq(int sseq) {
		this.sseq = sseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getResq() {
		return resq;
	}
	public void setResq(int resq) {
		this.resq = resq;
	}
	@Override
	public String toString() {
		return "CartVO [cseq=" + cseq + ", sseq=" + sseq + ", id=" + id + ", result=" + result + ", resq=" + resq + "]";
	}
	
	
}
