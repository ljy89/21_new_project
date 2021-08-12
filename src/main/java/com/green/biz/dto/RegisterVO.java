package com.green.biz.dto;

public class RegisterVO {

	private int rseq;
	private int sseq;
	private String id;
	private String completeyn;
	private int score;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompleteyn() {
		return completeyn;
	}
	public void setCompleteyn(String completeyn) {
		this.completeyn = completeyn;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "RegisterVO [rseq=" + rseq + ", sseq=" + sseq + ", id=" + id + ", completeyn=" + completeyn + ", score="
				+ score + "]";
	}
	
	
}
