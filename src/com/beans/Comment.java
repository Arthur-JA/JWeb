package com.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comment {
	private int 	id = 0;
	private String	content = "";
	private User	author = null;
	private String	creationDate = "";
	private int 	idProduct = 0;
	
	public Comment(String c, User u) {
		content = c;
		author = u;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		creationDate = df.format(date);
	}

	public Comment(int id, String c, User u, String date, int idProduct) {
		this.id = id;
		content = c;
		author = u;
		creationDate = date;
		this.idProduct = idProduct;
	}
	
	public Comment(int id, String c, User u, int idProduct) {
		this.id = id;
		content = c;
		author = u;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = Calendar.getInstance().getTime();
		creationDate = df.format(date);
		this.idProduct = idProduct;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
}
