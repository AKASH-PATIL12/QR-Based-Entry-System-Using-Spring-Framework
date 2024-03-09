package com.akash;

public class LoginPojo {
	private int phno;
	private String pass;
	
	public LoginPojo() {}

	public LoginPojo(int phno, String pass) {
		super();
		this.phno = phno;
		this.pass = pass;
	}

	public int getPhno() {
		return phno;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
