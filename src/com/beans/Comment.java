package com.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comment {
	private String	content = "";
	private User	author = null;
	private String	creationDate = "";
	
	public Comment(String c, User u) {
		content = c;
		author = u;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		creationDate = df.format(date);
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public String getCreationDate() {
		return creationDate;
	}
}
