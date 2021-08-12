package com.green.biz.dto;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int nseq;
	private String subject;
	private String content;
	private String id;
	private Timestamp indate;
	public int getNseq() {
		return nseq;
	}
	public void setNseq(int nseq) {
		this.nseq = nseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "NoticeVO [nseq=" + nseq + ", subject=" + subject + ", content=" + content + ", id=" + id + ", indate="
				+ indate + "]";
	}
	
	
}
