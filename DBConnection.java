package com.cg.donor.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		
		
		Properties prop=new Properties();
		
		//File file=new File("resources/DB.properties");
		
		FileInputStream fileInputStream = new FileInputStream("resources/DB.properties");
		
		prop.load(fileInputStream);
		
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		
		return conn;

	}
	
	

}
