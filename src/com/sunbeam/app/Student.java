package com.sunbeam.app;

public class Student {
	private String name, pass,email,country;
	 
	public Student() {
		
	}

	public Student(String name, String pass, String email, String country) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", pass=" + pass + ", email=" + email + ", country=" + country + "]";
	}
	
	

}
