
<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<link rel="stylesheet" href="resources/css/home.css" media="screen" type="text/css"/>
</head>
<form name="dengluform" action="LoginServlet.logindo" method="post">
		<div class="pic">
			<img src="resources/images/移通标志.png" alt=" ">
		</div>
		<input type="text" name="username" placeholder="用户名"/>
		<input type="password" name="password" placeholder="密码"/>
		<div>
			<input type="radio" name="radios" class="radio" id="teacher"  value="管理员" checked="checked"/>
			<label class="option" for="teacher">管理员</label> 
			<input type="radio" name="radios" class="radio" id="student" value="学生" />
			<label class="option" for="student">学生</label>
			
			
			
		</div>
		<input type="submit" name="submit" value="登录" class="button"/>
</form>


<script> 
  var fail ='<%=request.getParameter("fail")%>';
  if(fail=='no'){
   alert("登录失败!");
  }
</script>
<body>

</body>
</html>
