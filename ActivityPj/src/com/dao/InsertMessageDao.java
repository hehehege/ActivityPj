package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.db.JdbcTool;
import com.entity.Activity;
import com.entity.Student;


public class InsertMessageDao {
	

	
	/*
	 * 插入部长发布的活动
	 */
	
	public void insertManActivityDao(Activity a)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("insert manactivity(stuid,actname,acttime,actfenshu,actid,acttype) value(?,?,?,?,?,?)");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, a.getStuid());
			ps.setString(2, a.getActname());
			ps.setString(3,  a.getActtime());
			ps.setString(4,a.getActxuefen() );
			ps.setString(5, a.getActid());
			ps.setString(6, a.getActtype());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
	}
	
	
	/*
	 * 插入学生参加的活动
	 */
	public void insertStuActivityDao(Activity a)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("insert stuactivity(stuid,actid,acttype,actfenshu) value(?,?,?,?)");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, a.getStuid());
			ps.setString(2, a.getActid());
			ps.setString(3, a.getActtype());
			ps.setString(4, a.getActxuefen());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
	}
	
	/*
	 * 导入Excel到数据库中
	 */
	public void importExcelDao(List<Student> list,String actid)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("insert stuactivity(stuid,actid,acttype,actfenshu) value(?,?,?,?)");
		PreparedStatement ps=null;
		try {
			 con.setAutoCommit(false);//设置成手动提交，保证数据的完整性，当有一条语句插入失败，就回滚，之前的都不会插入
			  ps=con.prepareStatement(sb.toString());
			for(int i=0;i<list.size();i++)
			{
				ps.setString(1,list.get(i).getStuid() );
				ps.setString(2, actid);
		        ps.setString(3, list.get(i).getActtype() );
		        ps.setString(4,list.get(i).getXuefen());
		        ps.addBatch();// 插入代码打包，等一定量后再一起插入。将要执行的SQL先保存起来，先不执行，一起执行，提高效率
				
			}
			         long start = System.currentTimeMillis();//获取一个时间戳
			         ps.executeBatch();//执行批处理
			         ps.clearBatch();
			         long end = System.currentTimeMillis();//获取一个时间戳
			         System.out.println("用时："+(end-start));
			
		
            con.commit();//2,进行手动提交（commit）

			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
	}
	
	/*
	 * 跟新此活动的标识判断是否被暂停发布，0是真，1是假
	 */
	public void updateActFlagDao(String flag,String actid)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("update Manactivity set actflag=? where actid=?");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ps.setString(1,flag);
			ps.setString(2,actid);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
		
	}
	
	/*
	 * 更新 账户密码
	 */
	
	public void updatePwdDao(String actid,String pwd)
	{
		JdbcTool jt=new JdbcTool();
		Connection con=jt.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("update stulogin set password=? where actid=?");
		try {
			PreparedStatement ps=con.prepareStatement(sb.toString());
			ps.setString(1,pwd);
			ps.setString(2,actid);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally
		{
			jt.CloseConnection(con);
		}
		
		
	}
	
	

}
