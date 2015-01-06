package com.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class User {
	public static enum Role {
		ADMIN,
		USER
	}
	
	private String	name = "";
	private String	registrationDate =  "";
	private String	email = "";
	private Role	role = Role.USER;
	private String	password = "";
	
	public User(String n, Role r, String e, String p) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		registrationDate = df.format(date);
		name = n;
		role = r;
		email = e;
		password = p;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegistrationDate() {
		return registrationDate;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
}
