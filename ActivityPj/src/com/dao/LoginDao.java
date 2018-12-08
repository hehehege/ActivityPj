package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.JdbcTool;
import com.entity.Activity;
import com.entity.Student;

public class LoginDao {
	
	/*
	 * 得到所有学生用户名和密码
	 */
	public List<Student> isStuUsernameAndPassword()
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from stulogin");
		List<Student> list=new ArrayList<Student>();
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ResultSet rs=ps.executeQuery();
			Student s=null;
			while(rs.next())
			{
				s=new Student();
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setStuname(rs.getString("stuname"));
				
				list.add(s);
				
			}
			
			
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally
		{
			jt.CloseConnection(con);
		}
		
		return null;                                    
		
	}
	
	/*
	 * 判断管理者用户名和密码
	 */
	
	public List<Student> isManUsernameAndPassword()
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from manager");
		List<Student> list=new ArrayList<Student>();
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ResultSet rs=ps.executeQuery();
			Student s=null;
			while(rs.next())
			{
				s=new Student();
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setStuname(rs.getString("name"));
				
				list.add(s);
				
			}
			
			
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
		
		return null;                                    
		
	}

}
