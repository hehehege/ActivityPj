<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
	String Path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()

			+ ":" + request.getServerPort() + Path + "/";
%>
<html>
<head>
<title>提交</title>
<meta http-equiv='Content-type' content='text/html; charset=utf-8' />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="bootstrap-responsive.css" rel="stylesheet">
<style>
body,h1,h2,p,dd,form,fieldset{margin:0;}
ul,ol,dl{margin:0;padding:0;list-style:none;}
a{text-decoration:none;outline:none;}
body{background: #F6F6F6;font:20px/1.5 'Microsoft Yahei',sans-serif;/*sans-serif æ¯ææºé»è®¤å­ä½*/}
h1{
	text-align: center;
	font-size: 24px;
}
#gard,
.inp{
	width: 100%;
	height: 30px;
	margin: auto;
	box-sizing: border-box;
}
.inp{
	font-size: 16px;
	color: #333;
	border: 1px solid;
}
.inp:focus{
	border: 1px solid #4aa7ec;
}
.submit{
	display: block;
	margin: 30px auto 0;
	padding: 5px 15px;
	color: #333;
}
</style>
</head>
<!-- <p>院系:</p><p>
    	<select name="yuanxi" id="gard">
    		<option value=""></option>
    		<option value="通信与物联网工程学院">通信与物联网工程学院</option>
    		<option value="大数据与软件学院">大数据与软件学院</option>
    		<option value="智能工程学院">智能工程学院</option>
    		<option value="淬炼商学院">淬炼商学院</option>
    		<option value="中德学院">中德学院</option>
    		<option value="远景学院">远景学院</option>
    		<option value="外语系">外语系</option>
    	</select>
    </p>
    <p>专业:</p><p><input type="text" class="inp" name="zhuanye"></p> 
     <p>姓名:</p><p><input type="text" class="inp" name="name"></p>
    <p>辅导员:</p><p><input type="text" class="inp" name="fudaoyuan"></p>
    -->
<body>
<%String activityName=request.getParameter("activityName");
String actid=request.getParameter("actid");
String acttype=request.getParameter("acttype");
String actxuefen=request.getParameter("actxuefen");

%>

<h1>活动名称：<%=activityName %></h1>
<h1>活动id:<%=actid %></h1>
<form action="upload.do" id="myForm"><!--FormServlet  -->
    
    <p>学号:</p><p><input type="text" class="inp" name="xuehao"></p>
    <input type="hidden" value="<%=actid %>" name="actid">
  
    <input type="hidden" value="<%=activityName%>" name="activityName">
     <input type="hidden" value="<%=acttype%>" name="acttype">
       <input type="hidden" value="<%=actxuefen%>" name="actxuefen">
    
    <input type="button" value="提交" class="submit">

</form>
<script>

(function(){

	var submit = document.getElementsByClassName('submit')[0];

	if(getCookie('mark')){
	submit.setAttribute('disabled','true')
	}
	submit.onclick = function(){
	saveCookie('mark','mark',1000*60) //60秒
	
	submit.setAttribute('disabled','true')
	myForm.submit();
	}




	function saveCookie(cookieName,cookieValue,cookieDates){
	    let d = new Date();
	    d.setTime(d.getTime()+cookieDates);
	    document.cookie = cookieName+"="+cookieValue+";expires="+d.toGMTString();
	}

	function getCookie (name) {
	    let arr;
	    let reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	    if (arr = document.cookie.match(reg))
	        return unescape(arr[2]);
	    else
	        return null;
	};

	})()
</script>

</body>
</html>
