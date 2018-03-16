package com.wavecheng.isbnchecker.entity;

import java.io.Serializable;

public class IsbnQueryResult implements Serializable {

	private String schoolId;
	private String content;
	
	public IsbnQueryResult() {
		// TODO Auto-generated constructor stub
	}
	
	public IsbnQueryResult(String schoolId, String content) {
		this.schoolId = schoolId;
		this.content = content;
	}
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return schoolId + ":" + content;
	}
}
