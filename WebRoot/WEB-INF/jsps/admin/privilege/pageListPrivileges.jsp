<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

	//删除
	function deleteprivilege(privilegeId){
	    var pagenum =${privilegePage.pagenum};
	    alert("删除;当前页码"+pagenum);
		$.post("/Forum/servlet/DeletePrivilegeByPrivilegeIdServlet?pagenum="+ pagenum+"&privilegeId="+privilegeId,// 这是form的
		// id
		function(data) {
			var change_data = data;
			//解析json
			//var msg = eval("(" + data + ")");
			/**if(msg.message=="failure"){
				alert("该权限已分配角色,请解除再执行");
			}else{
			//alert("替换数据");
				//还没有分配,成功删除
				// 替换
			
			}**/
			$(".admin_main_under_right_message_bdy").replaceWith(change_data);
		});
		return false;
		
	}
	
</script>
<div class="admin_main_under_right_message_bdy">
	<table
		style="width:670px;height:320px;margin-left: 10px;margin-top: 10px;">
		<tr
			style="width:670px;height:48px;border: 1px solid black;background: #cccccc;">
			<td>权限名称</td>
			<td>资源路径</td>
			<td>创建时间</td>
			<td>创建用户</td>
			<td>操作</td>
		</tr>
		<c:forEach var="privilege" items="${privilegePage.list}">
			<tr>
				<td>${privilege.privilegeName}</td>
				<td>${privilege.privilegeUrl}</td>
				<td>${privilege.createDate}</td>
				<td>${privilege.user.userName}</td>
				<td><a href="#"
					onclick="return toupdateprivilege('${privilege.privilegeId}')">修改</a>&nbsp;&nbsp;<a
					href="#" onclick="return deleteprivilege('${privilege.privilegeId}')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<!-- 页码 -->
	<div id="page_code"
		style=";font-size:16px;;width:700px;height:36px;margin: auto">
		&nbsp;&nbsp;&nbsp;<%@ include
			file="/WEB-INF/jsps/admin/privilege/pageListPrivilegesCode.jsp"%>
	</div>
</div>










