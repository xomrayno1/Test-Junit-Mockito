package com.demo.entity;

public class Student {
	private String fullName;
	private String username;
	private String password;
	private boolean isEnroled;
	private String transcript;
	
	
	
	
	public Student() {
		super();
	}
	public Student(String fullName, String username, String password, boolean isEnroled, String transcript) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.isEnroled = isEnroled;
		this.transcript = transcript;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnroled() {
		return isEnroled;
	}
	public void setEnroled(boolean isEnroled) {
		this.isEnroled = isEnroled;
	}
	public String getTranscript() {
		return transcript;
	}
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	
}
