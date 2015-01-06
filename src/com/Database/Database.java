package com.Database;
import java.sql.*;

public class Database {
	private static Database	singleton = null;
	private Connection connection = null;
	
	public static String	USER_ID		= 	"ID";
	public static String	USER_NAME	= 	"NAME";
	public static String	USER_PASSWD	= 	"PASSWD";
	public static String	USER_EMAIL	= 	"EMAIL";
	public static String	USER_ROLE	= 	"ROLE";
	public static String	USER_DATE	= 	"CREATIONDATE";
	
	public static String	PRODUCT_ID		= 	"ID";
	public static String	PRODUCT_NAME	= 	"NAME";
	public static String	PRODUCT_PRICE	= 	"PRICE";
	public static String	PRODUCT_DESC	= 	"DESCRIPTION";
	
	public static String	NEW_ID		= 	"ID";
	public static String	NEW_TITLE	= 	"TITLE";
	public static String	NEW_CONTENT	= 	"CONTENT";
	public static String	NEW_DATE	= 	"DATE";
	public static String	NEW_USER	= 	"LASTUSER";
	
	public static String	COMMENT_ID		= 	"ID";
	public static String	COMMENT_CONTENT	= 	"CONTENT";
	public static String	COMMENT_DATE	= 	"CREATIONDATE";
	public static String	COMMENT_AUTHOR	= 	"AUTHOR";
	public static String	COMMENT_NEW		= 	"NEW";
	
	public static Database getInstance() {
		if (singleton == null) {
			initDatabase();
			singleton = new Database();
		}
		return singleton;
	}
	
	public Statement getStatement() {
		try {
		    Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Arthur\\Documents\\DevProjects\\eclipseWorkspace\\JWeb\\jweb.db");
			return connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void initDatabase() {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Arthur\\Documents\\DevProjects\\eclipseWorkspace\\JWeb\\jweb.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE IF NOT EXISTS USER " +
	                   "( "+ USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
	                   USER_NAME + "     			TEXT    NOT NULL, " + 
	                   USER_PASSWD + "         		TEXT    NOT NULL, " + 
	                   USER_EMAIL + "        		CHAR(50), " +
	                   USER_ROLE + "				INT, " +			
	                   USER_DATE + "   				CHAR(50));"; 
	      stmt.executeUpdate(sql);
	      
	      sql = 	"CREATE TABLE IF NOT EXISTS PRODUCT " +
	    		  	"( " + PRODUCT_ID + " INTEGER PRIMARY KEY, " +
	    		  	PRODUCT_NAME + "	TEXT			NOT NULL, " +
	    		  	PRODUCT_PRICE + "	FLOAT, " +
	    		  	PRODUCT_DESC + "	TEXT);";
	      stmt.executeUpdate(sql);
	      
	      sql =		"CREATE TABLE IF NOT EXISTS NEW " +
	    		  	"( " + NEW_ID + "	INTEGER PRIMARY KEY, " +
	    		  	NEW_TITLE + "		CHAR(100) 		NOT NULL, " +
	    		  	NEW_CONTENT + "		TEXT 			NOT NULL, " +
	    		  	NEW_DATE + "		CHAR(50)		NOT NULL, " +
	    		  	NEW_USER + "		INT, " +
	    		  	"FOREIGN KEY(LASTUSER) REFERENCES USER(ID));";
	      stmt.executeUpdate(sql);
  
	      sql =		"CREATE TABLE IF NOT EXISTS COMMENT " +
	    		  	"( " + COMMENT_ID + "	INTEGER PRIMARY KEY AUTOINCREMENT, " +
	    		  	COMMENT_CONTENT + "		TEXT, " +
	    		  	COMMENT_DATE + "	 	CHAR(50), " +
	    		  	COMMENT_AUTHOR + "		INT				NOT NULL, " +
	    		  	COMMENT_NEW + "			INT				NOT NULL, " +
	    		  	"FOREIGN KEY(AUTHOR) REFERENCES USER(ID), " +
	    		  	"FOREIGN KEY(NEW) REFERENCES NEW(ID));";
	      stmt.executeUpdate(sql);
	      
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	}
}
