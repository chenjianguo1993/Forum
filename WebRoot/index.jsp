<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	application.setAttribute("path", path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>爱思论坛-首页</title>
<!-- 修改网站顶部图标 -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<!-- CSS -->
<link href="${path}/css/index.css" rel="stylesheet" type="text/css">
<link href="${path}/css/top_setting.css" rel="stylesheet"
	type="text/css">
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/logo_nav.css" rel="stylesheet" type="text/css">
<link href="${path}/css/register.css" rel="stylesheet" type="text/css">
<link href="${path}/css/nav_arraw.css" rel="stylesheet" type="text/css">
<link href="${path}/css/admin.css" rel="stylesheet" type="text/css">

<!-- JS -->
<!-- 导入公共的js -->
<%@ include file="/public/common.jspf"%>
<script src="${path}/js/top_setting.js" type="text/javascript"></script>
<script src="${path}/js/clock.js" type="text/javascript"></script>
<script src="${path}/js/login.js" type="text/javascript"></script>
<script src="${path}/js/register.js" type="text/javascript"></script>

<!-- 导入ue的包 -->
<script type="text/javascript" src="${path}/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${path}/js/ueditor/ueditor.all.js"></script>
</head>

<body class="bd">
	<!-- 1.顶部设置页面 -->
	<%@ include file="/public/top_setting.jsp"%>
	<!-- 顶部设置页面 -->
	<!-- 2.logo和导航条 -->
	<%@ include file="/public/nav.jsp"%>
	<!-- logo和导航条 -->
	<!-- 3.导航箭头 -->
	<div id="nav_arraw_main_container">
	<div id="nav_arraw_box_container">
		<div id="nav_arraw_box">
			<div id="nav_arraw_left_tips">
				<!-- 主页图标 -->
				<a href="${path}/servlet/IndexUIServlet" title="首页">
					<div id="nav_arraw_left_tips_one">
					</div>
				</a>
				<!-- 箭头图标 -->
				<div class="nav_arraw_left_tips_second">
				
				</div>
				<!-- 爱思论坛 文本 -->
				<a href="${path}/servlet/IndexUIServlet" title="首页">
				<div class="nav_arraw_text">
					爱思论坛
				</div>
				</a>
			</div>
			<div id="nav_arraw_right_tips">
				
			</div>
		</div>
	</div>
	
	<!-- 主体部分 -->
	<div id="main_container_box">
		<div id="main_container">
			
		</div>
	</div>
	</div>
	<!-- 页脚 -->
	<%@ include file="/public/footer.jsp"%>
	<!-- 页脚 -->
	<!-- 下来菜单 -->
	<div id="change_style_menu">
		<a onclick="changestyle('red')" href="#"><span style="background:#BA350F" class="change_style_menu_btn" title="红"></span></a>
		<a onclick="changestyle('green')" href="#"><span style="background:#429296" class="change_style_menu_btn" title="青"></span></a>
		<a onclick="changestyle('blue')" href="#"><span style="background:#0053B9" class="change_style_menu_btn" title="蓝"></span></a>
		<a onclick="changestyle('purple')" href="#"><span style="background:#9934B7" class="change_style_menu_btn" title="紫"></span></a>
		<a onclick="changestyle('yellow')" href="#"><span style="background:#FE9500" class="change_style_menu_btn" title="橙"></span></a>
	</div>

</body>
</html>
