package com.example.webService.RestFullService.UserInfo;

import java.util.Date;

public class Subject {

	private int id;
	private String subjectName;
	private String subjectMasterName;
	private Date subjectTime;
	private String subjectMarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectMasterName() {
		return subjectMasterName;
	}

	public void setSubjectMasterName(String subjectMasterName) {
		this.subjectMasterName = subjectMasterName;
	}

	public Date getSubjectTime() {
		return subjectTime;
	}

	public void setSubjectTime(Date subjectTime) {
		this.subjectTime = subjectTime;
	}

	public String getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(String subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	public Subject(int id, String subjectName, String subjectMasterName,
			Date subjectTime, String subjectMarks) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.subjectMasterName = subjectMasterName;
		this.subjectTime = subjectTime;
		this.subjectMarks = subjectMarks;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName
				+ ", subjectMasterName=" + subjectMasterName + ", subjectTime="
				+ subjectTime + ", subjectMarks=" + subjectMarks + "]";
	}

}
