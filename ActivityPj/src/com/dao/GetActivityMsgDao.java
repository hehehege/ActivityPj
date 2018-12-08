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

public class GetActivityMsgDao {
	
	/*
	 * 通过学号查询此学生参加的活动
	 */
	public List<Activity> selectActivityByIdDao(String id)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select ma.actname,ma.acttime,ma.actfenshu,ma.acttype from manactivity ma,stuactivity s "
				+ "where ma.actid=s.actid and s.stuid=?");
		
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			    ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			Activity a=null;
			List<Activity> list=new ArrayList<Activity>();
			while(rs.next())
			{
				a=new Activity();
				
				a.setActname(rs.getString("actname"));
				a.setActxuefen(rs.getString("actfenshu"));
				a.setActtime(rs.getString("acttime"));
				a.setActtype(rs.getString("acttype"));
				list.add(a);
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
	/*
	 * 查询部长发布的活动
	 */
	public List<Activity> selectManActivityDao(String stuid)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select actid,actname,acttime,actfenshu,actflag from manactivity where stuid=?");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ps.setString(1, stuid);
			ResultSet rs=ps.executeQuery();
			List<Activity> list=new ArrayList<>();
			Activity a=null;
			while(rs.next())
			{
				a=new Activity();
				a.setActid(rs.getString("actid"));
				a.setActname(rs.getString("actname"));
				a.setActtime(rs.getString("acttime"));
				a.setActxuefen(rs.getString("actfenshu"));
				a.setActflag(rs.getString("actflag"));
				list.add(a);
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

	
	/*
	 * 通过活动id查询此次活动信息
	 */
	public Activity selectActivityByActidDao(String actid)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select actid,actname,acttime,actfenshu,actflag from manactivity where actid=?");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ps.setString(1, actid);
			ResultSet rs=ps.executeQuery();
		
			Activity a=null;
			while(rs.next())
			{
				a=new Activity();
				a.setActid(rs.getString("actid"));
				a.setActname(rs.getString("actname"));
				a.setActtime(rs.getString("acttime"));
				a.setActxuefen(rs.getString("actfenshu"));
				a.setActflag(rs.getString("actflag"));
			
			}
			return a;
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
	
	/*
	 * 查询此活动的参与人数通过活动id
	 */
	public List<Student> selectActivityNumByActidDao(String actid)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select m.stuid,m.stuname,m.college,m.specialty,m.counselor,s.actid,s.acttype,s.actfenshu from "
				+ "message m inner join stuactivity s on s.actid=? and s.stuid=m.stuid left join "
				+ "manactivity ma on s.actid=ma.actid=? group by stuid");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
	        ps.setString(1,actid);
	        ps.setString(2,actid);
			ResultSet rs=ps.executeQuery();
		    List<Student> list=new ArrayList<>();
			Student s=null;
			while(rs.next())
			{
				s=new Student();
				s.setStuid(rs.getString("stuid"));
				s.setStuname(rs.getString("stuname"));
				s.setCollege(rs.getString("college"));
				s.setSpecialty(rs.getString("specialty"));
				s.setCounselor(rs.getString("counselor"));
				s.setActtype(rs.getString("acttype"));
				s.setXuefen(rs.getString("actfenshu"));
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
	
	/*
	 * 查询所有活动的id
	 */
	
	public List<String> selActAllIdDao()
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select actid from manactivity group by actid");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			
			ResultSet rs=ps.executeQuery();
			Activity a=null;
			List<String> list=new ArrayList<String>();
			while(rs.next())
			{
				list.add(rs.getString("actid"));
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
