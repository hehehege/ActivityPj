package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTool {
	private  final String URI="jdbc:mysql://127.0.0.1:3306/activitypj";
	private  final String USER="root";
	private final String PASSWORD="a6478650";
	private  Connection conn=null;
	
	public JdbcTool() {
		// TODO 自动生成的构造函数存根
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URI,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public  Connection getConnection()
	{
		return conn;
	}
	public  void CloseConnection(Connection conn)
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	

}
