package com.util;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;


public class ReadExcel2 {
	 public List readExcel(File file) {
	        try {
	        	Student s=null;
	            // 创建输入流，读取Excel
	            InputStream is = new FileInputStream(file.getAbsolutePath());
	            // jxl提供的Workbook类
	            Workbook wb = Workbook.getWorkbook(is);
	           
	            // Excel的页签数量
	            int sheet_size = wb.getNumberOfSheets();
	            for (int index = 0; index < sheet_size; index++) {
	                List<List> outerList=new ArrayList<List>();
	                // 每个页签创建一个Sheet对象
	                Sheet sheet = wb.getSheet(index);
	                // sheet.getRows()返回该页的总行数
	                for (int i = 0; i < sheet.getRows(); i++) {
	                    List innerList=new ArrayList();
	                    s=new Student();
	                    // sheet.getColumns()返回该页的总列数
	                    for (int j = 0; j < sheet.getColumns(); j++) {
	                        String cellinfo = sheet.getCell(j, i).getContents();
	                        if(cellinfo.isEmpty()){
	                            continue;
	                        }
	                        innerList.add(cellinfo);
	                    }
	                    outerList.add(i, innerList);
	                }
	                return outerList;
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (BiffException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


}
