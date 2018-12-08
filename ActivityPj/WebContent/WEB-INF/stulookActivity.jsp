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
      <li><a href="javascript:;"><span class="updatePwd"> 修改密码</span>  <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <a href="updatePassword.do"><span class="updatePwd"></span> 修改密码</a>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
  <%String stuUsername=(String)request.getSession().getAttribute("stuUsername"); 
  String stuname=(String)request.getSession().getAttribute("stuname");
  
  %>
  <div>你好,<%=stuname %></div>
  <base target="_self" href="<%=basePath %>" /> 
</header>

<div class="am-cf admin-main" >
  <!-- sidebar start -->
  <div class="admin-sidebar">
   <form name="form1" method="post" id="myform1">
    <ul class="am-list admin-sidebar-list">
      
      <li><a href="stulookActivity.do" ><span class="am-icon-pencil-square-o"></span> 查看活动</a></li>
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
	      
	      	<span>活动学分:</span>
	      	<i>*示例：1.0</i>
	      	<input class="ex-num" type="text" name="actXueFen">
	      </p>
	      <p>
	      	<span>活动形式:</span>
	      	<i>选择生成观众/参赛者二维码 </i>
	      	<div style="clear:both;"></div>
	      	<div class='ex-inputBox'>
	      		<input class="ex-date" type="radio" name="radios" value="观众">观众
	      		<input class="ex-date" type="radio" name="radios" value="参与者" style="margin-left: 30px;">参与者
	      	</div>
	      	
	      </p>
	      <div style="clear:both;"></div>
	      <input class="am-btn am-btn-primary ex-sub" type="button" value="生成二维码">
	    </form>
	  </div>
	</div>

   <div class="admin-content">
  <div class="am-g"  >
      <div class="am-u-sm-12">
        <table class="am-table am-table-bd am-table-striped admin-content-table"  id="lookHomeWork" >
          <thead>
          <tr>
            <th>活动名字</th><th>活动时间</th><th>活动学分</th><th>活动形式</th>
          </tr>
          </thead>
          <tbody>
         <c:forEach items="${listActivity }" var="list" varStatus="status">
			<tr
				<c:if test="${status.index%2!=0}">style='background-color:#ECF6EE;'</c:if>>
				<td>${list.actname }</td>
				<td>${list.acttime }</td>
				<td>${list.actxuefen }</td>
				<td>${list.acttype }</td>
			</tr>

		</c:forEach>

          </tbody>
        </table>
      </div>
    </div>


  
     		
   	</div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
 
   
   	
	  <script src="resources/js/s/jquery.min.js"></script>
  <script src="resources/js/s/amazeui.min.js"></script>
 
  <script src="resources/js/s/app.js"></script>
  <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="resources/js/s/polyfill/rem.min.js"></script>
<script src="resources/js/s/polyfill/respond.min.js"></script>
<script src="resources/js/s/amazeui.legacy.js"></script>
<script src="resources/js/Manager.js" ></script>
<script src="resources/js/stulookActivity.js" ></script>

    </body>
</html>


