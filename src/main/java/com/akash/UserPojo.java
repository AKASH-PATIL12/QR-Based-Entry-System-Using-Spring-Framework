package com.akash;

public class UserPojo {
	
	private String name;
	private int phno;
	private String email;
	private String pass;
	
	public UserPojo() {}

	public UserPojo(String name, int phno, String email, String pass) {
		super();
		this.name = name;
		this.phno = phno;
		this.email = email;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
