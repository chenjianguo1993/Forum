<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 树形结构 -->
<link href="${path}/css/jquery.lightTreeview.css" rel="stylesheet" type="text/css">
<!-- 树形结构 -->
<script language="javascript" src="${path}/js/jquery.lightTreeview.pack.js"></script>
<script language="javascript" src="${path}/js/jquery.lightTreeview.js"></script>
<!-- 该页面涉及的js操作文件 -->
<script language="javascript" src="${path}/js/admin.js"></script>
<script type="text/javascript">
	//树形结构	
$(function() {
		$('#system_manager_menu').lightTreeview({
			collapse: true,
			line: true,
			nodeEvent: true,
			unique: true,
			style: 'black',
			fileico: true,
			animate: 400,
			folderico: true
		});
	});
</script>



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
				<!-- 箭头图标 -->
				<div class="nav_arraw_left_tips_second">
				
				</div>
				<div class="nav_arraw_text">
					后台管理
				</div>
			</div>
		</div>
	</div>
	
	<!-- 主体部分 -->
	<div id="main_container_box">
		<div id="main_container">
			<div class="top_tips">
				<div class="top_left_tips">
				后台管理区
				</div>
				<div class="top_right_tips">
					欢迎管理员:admin
				</div>
			</div>
			<!-- 主体部分 -->
			<div id="admin_main_under_info">
				<!-- 左边菜单 -->
				<div id="admin_main_under_left_menu">
					<!-- 加一个div 使居中 -->
					<div style="margin-left: 20px;margin-top: 15px;">
					<ul id="system_manager_menu" class="lightTreeview treeview-black">
		
						<li><div class="treeview-file">后台管理菜单</div></li>
						<!-- 用户管理 -->
						<li>
							<div class="treeview-folder">用户管理</div>
							<ol>
								<!-- 用户管理 -->
								<li>
									<div class="treeview-folder">版主管理</div>
									<ul style="display:none">
										<li><div class="treeview-file"><a class="system_manager_menu_a" style="text-decoration:none;" href="#">创建用户</a></div></li>
										<li><div class="treeview-file"><a class="system_manager_menu_a" style="text-decoration:none;" href="#">批量创建</a></div></li>
										<li><div class="treeview-file">列表展示</div></li>
										
									</ul>
								</li>
								<!-- 普通用户管理 -->
								<li>
									<div class="treeview-folder">游客管理</div>
									<ul style="display:none">
										<li><div class="treeview-file"><a class="system_manager_menu_a" style="text-decoration:none;" href="${pageContext.request.contextPath }/servlet/Add_NurseUIServlet"  target="system_manager_default_main">创建护士</a></div></li>
										<li><div class="treeview-file"><a class="system_manager_menu_a" style="text-decoration:none;" href="${pageContext.request.contextPath }/servlet/ClassifyNurse_ByDepartment_UIServlet" target="system_manager_default_main">按科室分类</a></div></li>
										<li><div class="treeview-file">分配权限</div></li>
										
									</ul>
								</li>
								
								<li><div class="treeview-file">待定</div></li>
								<li><div class="treeview-file">待定</div></li>
							</ol>
						</li>
						<!-- 角色管理 -->
						<li>
							<div class="treeview-folder">角色管理</div>
							<ul style="display:none">
								<li><div class="treeview-file"><a style="text-decoration:none;" href="#" onclick="return toaddrole()">创建角色</a></div></li>
								<li><div class="treeview-file"><a style="text-decoration:none;" href="#" onclick="return tolistallrole()">分页展示</a></div></li>
								<li><div class="treeview-file">待定</div></li>
							</ul>
						</li>
						<!-- 权限管理 -->
						<li>
							<div class="treeview-folder">权限管理</div>
							<ul style="display:none">
								<li><div class="treeview-file"><a style="text-decoration:none;" href="#" onclick="return toaddprivilege()">创建权限</a></div></li>
								<li><div class="treeview-file"><a style="text-decoration:none;" href="#" onclick="return pagelistprivilege()">权限展示</a></div></li>
								<li><div class="treeview-file">待定</div></li>
							</ul>
						</li>
						<!-- 版块管理 -->
						<li>
							<div class="treeview-folder">版块管理</div>
							<ul style="display:none">
								<li><div class="treeview-file"><a href="#" title="创建版块" onclick="return toaddplate()">创建版块</a></div></li>
								<li><div class="treeview-file"><a href="#" title="版块展示" onclick="return pagelistplate()">版块展示</a></div></li>
								<li><div class="treeview-file">待定</div></li>
							</ul>
						</li>
						<li><div class="treeview-file"><a class="system_manager_menu_a" onclick="parent.location.href='${path }/servlet/IndexUIServlet'">返回首页 </a></div></li>
					</ul>
					</div>
				</div>
				<!--右边内容 -->
				<div id="admin_main_under_right_message">
					<!-- 右边具体放的内容 -->
					<div class="admin_main_under_right_message_bdy">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>