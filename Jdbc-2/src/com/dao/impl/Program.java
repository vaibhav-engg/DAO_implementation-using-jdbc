package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("org.postgresql.Driver");
		String jdbcUrl = "jdbc:postgresql://localhost:5432/lmsdb";
		String userName = "postgres";
		String userPwd = "12345";
		Connection connection = DriverManager.getConnection(jdbcUrl,userName,userPwd);
		//if(!connection.isClosed())
			//System.out.println("connection successful");
		String insertSql = "Insert into class(classId,className)\r\n"
				+ "values(67,'suman'),\r\n"
				+ "       (62,'vaibhav'),\r\n"
				+ "       (87,'nitin'),\r\n"
				+ "       (56,'hiren'),\r\n"
				+ "       (5,'shiva');\r\n"
				+ "       ";
		Statement statement = connection.createStatement();
		statement.executeUpdate(insertSql);
		statement.close();
		connection.close();
	}

}
