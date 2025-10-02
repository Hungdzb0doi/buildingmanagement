package com.BuildingWeb.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBCUtil {
	static final String link="jdbc:mysql://localhost:3306/db_building";
	static final String user="root";
	static final String password="123456";
	public static Connection getConnection() {
		Connection con=null;
		try{
			con=DriverManager.getConnection(link,user,password);
		}catch(SQLException e) {
			System.out.print(e.getMessage());
		}
		return con;
	}
}
