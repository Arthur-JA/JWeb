package com.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.beans.News;
import com.beans.User;

public class DAONew {

	public static List<News> getNewsList() {
			Statement stmt;
			List<News> newsList = new ArrayList<News>();
			
			if ((stmt = Database.getInstance().getStatement()) == null)
				return null;
			String sql = "SELECT * FROM NEW;";
			java.sql.ResultSet rs;
			try {
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt(Database.NEW_ID);
					String title = rs.getString(Database.NEW_TITLE);
					String content = rs.getString(Database.NEW_CONTENT);
					String date = rs.getString(Database.NEW_DATE);
					int idUser = rs.getInt(Database.NEW_USER);
					User user = DAOUser.getUser(idUser);
					newsList.add(new News(id, title, content, date, user));
				}
			} catch (SQLException e) {
				Database.getInstance().closeConnection();
				e.printStackTrace();
				return null;
			}
			Database.getInstance().closeConnection();
			return newsList;
		}
		
		public static void addNews(News n) {
			Statement stmt;
			
			System.out.println("ADD NEWS");
			if ((stmt = Database.getInstance().getStatement()) == null)
				return;
			String sql = "INSERT INTO NEW VALUES(" + n.getId()+ ", '" + n.getTitle() + "', '" + n.getContent() + "', '" + n.getCreationDate() + "', " + n.getLastModificationUser().getId() + ");";
			try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				Database.getInstance().closeConnection();
				e.printStackTrace();
			}
			System.out.println("News add id= " + n.getId());
			Database.getInstance().closeConnection();
		}
}
