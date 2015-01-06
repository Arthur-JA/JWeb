package com.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.beans.User;
import com.beans.User.Role;

public class DAOUser {
	
	public static List<User> getUserList() {
		Statement stmt;
		List<User> userList = new ArrayList<User>();
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM USER;";
		java.sql.ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(Database.USER_ID);
				String name = rs.getString(Database.USER_NAME);
				String date = rs.getString(Database.USER_DATE);
				String email = rs.getString(Database.USER_EMAIL);
				Role role = Role.values()[rs.getInt(Database.USER_ROLE)];
				String passwd = rs.getString(Database.USER_PASSWD);
				userList.add(new User(id, name, date, email, role, passwd));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		Database.getInstance().closeConnection();
		return userList;
	}
	
	public static void addUser(User u) {
		Statement stmt;
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return;
		String sql = "INSERT INTO USER VALUES(" + u.getId()+ ", '" + u.getName() + "', '" + u.getPassword() + "', '" + u.getEmail() + "', " + u.getRole().ordinal() + ", '" + u.getRegistrationDate() + "');";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Database.getInstance().closeConnection();
	}
	
	public static User getUser(int userId) {
		Statement stmt;
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM USER WHERE " + Database.USER_ID + " = " + userId + ";";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt(Database.USER_ID);
				String n = rs.getString(Database.USER_NAME);
				String date = rs.getString(Database.USER_DATE);
				String email = rs.getString(Database.USER_EMAIL);
				Role role = Role.values()[rs.getInt(Database.USER_ROLE)];
				String passwd = rs.getString(Database.USER_PASSWD);
				Database.getInstance().closeConnection();
				return new User(id, n, date, email, role, passwd);
			} else {
				Database.getInstance().closeConnection();
				return null;
			}
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return null;
		}
	}
	
	public static User getUser(String name, String password) {
		Statement stmt;
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM USER WHERE " + Database.USER_NAME + " = '" + name + "' AND " + Database.USER_PASSWD + " = '" + password + "';";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt(Database.USER_ID);
				String n = rs.getString(Database.USER_NAME);
				String date = rs.getString(Database.USER_DATE);
				String email = rs.getString(Database.USER_EMAIL);
				Role role = Role.values()[rs.getInt(Database.USER_ROLE)];
				String passwd = rs.getString(Database.USER_PASSWD);
				Database.getInstance().closeConnection();
				return new User(id, n, date, email, role, passwd);
			} else {
				Database.getInstance().closeConnection();
				return null;
			}
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return null;
		}
	}
}
