package com.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.entity.Student;

public class Excel {
	
	public void bornExcel(List<Student> lists,String actname,HttpServletResponse res)
	{
	   // 1.创建一个workbook，对应一个Excel文件
    HSSFWorkbook wb = new HSSFWorkbook();
    // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
    HSSFSheet sheet = wb.createSheet(actname);
    // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
    HSSFRow row = sheet.createRow((int) 0);
    // 4.创建单元格，设置值表头，设置表头居中
    HSSFCellStyle style = wb.createCellStyle();
    // 居中格式
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

    // 设置表头
    HSSFCell cell = row.createCell(0);
    cell.setCellValue("学号");
    cell.setCellStyle(style);

    cell = row.createCell(1);
    cell.setCellValue("姓名");
    cell.setCellStyle(style);

    cell = row.createCell(2);
    cell.setCellValue("院系");
    cell.setCellStyle(style);

    cell = row.createCell(3);
    cell.setCellValue("专业");
    cell.setCellStyle(style);

    cell = row.createCell(4);
    cell.setCellValue("辅导员");
    cell.setCellStyle(style);
    
    cell = row.createCell(5);
    cell.setCellValue("参与形式");
    cell.setCellStyle(style);
    
    cell = row.createCell(6);
    cell.setCellValue("学分");
    cell.setCellStyle(style);
    for (int i = 0; i < lists.size(); i++) {
        row = sheet.createRow((int) i + 1);
        Student s= lists.get(i);
        // 创建单元格，设置值
        row.createCell(0).setCellValue(s.getStuid());
        row.createCell(1).setCellValue(s.getStuname());
        row.createCell(2).setCellValue(s.getCollege());
        row.createCell(3).setCellValue(s.getSpecialty());
        row.createCell(4).setCellValue(s.getCounselor());
        row.createCell(5).setCellValue(s.getActtype());
        row.createCell(6).setCellValue(s.getXuefen());
    } 
    DownloadExcel d=new DownloadExcel();
    try {
		d.downExcel(wb, res, actname);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
    FileOutputStream out;
  		try {
  			out = new FileOutputStream("D:/活动/"+actname+".xls");
  			  wb.write(out); 
  		        out.close();
  			}
  		catch (IOException e) {
  			// TODO 自动生成的 catch 块
  			e.printStackTrace();
  		}
  		
	}
   
	}

