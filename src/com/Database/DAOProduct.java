package com.Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Comment;
import com.beans.Product;

public class DAOProduct {
	public static List<Product> getProductList() {
		Statement stmt;
		List<Product> productsList = new ArrayList<Product>();
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM PRODUCT;";
		java.sql.ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(Database.PRODUCT_ID);
				String name = rs.getString(Database.PRODUCT_NAME);
				float price = rs.getFloat(Database.PRODUCT_PRICE);
				String desc = rs.getString(Database.PRODUCT_DESC);
				productsList.add(new Product(id, name, price, desc, DAOComment.getCommentsListForProduct(id)));
			}
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return null;
		}
		Database.getInstance().closeConnection();
		return productsList;
	}
	
	public static Product getProduct(int id) {
		Statement stmt;
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return null;
		String sql = "SELECT * FROM PRODUCT WHERE " + Database.PRODUCT_ID + " = " + id  +";";
		java.sql.ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int productid = rs.getInt(Database.PRODUCT_ID);
				String name = rs.getString(Database.PRODUCT_NAME);
				float price = rs.getFloat(Database.PRODUCT_PRICE);
				String desc = rs.getString(Database.PRODUCT_DESC);
				List<Comment> commentsList = DAOComment.getCommentsListForProduct(id);
				Database.getInstance().closeConnection();
				return new Product(productid, name, price, desc, commentsList);
			}
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
			return null;
		}
		Database.getInstance().closeConnection();
		return null;
	}
	
	public static void addProduct(Product p) {
		Statement stmt;
		
		if ((stmt = Database.getInstance().getStatement()) == null)
			return;
		String sql = "INSERT INTO PRODUCT VALUES(" + p.getId()+ ", '" + p.getName() + "', " + p.getPrice() + ", '" + p.getDescription() + "');";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			Database.getInstance().closeConnection();
			e.printStackTrace();
		}
		Database.getInstance().closeConnection();
		if (p.getComments() != null)
			DAOComment.addCommentList(p.getComments());
	}
}
