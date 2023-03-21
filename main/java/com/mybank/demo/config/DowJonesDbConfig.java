package com.mybank.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DowJonesDbConfig {

	public static Connection getConnection() throws Exception{
		String jdbcURL = "jdbc:h2:mem:testdb";
		Connection connection = DriverManager.getConnection(jdbcURL,"sa","");
		return connection;
	}
}
