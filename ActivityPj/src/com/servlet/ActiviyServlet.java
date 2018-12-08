package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.QRCodeUtil;
import com.dao.GetActivityMsgDao;
import com.dao.InsertMessageDao;
import com.entity.Activity;
import com.entity.Student;
import com.util.DownloadExcel;
import com.util.Excel;
import com.util.ReadExcel;
import com.util.ReadExcel2;

import jdk.nashorn.internal.scripts.JS;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class ActiviyServlet extends HttpServlet {
	public HttpSession session;
	
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
	   if(path.equals("/ajax.do"))
		{
			System.out.println("进入ajax.do");
			
			GetActivityMsgDao gamd=new GetActivityMsgDao();
			List<String> list=gamd.selActAllIdDao();
		     
			JSONArray jsonArray2= JSONArray.fromObject(list);
			resp.getWriter().println(jsonArray2);
			
		}
	// TODO 自动生成的方法存根
	   doPost(req,resp);
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		req.setCharacterEncoding("utf-8");
		String path=req.getServletPath();
		 session=req.getSession();
		 String managerUsername=(String) session.getAttribute("managerUsername");
		
		    //跨域访问
//		    resp.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错   
//		    resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");   
//		    resp.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间   
//		    resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");   
//		    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.   
//		    resp.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");  
	
		if(path.equals("/ManlookActivity.do"))//管理员查看自己发布的活动
		{
			GetActivityMsgDao g=new GetActivityMsgDao();
			 
			List<Activity> listActivity=g.selectManActivityDao(managerUsername);
			req.setAttribute("listActivity", listActivity);
			req.getRequestDispatcher("WEB-INF/ManlookActivity.jsp").forward(req, resp);
		}
		if(path.equals("/releaseActivity.do"))//管理员发布活动
		{
			System.out.println("成功进入");
			String activityName=req.getParameter("actName");
		    String actxuefen=req.getParameter("actXueFen");
		    String acttime=req.getParameter("actTime");
		    String acttype=req.getParameter("radios");
		    System.out.println("acttype:"+acttype);
		    
		  
		    System.out.println("stuUsername:"+managerUsername);
		    
			String actid=random(managerUsername);//一个活动唯一标识 传入学号
			
		   // String randomNum=Integer.toHexString(x);;//一个活动唯一标识
		  
		 
		    System.out.println("活动id："+actid);
		    producedErWeiMa(activityName,actxuefen,acttime,actid,managerUsername,acttype);//生成二维码
		    insertAct(activityName,actxuefen,acttime,actid,managerUsername,acttype);//部长发布活动插入进数据库 
		    req.getRequestDispatcher("WEB-INF/ManlookActivity.jsp").forward(req, resp);
		}
		if(path.equals("/stopRelease.do"))//停止发布活动
		{
			String actid=req.getParameter("actid");
			
			InsertMessageDao imd=new InsertMessageDao();
			imd.updateActFlagDao("1",actid );//1为暂停 0为发布
			System.out.println("暂停发布");
			req.getRequestDispatcher("/ManlookActivity.do").forward(req, resp);
		}
		if(path.equals("/stuLookActivity.do"))//学生查看自己的活动
		{     
			String stuUsername=(String) req.getSession().getAttribute("stuUsername");
			System.out.println("学生查看自己的活动a a a a ");
			List<Activity> listActivity=lookActivity(stuUsername);
			req.setAttribute("listActivity", listActivity);
			req.getRequestDispatcher("/WEB-INF/stulookActivity.jsp").forward(req, resp);
			
		}
		if(path.equals("/excel.do"))//导出活动的excel
		{
			System.out.println("进入excel.do");
			String actid=req.getParameter("actid");
			String actname=req.getParameter("actname");
			System.out.println("活动id："+actid);
			Excel excel=new Excel();
			GetActivityMsgDao g=new GetActivityMsgDao();
			List<Student> list=g.selectActivityNumByActidDao(actid);
			excel.bornExcel(list,actname,resp);
			boolean flag=false;
			//PrintWriter out=resp.getWriter();
			//out.println("<script language='javascript'>alert('导出成功')</script>");
			//resp.sendRedirect("/WEB-INF/ManlookActivity.jsp");
			req.setAttribute("exportSuccess", flag);
			req.getRequestDispatcher("/ManlookActivity.do").forward(req, resp);
			return;
		}
		if(path.equals("/download.do"))//下载二维码
		{
			System.out.println("下载呵呵");
			String actid=req.getParameter("actid");	
			String actname=req.getParameter("actname");
			String erweimaName=actname+actid;
			DownloadExcel d=new DownloadExcel();
			d.dowErWeiMa(erweimaName, managerUsername,resp,req);
			req.getRequestDispatcher("/ManlookActivity.do").forward(req, resp);
		}
		if(path.equals("/importExcel.do"))//导入excel到数据库
		{
			System.out.println("进入importExcel.do111");
         	String actNewOrOld=req.getParameter("radio");
		
			System.out.println("actNewOrOle:"+actNewOrOld);
			
			//旧活动
			getUpExcel(req,managerUsername);
		    resp.setCharacterEncoding("utf-8");
		    System.out.println("正在跳转");
		    resp.sendRedirect("/ActivityPj/ManlookActivity.do");
			//req.getRequestDispatcher("ManlookActivity.do").forward(req, resp);
		    System.out.println("------------");
		
		}
		if(path.equals("/updatePassword.do"))
		{
			updatePwd(req);
		}
		
	
	}
	/*
	 * 生成一个活动的id(actid)
	 */
	public String random(String str)
	{
		 for (int i = 0;i<1;i++){
	            str = str+ (char)(Math.random()*26+'A');
	            str =str +(int)(Math.random()*1000);
	        }
		 return str;
	}
	

	/*
	 * 点击生成二维码
	 */
	public void producedErWeiMa(String activityName,String actxuefen,String acttime,String actid,String stuid,String acttype)
	{
		
		String url =" http://thvp5j.natappfree.cc/ActivityPj/from.jsp?"
				+ "activityName="+activityName+"&actxuefen="+actxuefen+"&acttime="+acttime+"&actid="+actid+"&acttype="+acttype;
		try {
			QRCodeUtil.encode(url,"","D:\\活动\\活动二维码\\"+stuid,true,activityName,actid,acttype,actxuefen);
			System.out.println("生成成功url："+url);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 插入部长发布的活动
	 */
	public void insertAct(String activityName,String actxuefen,String acttime,String actid,String managerUsername,String acttype)
	{  
		
		Activity a=new Activity();
		InsertMessageDao imd=new InsertMessageDao();
		a.setStuid(managerUsername);
		a.setActid(actid);
		a.setActname(activityName);
		a.setActtime(acttime);
		a.setActxuefen(actxuefen);
		a.setActtype(acttype);
		imd.insertManActivityDao(a);	
	}
	
	/*
	 * 插入学生参加的活动
	 */
	
	public void insertStuAct(String actid,String stuid,String actfenshu)
	{
		InsertMessageDao imd=new InsertMessageDao();
		Activity a=new Activity();
		a.setActid(actid);
		a.setStuid(stuid);
		a.setActxuefen(actfenshu);
		System.out.println("------------------:"+a.getActxuefen());
		imd.insertStuActivityDao(a);
		
	}
	
	/*
	 * 学生自己查看参加的活动
	 */
	
	public List<Activity> lookActivity(String stuid)
	{
		GetActivityMsgDao gamd=new GetActivityMsgDao();
		
		for(Activity a: gamd.selectActivityByIdDao(stuid))
		{
			System.out.println(a.toString());
		}
		return gamd.selectActivityByIdDao(stuid);
		
	}
	
	
	/*
	 * 得到前台导入的excel数据
	 */
	public void getUpExcel(HttpServletRequest req,String managerUsername)
	{
		try {
			//获取前端信息
		    DiskFileUpload diskFileUpload = new DiskFileUpload();
	        diskFileUpload.setHeaderEncoding("utf-8");
	        List<FileItem> list = diskFileUpload.parseRequest(req);
	        File preFile=null;
	        List<String> listFileItem =new ArrayList<String>();
	        for(FileItem fileItem : list){
	            if(!fileItem.isFormField()){
//fileItem.isFormField()就是判断一个参数域是普通的表单输入域，还是文件上传域，如果该方法返回真的话，则是前者，如果为假，则是后者。是后者的情况下，就要对相应的域做相应的文件上传处理。
	                if("importContainerFile".equals(fileItem.getFieldName())){//前台文件框id
	                     // 客户端文件路径构建的 File 对象
	                     preFile = new File(new String(fileItem.getName().getBytes(), "utf-8"));
	                    System.out.println("Absolute:"+preFile.getAbsolutePath());
                       
                        // importExcel(listExcel);//调用导入excel方法
                         
	                }
	            }
	            else
	            {
	            	System.out.println("是表单域");
	            	listFileItem.add(fileItem.getString());//存入前台表单域里面的东西 目前有radio(新旧活动)和text(actid)
	            }
	        }
	        InsertMessageDao imd=new InsertMessageDao();
	        ReadExcel read=new ReadExcel();
	        if(listFileItem.get(0).equals("acNew"))
	        {
	        	System.out.println("新活动");
	        String newActid=random(managerUsername);//生成一个新的活动id
	        List<Student> listStudent=read.readExcel(preFile);
	        Activity a=read.readOneExcel(preFile);
	        a.setStuid(managerUsername);//传入此账号人的stuid
	        a.setActid(newActid);
	        imd.importExcelDao(listStudent,newActid);//将读取的excel数据导入到数据库中
	        imd.insertManActivityDao(a);//再插入到manactivity表中
	        }
	        if(listFileItem.get(0).equals("acOld"))
	        {
	        	System.out.println("老活动");
	        	System.out.println("listFileItem.get(0).toString():"+listFileItem.get(0).toString());
	        	
	        	System.out.println("listFileItem.get(1).toString():"+listFileItem.get(1).toString());
	        	  List<Student> listStudent=read.readExcel(preFile); //读取excel中的内容，只截取学号和参与形式和学分三列数据
	        	  imd.importExcelDao(listStudent, listFileItem.get(1).toString());//listFileItem.get(1).toString()表单中的活动id
	        }  
	       
	    } catch (FileUploadException | UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * 更新用户名密码
	 */
	
	public void updatePwd(HttpServletRequest req)
	{
		String pwd=req.getParameter("pwd");
		
		
	}
	
	
	
		
	}

