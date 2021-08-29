package com.green.biz.dto;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int nseq;
	private String subject;
	private String content;
	private String sid;
	private Timestamp indate;
	private String admin_id;
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
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	@Override
	public String toString() {
		return "NoticeVO [nseq=" + nseq + ", subject=" + subject + ", content=" + content + ", sid=" + sid + ", indate="
				+ indate + ", admin_id=" + admin_id + "]";
	}
	
	
	
	
}
