package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DownloadExcel  {
	
	/*
	 * 下载excel
	 */
	public void downExcel(HSSFWorkbook wb,HttpServletResponse res,String fileName) throws IOException
	{
		
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      wb.write(os);
	      byte[] content = os.toByteArray();
	      InputStream is = new ByteArrayInputStream(content);
	      // 设置response参数，可以打开下载页面
	      res.reset();
	      res.setContentType("application/vnd.ms-excel;charset=utf-8");
	      res.setHeader("Content-Disposition", "attachment;filename="
	          + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	      ServletOutputStream out = res.getOutputStream();
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	 
	      try {
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(out);
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        // Simple read/write loop.
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	          bos.write(buff, 0, bytesRead);
	        }
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      } finally {
	        if (bis != null)
	          bis.close();
	        if (bos != null)
	          bos.close();
	      }
	}
	
	/*
	 * 下载二维码
	 */
	
	public void dowErWeiMa(String erweimaName,String stuid,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException
	{
		  
	        String finalySavePath="D:\\活动\\活动二维码\\"+stuid+"\\"+erweimaName+".jpg";
			//String path=suf.getSavepath();//婵烇絽娲︾换鍌炴偤閵娧勫磯妞ゆ牗姘ㄧ粣锟�
	      
			File f=new File(finalySavePath);//闁荤喐娲戝鎺旂箔閸涱喗濮滈柣锝呮湰閻ｉ亶鏌￠崒姘煑婵炲棎鍨介幆鍐礋椤愩倖鎲奸梺鐚存嫹闁告瑣鍎崇粔瀵哥磽閸愭寧瀚�    path/name
			//闂佺顑冮崕閬嶆晬鎼淬劌绠戠憸宥夊垂娴犲妫橀柨鐕傛嫹
			if(!f.exists()){
				request.setAttribute("message", "文件已经删除");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				
			}
			
			//闁诲繐绻愬Λ鏃堟嚈閹达箑妫橀柛銉㈡櫆閻ｉ亶鏌￠崒姘煑婵炲棎鍨藉畷銉ヮ吋閸モ晜銇濋梺娲诲枙缁�渚�骞冨Δ鍛鐎广儱妫欓弶褰掓煕閹烘梹鐝穞tp闂佹眹鍔岀�氼剟骞栭柨瀣劅闁哄倽锟ユ禒鍫濃槈閹垮啫骞栨鐐存崌閺佸秴鐣濋敓鐣屾椤忓牊鍎樺ù锝夘棑椤撴椽鏌涘顒�顒㈢紒浣藉吹閹叉挳宕煎┑鍥╁綔闂佺尨鎷烽悹鍝勬惈閻撳倿鏌涘顒傚嚬缂佸彉鍗抽幊娑㈩敂閸曨倣妤呮偡濞嗘瑧鎮奸柣鏍垫嫹
			
			//filepath=URLEncoder.encode(filepath,"utf-8");
			//闁荤姳绀佹晶浠嬫偪閸℃稑鐭楅柛灞剧♁濞堝爼鏌ㄥ☉妯侯殭濠电偛娲ら銉ノ旀担鎭掑仸闁荤喐鐟ラ悧鍡椻枍閹烘鐭楁い鏍ㄧ懁缁ㄦ澘霉閻橆喖鍔欑紒妤�鎳忓顏堟偩鐏炲墽鏆犻梺鍝勫�婚幊鎾舵閿熺姴绠ラ柟鎯х－绾惧鏌￠崒姘煑婵炲棎鍨芥俊鎾晸閿燂拷
			 response.setHeader("content-disposition", "attachement;filename="+stuid+"-"+erweimaName+".jpg");
			 response.setContentType("application/octet-stream");
			//闁诲繐绻愬Λ婊堛�呴敂鐣屸枖閻庯綆鍘界粊浼存煟閵娿儱顏柡瀣暞缁傛帞鎹勯搹鍦梺绋款儐閻喚绮╃�涙鈻旈柣姘兼垢putStream闁荤姴娲╅褑銇愰崶銊︿氦婵炴垶鐟﹂梽锟�
			InputStream in=new FileInputStream(f);
			//闁荤姴娲﹀Σ鎺旀崲濮楋拷瀵爼濡烽妷锕�锟界敻鏌ㄥ☉妯垮闁哥噦鎷烽梺鍛婂姈閻熴儵宕虹�圭sponse.getOutputStream()闂佸憡顭堥褍顫濋妸鈺佺煑妞ゆ牗鐟ょ花鏉棵瑰鎰
			//闂佺儵鏅濋…鍫㈣姳閺屻儲鍎嶉柛鏇ㄥ墯濞堝爼鏌熼惂鍛婂
			OutputStream out=response.getOutputStream();
			
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1){
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("文件上传成功");
		  
		
		
		
	}
	

}
