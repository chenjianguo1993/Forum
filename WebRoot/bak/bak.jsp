<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bak.jsp' starting page</title>
    
  </head>
  
  <body>

		<ul>
					<li class="a" id="mn_forum">
						<a href="#" hidefocus="true" title="首页">首页<span>首页</span></a>
					</li>
					<li id="mn_home">
						<a href="#" hidefocus="true" title="博客">博客<span>博客</span></a>
					</li>
					<li id="mn_N462e">
						<a href="#" hidefocus="true">每日签到</a>
					</li>
					<li id="mn_N230d">
						<a href="#" hidefocus="true">VIP转换</a>
					</li>
					<li id="mn_Nebca">
						<a href="#" hidefocus="true">赞助会员</a>
					</li>
					<li id="mn_N1f1d">
						<a href="#" hidefocus="true">版主推荐</a>
					</li>
					<li class="" initialized="true" id="mn_N8cb3" onmouseover="showMenu({'ctrlid':this.id,'ctrlclass':'hover','duration':2})">
						<a href="#" hidefocus="true">爱思特区/群组</a>
					</li>
					<li id="mn_N4680">
						<a href="#" hidefocus="true" style="color: red">唯思影城</a>
					</li>
					<li id="mn_N4329">
						<a href="#" hidefocus="true">爱思测试</a>
					</li>
				</ul>

  </body>
</html>
