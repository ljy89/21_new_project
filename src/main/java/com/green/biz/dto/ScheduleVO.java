package com.green.biz.dto;

public class ScheduleVO {
	private String subject; //과목
	private String assigned_class; //수업시간

	public ScheduleVO(String subject, String assigned_class) {
		this.subject = subject;
		this.assigned_class = assigned_class;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssigned_class() {
		return assigned_class;
	}
	public void setAssigned_class(String assigned_class) {
		this.assigned_class = assigned_class;
	}
	
	@Override
	public String toString() {
		return "ScheduleVo [subject=" + subject + ", assigned_class=" + assigned_class + "]";
	}
}
