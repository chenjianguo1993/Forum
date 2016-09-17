<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 顶部 -->
<div class="top_setting">
	<div class="top_container">
		<!-- 左边内容 -->
		<div class="top_setting_left">
			<a href="#">设置首页</a> <a href="#">收藏本站</a>
			<!-- 系统当前时间 -->
			<div id="clock"></div>
		</div>
		<!-- 右边内容 -->
		<div class="top_setting_right">
			<div id="change_bg" class="change_bg">
				<img style="margin-top:3px;" src="${path}/images/style_switch.png" />
			</div>
			<div class="line_num">当前在线人数:&nbsp;3&nbsp;人</div>
			<!-- 如果是系统管理员，显示进入后台 -->
			<c:if test="${user.userName=='admin'}">
			<a href="#" onclick="return toadmin()"><div class="access_admin_plate">
				后台管理
			</div></a>
			</c:if>
		</div>

	</div>
</div>
