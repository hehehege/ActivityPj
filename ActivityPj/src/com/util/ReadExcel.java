package com.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Activity;
import com.entity.Student;

public class ReadExcel {
	public List<Student> readExcel(File file) {
		try {

			List<Student> list = new ArrayList<Student>();
            System.out.println("file.getAbsolutePath():"+file.getAbsolutePath());
			// 创建输入流，读取Excel
			InputStream is = new FileInputStream(file.getAbsolutePath());
			// jxl提供的Workbook类
			Workbook wb = Workbook.getWorkbook(is);

			// Excel的页签数量
			int sheet_size = wb.getNumberOfSheets();

			int xuehao = 0;
			int acttype = 0;
			int xuefen = 0;
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(0);
			System.out.println("共有--" + sheet.getColumns() + "列");
			for (int i = 0; i < sheet.getRows(); i++) { // 此处我改成了i=1 去掉头部分
				// sheet.getColumns()返回该页的总列数

				for (int j = 0; j < sheet.getColumns(); j++) {

					if (sheet.getCell(j, i).getContents().equals("学号")) {
						xuehao = j;
						System.out.println("学号：" + j);
					}
					if (sheet.getCell(j, i).getContents().equals("参与形式")) {
						acttype = j;
						System.out.println("参与形式：" + j);
					}
					if (sheet.getCell(j, i).getContents().equals("学分")) {
						xuefen = j;
						System.out.println("学分：" + j);
					}

				}
			}

			System.out.println("共有--" + sheet.getRows() + "行");
			// sheet.getRows()返回该页的总行数
			Student student = null;
			for (int k = 1; k < sheet.getRows(); k++) { // 此处我改成了i=1 去掉头部分
				student = new Student();
				// sheet.getColumns()返回该页的总列数
				String cellstuid = sheet.getCell(xuehao, k).getContents();
				String cellacttype = sheet.getCell(acttype, k).getContents();
				String cellactxuefen = sheet.getCell(xuefen, k).getContents();

				student.setStuid(cellstuid);
				student.setActtype(cellacttype);
				student.setXuefen(cellactxuefen);
				

				list.add(student);

				// outerList.add(i, innerList);//此处我改成了i-1 去掉头部分
			}

			return list;

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public Activity readOneExcel(File file) {
		try {

			List<Student> list = new ArrayList<Student>();

			// 创建输入流，读取Excel
			InputStream is = new FileInputStream(file.getAbsolutePath());
			// jxl提供的Workbook类
			Workbook wb = Workbook.getWorkbook(is);

			// Excel的页签数量
			int sheet_size = wb.getNumberOfSheets();

			int xuehao = 0;
			int acttype = 0;
			int xuefen = 0;
			int actname=0;
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(0);
			System.out.println("共有--" + sheet.getColumns() + "列");
			for (int i = 0; i < sheet.getRows(); i++) { // 此处我改成了i=1 去掉头部分
				// sheet.getColumns()返回该页的总列数

				for (int j = 0; j < sheet.getColumns(); j++) {

				
					if (sheet.getCell(j, i).getContents().equals("活动名字")) {
						actname = j;
						System.out.println("活动名字：" + j);
					}
					if (sheet.getCell(j, i).getContents().equals("参与形式")) {
						acttype = j;
						System.out.println("参与形式：" + j);
					}
					if (sheet.getCell(j, i).getContents().equals("学分")) {
						xuefen = j;
						System.out.println("学分：" + j);
					}

				}
			}

			// sheet.getRows()返回该页的总行数
			Activity activity = null;
			for (int k = 1; k <=1; k++) { // 此处我改成了i=1 去掉头部分
				activity = new Activity();
				// sheet.getColumns()返回该页的总列数
				String cellactname = sheet.getCell(actname, k).getContents();
				String cellacttype = sheet.getCell(acttype, k).getContents();
				String cellactxuefen = sheet.getCell(xuefen, k).getContents();

				activity.setActtype(cellacttype);
	            activity.setActname(cellactname);
				activity.setActxuefen(cellactxuefen);
				

			

				// outerList.add(i, innerList);//此处我改成了i-1 去掉头部分
			}

			return activity;

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	

}
