package com.green.biz.dto;

import java.sql.Timestamp;

public class QnaVO {

	private int qseq;
	private String subject;
	private String content;
	private String reply;
	private String sid;
	private String admin_id;
	private String rep;
	private Timestamp indate;
	public int getQseq() {
		return qseq;
	}
	public void setQseq(int qseq) {
		this.qseq = qseq;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "QnaVO [qseq=" + qseq + ", subject=" + subject + ", content=" + content + ", reply=" + reply + ", sid="
				+ sid + ", admin_id=" + admin_id + ", rep=" + rep + ", indate=" + indate + "]";
	}
	
	
	
	
}
