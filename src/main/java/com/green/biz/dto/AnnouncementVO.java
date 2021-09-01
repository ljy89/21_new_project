package com.green.biz.dto;

import java.sql.Timestamp;

public class AnnouncementVO {
	
	private int aseq;
	private String subject;
	private String content;
	private Timestamp indate;
	private String admin_id;
	
	public int getAseq() {
		return aseq;
	}
	public void setAseq(int aseq) {
		this.aseq = aseq;
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
		return "AnnouncementVO [aseq=" + aseq + ", subject=" + subject + ", content=" + content + ", indate=" + indate
				+ ", admin_id=" + admin_id + "]";
	}
	
	
}
