package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GetActivityMsgDao;
import com.dao.InsertMessageDao;
import com.entity.Activity;

public class FormServlet extends HttpServlet {
	private static int num=0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("UTF-8");
		String path=req.getServletPath();
		HttpServletRequest httpRequest=(HttpServletRequest)req;
        
		String strBackUrl = "http://" + req.getServerName() //服务器地址
		                    + ":" 
		                    + req.getServerPort()           //端口号
		                    + httpRequest.getContextPath()      //项目名称
		                    + httpRequest.getServletPath()      //请求页面或其他地址
		        	    + "?" + (httpRequest.getQueryString()); //参数
		String param=httpRequest.getQueryString();//url中的参数
		String paramActid=param.split("=")[2].substring(0, param.split("=")[2].indexOf("&"));//截取url中actid参数
			
		if("1".equals(isActFlag(paramActid)))
		{
			System.out.println("说明活动已经暂停");
			req.getRequestDispatcher("/WEB-INF/fail.jsp").forward(req, resp);
			
		}
		else
		{
			
		System.out.println(strBackUrl);
		
//		String college=req.getParameter("yuanxi");
//		String specialty=req.getParameter("zhuanye");
//		String stuid=req.getParameter("xuehao");
//		String stuname=req.getParameter("name");
//		String counselor=req.getParameter("fudaoyuan");
//		Student s=new Student();
//		s.setStuid(stuid);
//		s.setStuname(stuname);
//		s.setCollege(college);
//		s.setCounselor(counselor);
//		s.setSpecialty(specialty);
//		gmd.getMessage(s);
//		System.out.println(s.toString());
		String acttype=req.getParameter("acttype");
	    String activityName=req.getParameter("activityName");
	    String actid=req.getParameter("actid");
	    String stuid=req.getParameter("xuehao");
	    String actxuefen=req.getParameter("actxuefen");
		System.out.println("活动名称："+activityName);
		System.out.println("活动id："+actid);
		System.out.println("学生id："+stuid);
		System.out.println("活动类型："+acttype);
		System.out.println("活动学分："+actxuefen);
		InsertMessageDao gmd=new InsertMessageDao();
		Activity a=new Activity();
		a.setActid(actid);
		a.setStuid(stuid);
		a.setActtype(acttype);
		a.setActxuefen(actxuefen);
		gmd.insertStuActivityDao(a);
		num++;
		System.out.println("当前访问次数："+num);
		req.getRequestDispatcher("WEB-INF/success.jsp").forward(req, resp);
		}
	   
	}
	public String isActFlag(String actid)
	{
		GetActivityMsgDao gam=new GetActivityMsgDao();
		Activity a=gam.selectActivityByActidDao(actid);
		return a.getActflag();
	}
	
	public String isActid(String actid)
	{
		
		return actid;
	}

}
