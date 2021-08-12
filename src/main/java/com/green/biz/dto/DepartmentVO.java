package com.green.biz.dto;

public class DepartmentVO {
	
	private int dseq;
	private String name;
	public int getDseq() {
		return dseq;
	}
	public void setDseq(int dseq) {
		this.dseq = dseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DepartmentVO [dseq=" + dseq + ", name=" + name + "]";
	}
	
	
}
