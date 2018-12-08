package com.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dao.GetActivityMsgDao;
import com.entity.Activity;
import com.entity.Student;
import com.util.ReadExcel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test2 {

	  private static final int BLACK = 0xFF000000;
      private static final int WHITE = 0xFFFFFFFF;
   
      public static void main ( String[] args ) throws Exception
      {
//          ReadExcel r=new ReadExcel();
//          File f=new File("D:\\活动\\活动台账\\观众二维码.xls");
//          List list=r.readExcel(f);
//         for(int i=0;i<list.size();i++)
//         {
//        	 System.out.println(list.get(i).toString());
//         }
//    	  GetActivityMsgDao g=new GetActivityMsgDao();
//    	 List<String> list= g.selActAllId();
//    	 JSONObject wang=new JSONObject();
//    	
//    	 JSONArray jsonArray2= JSONArray.fromObject(list);
//    	 
//    	 System.out.println(jsonArray2);
    	  File f=new File("C:\\Users\\20898\\Desktop\\观众二维码.xls");
    	  ReadExcel r=new ReadExcel();
    	  Activity list=r. readOneExcel(f);
    		
    			System.out.println(list.toString());
    			System.out.println(list.toString());
    			System.out.println(list.toString());
    			System.out.println(list.toString());
    			System.out.println(list.toString());
    			
    		
    	
    	  
      }
}
