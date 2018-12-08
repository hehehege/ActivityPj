package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.entity.Student;

public class LoginServlet extends HttpServlet {
	private LoginDao ld=null;
	
	public LoginServlet() {
		// TODO 自动生成的构造函数存根
		 ld=new LoginDao();
	}
	
	private HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String path=req.getContextPath();
		System.out.println("path:"+path);
		if(path.equals("/login.logindo"))
		{
			req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
		selectActivityById(req,resp);
	}
	
	public void selectActivityById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
			// TODO 自动生成的方法存根
			req.setCharacterEncoding("utf-8");
			session=req.getSession();
			String path=req.getServletPath();
			String username=req.getParameter("username");  //得到前台输入的账户id也是老师的id
			String password=req.getParameter("password");  //得到前台输入的账户密码
		
			String type=req.getParameter("radios");  //判断是学生还是老师
			List<Student> list=null;
			session.setAttribute("type",type);//判断是老师还是学生
			if(type.equals("管理员"))
			{
				list=new ArrayList<Student>();
				list=ld.isManUsernameAndPassword();
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getUsername().equals(username)&&list.get(i).getPassword().equals(password))
					{
						String managerUsername=list.get(i).getUsername();
						String name=list.get(i).getStuname();
					System.out.println("managerUsername:"+managerUsername+"  "+"name:"+name);
						session.setAttribute("managerUsername", managerUsername);//从数据库中session一个老师的id，也是登陆的用户名
						session.setAttribute("name",name);//从数据库中session一个老师name
						
						req.getRequestDispatcher("ManlookActivity.do").forward(req, resp);
						return;
						
					}
					
						
					
				}
			
				
			//	resp.setCharacterEncoding("utf-8");
				resp.sendRedirect("login.jsp?fail=no");
				
				
				
			}else
			{
				
				list=new ArrayList<Student>();
				list=ld.isStuUsernameAndPassword();
				System.out.println(list.size());
				for(int i=0;i<list.size();i++)
				{
					if(list.get(i).getUsername().equals(username)&&list.get(i).getPassword().equals(password))
					{
						String stuname=list.get(i).getStuname();
						String stuUsername=list.get(i).getUsername();
						String stuPassword=list.get(i).getPassword();
						System.out.println("username:"+username+"  "+"password:"+password+"  "+"name:"+stuname);
						session.setAttribute("stuUsername",stuUsername );
						session.setAttribute("stuname",stuname);
						session.setAttribute("stuPassword", stuPassword);
						req.getRequestDispatcher("/WEB-INF/stuHome.jsp").forward(req, resp);
						return;
						
					}
				}
				resp.sendRedirect("login.jsp?fail=no");
				
			}
			
		}

}
