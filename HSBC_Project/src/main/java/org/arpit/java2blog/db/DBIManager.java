package org.arpit.java2blog.db;

import java.sql.*;
import java.util.Properties;

import org.jdbi.v3.core.Handle;

public class DBIManager {
	public Connection getConnectionObject() {
		/*
		 * Handle handle = null; try { DBI dbi = new
		 * DBI("jdbc:mysql://localhost:3306/mydb", "root", "Munna@1122");
		 * 
		 * handle = (Handle) dbi.open(); System.out.println("Handel created"); } catch
		 * (Exception e) { System.out.println("error occured"); e.printStackTrace(); }
		 * return handle;
		 */

		Connection dbConnection = null;
		Connection dbConnection1 = null;
		Statement stmt = null;
		Statement stmt1 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb";
			Properties info = new Properties();
			info.put("user", "root");
			info.put("password", "Munna@1122");

			dbConnection = DriverManager.getConnection(url, info);
			dbConnection1 = DriverManager.getConnection(url, info);

			stmt = dbConnection.createStatement();
			stmt1 = dbConnection1.createStatement();

			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS product " + "(id int NOT NULL AUTO_INCREMENT, "
					+ " category VARCHAR(255), " + " compeny VARCHAR(255), " + " product_no VARCHAR(255), "
					+ " color VARCHAR(255), " + " description VARCHAR(255), " + " price double, "
					+ " discount double , " + " in_stack_count int ," + " PRIMARY KEY (id))");
			stmt1.executeUpdate("CREATE TABLE IF NOT EXISTS ordertbl " + "(id int NOT NULL AUTO_INCREMENT, "
					+ " product_no VARCHAR(255), "+ " compeny VARCHAR(255), "+ " PRIMARY KEY (id))");

			System.out.println("exicuted");

			if (dbConnection != null) {
				System.out.println("Successfully connected to MySQL database test");
			}

		} catch (SQLException ex) {
			System.out.println("An error occurred while connecting MySQL databse");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbConnection;
	}

}
