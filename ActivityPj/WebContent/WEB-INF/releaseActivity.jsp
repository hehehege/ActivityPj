<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
	String Path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()

			+ ":" + request.getServerPort() + Path + "/";
%>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Amaze后台管理系统模板HTML首页 - cssmoban</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="resources/images/s/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="resources/images/s/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="resources/css/s/amazeui.min.css"/>
  <link rel="stylesheet" href="resources/css/s/admin.css">
  
<style>
 	#ex-acSubmit span {
		float: left;
 	}
 	#ex-acSubmit i{
 		float: right;
 		color: #f20;
 	}
 	#ex-acSubmit input[type='text']{
 		width: 100%;
 		clear: both;
 	}
 </style>
  
</head>
<body>
 
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
   <title>活动后台</title>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
  <%String teaid=(String)request.getSession().getAttribute("teaid"); 
  String managerUsername=(String)request.getSession().getAttribute("name");
 
  %>
  <div>你好,<%=managerUsername %> </div>

</header>

<div class="am-cf admin-main" >
  <!-- sidebar start -->
  <div class="admin-sidebar">
   <form name="form1" method="post" id="myform1">
    <ul class="am-list admin-sidebar-list">
      
       <li><a href="#" class="ex-acPub" onclick="return fabu()" id="fabu"><span class="am-icon-pencil-square-o"  ></span> 发布活动</a></li>
      <li><a href="ManlookActivity.do" id="chakan" onclick="return chakan()"><span class="am-icon-pencil-square-o"></span> 查看活动</a></li>
      <li><a href="#"><span class="am-icon-sign-out"></span> 帮助</a></li>
    </ul>
 </form>
    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p><input type="hidden"/>
        <p>时光静好，与君语；细水流年，与君同。—— Amaze</p>
      </div>
    </div>

  </div>

  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
	<button
	  type="button"
	  id="fabuButton"
	  class="am-btn am-btn-primary"
	  data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0, width: 400, height: 225}"
	   style="display: none;"
	  >
	  发布
	</button>

	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">请输入以下信息
	      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
	    </div>
	    <form id="ex-acSubmit" class="am-modal-bd ex-acSubmit" action="releaseActivity.do" method="POST">
	      <p><span>活动名称:</span><input type="text" name="actName"></p>
	      <p>
	      	<span>活动时间:</span>
	      	<i>*示例：2018-00-00</i>
	      	<input class="ex-date" type="text" name="actTime">
	      </p>
	      <p>
	      	<span>活动形式:</span>
	      	<i>选择观众将生成观众二维码 </i>
	      	<i>选择参赛者将生成报名二维码</i>
	      	<input class="ex-date" type="checkbox" name="radios" value="观众">&nbsp;&nbsp;观众 &nbsp;&nbsp;&nbsp;&nbsp;  
	      	<input class="ex-date" type="checkbox" name="radios" value="参与者">参与者
	      </p>
	      <p>
	      	<span>活动学分:</span>
	      	<i>*示例：1.0</i>
	      	<input class="ex-num" type="text" name="actXueFen">
	      </p>
	      <input class="am-btn am-btn-primary ex-sub" type="button" value="生成二维码">
	    </form>
	  </div>
	</div>
	
  </div>
</div>
  <script src="resources/js/s/jquery.min.js"></script>
  <script src="resources/js/s/amazeui.min.js"></script>
 
  <script src="resources/js/s/app.js"></script>
  <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="resources/js/s/polyfill/rem.min.js"></script>
<script src="resources/js/s/polyfill/respond.min.js"></script>
<script src="resources/js/s/amazeui.legacy.js"></script>
<script src="resources/js/Manager.js" ></script>
	<script>
	var pub = document.getElementsByClassName('ex-acPub')[0],
	addBut = document.getElementsByClassName('am-btn-primary')[0],
	subBox = document.getElementsByClassName('ex-acSubmit')[0],
	date = subBox.getElementsByClassName('ex-date')[0],
	num = subBox.getElementsByClassName('ex-num')[0],
	subBut = subBox.getElementsByClassName('ex-sub')[0],

	reg1 =  /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/,
	reg2 = /^\d{1,}\.\d$/;
	
addBut.style.display='none';
pub.onclick = function(){
	addBut.style.display='block';
}


subBut.onclick = function(){
	console.log(reg1.test(date.value),reg2.test(num.value))
	if (!reg1.test(date.value) || !reg2.test(num.value)) {
		alert('创建失败')
		return;
	}

	alert('生成二维码成功，请在 D:/活动/活动二维码 中查看');
	subBox.submit();


}
	</script>
    </body>
</html>


