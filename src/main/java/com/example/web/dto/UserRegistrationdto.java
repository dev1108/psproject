package com.example.web.dto;

public class UserRegistrationdto {
	private String firstname;
	private String lasttname;
	private String email;
	private String password;
	public UserRegistrationdto(String firstname, String lasttname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lasttname = lasttname;
		this.email = email;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lasttname;
	}
	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRegistrationdto() {
		super();
	}
	

}
