package com.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class News {
	private String	title = "";
	private String	content = "";
	private String	creationDate = "";
	private User	lastModificationUser = null;
	
	public News(String t, String c, User u) {
		title = t;
		content = c;
		lastModificationUser = u;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		creationDate = df.format(date);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public User getLastModificationUser() {
		return lastModificationUser;
	}
	
	public void setLastModificationUser(User lastModificationUser) {
		this.lastModificationUser = lastModificationUser;
	}
}
