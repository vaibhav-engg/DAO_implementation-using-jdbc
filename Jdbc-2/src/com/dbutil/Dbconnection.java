package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	public Connection getConnection(String jdbcUrl,String userName,String userPwd) throws SQLException {
		Connection connection = DriverManager.getConnection(jdbcUrl,userName,userPwd);
		return connection;
	}

}
