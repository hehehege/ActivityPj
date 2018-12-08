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
  String teaname=(String)request.getSession().getAttribute("teaname");
  String classid=(String)request.getAttribute("classidIsNull");
  %>
  <div>你好，流彬 </div>
  <base target="_self" href="<%=basePath %>" /> 
</header>

<div class="am-cf admin-main" >
  <!-- sidebar start -->
  <div class="admin-sidebar">
   <form name="form1" method="post" id="myform1">
    <ul class="am-list admin-sidebar-list">
     
      <li><a href="stuLookActivity.do" ><span class="am-icon-pencil-square-o"></span> 查看活动</a></li>
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
<div class="admin-content">

  
     		
   	</div>
  
  </div>
  <!-- sidebar end -->

  <!-- content start -->
    <div class="am-g"  >
      <div class="am-u-sm-12">
       
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

    </body>
</html>


