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
	
	private int 	id = 0;
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
	
	public User(int id, String n, Role r, String e, String p) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		this.id = id;
		registrationDate = df.format(date);
		name = n;
		role = r;
		email = e;
		password = p;
	}
	
	public User(int id, String n, String d, String e, Role r, String p) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		this.id = id;
		registrationDate = df.format(date);
		name = n;
		registrationDate = d;
		role = r;
		email = e;
		password = p;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
