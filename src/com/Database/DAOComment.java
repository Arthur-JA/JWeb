package com.Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Comment;
import com.beans.User;

public class DAOComment {
	
	public static List<Comment> getCommentsListForProduct(int productId) {
		Statement stmt;
		List<Comment> commentsList = new ArrayList<Comment>();
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM COMMENT WHERE " + Database.COMMENT_PRODUCT + " = " + productId +";";
		java.sql.ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(Database.COMMENT_ID);
				String content = rs.getString(Database.COMMENT_CONTENT);
				String date = rs.getString(Database.COMMENT_DATE);
				int idUser = rs.getInt(Database.COMMENT_AUTHOR);
				int idProduct = rs.getInt(Database.COMMENT_PRODUCT);
				User user = DAOUser.getUser(idUser);
				commentsList.add(new Comment(id, content, user, date, idProduct));
			}
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return null;
		}
		Database.getInstance().closeConnection();
		return commentsList;
	}
	
	public static void addComment(Comment c) {
		Statement stmt;

		if ((stmt = Database.getInstance().getStatement()) == null) {
			return;
		}
		String sql = "INSERT INTO COMMENT VALUES(" + c.getId()+ ", '" + c.getContent() + "', '" + c.getCreationDate() + "', " + c.getAuthor().getId() + ", " + c.getIdProduct() + ");";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return;
		}
		Database.getInstance().closeConnection();
	}
	
	public static void addCommentList(List<Comment> list) {
		for (Comment c : list) {
			addComment(c);
		}
		Database.getInstance().closeConnection();
	}
}
