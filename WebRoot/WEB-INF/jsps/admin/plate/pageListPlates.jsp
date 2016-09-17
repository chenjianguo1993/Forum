<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">

	//按照页码来的
	function topagecode(pagenum) {
		$.post("/Forum/servlet/PageListPlateServlet?pagenum="+ pagenum,// 这是form的
		// id
		function(data) {
			// 替换
			$(".admin_main_under_right_message_bdy").replaceWith(data);
		});
		return false;
	}
	//删除
	function deleteplate(plateId){
	    var pagenum =${platesPage.pagenum};
		$.post("/Forum/servlet/DeletePlateByPlateIdServlet?pagenum="+ pagenum+"&plateId="+plateId,// 这是form的
		// id
		function(data) {
			// 替换
			$(".admin_main_under_right_message_bdy").replaceWith(data);
		});
		return false;
		
	}
	
</script>
<div id="listPlates" class="admin_main_under_right_message_bdy">
	<table
		style="width:670px;height:320px;margin-left: 10px;margin-top: 10px;">
		<tr style="width:670px;height:48px;border: 1px solid black;background: #cccccc;">
			<td>版块名称</td>
			<td>版块类型</td>
			<td>版块序列</td>
			<td>创建时间</td>
			<td>创建用户</td>
			<td>访问量</td>
			<td>操作</td>
		</tr>
		<c:forEach var="plate" items="${platesPage.list}">
			<tr>
				<td>${plate.plateName}</td>
				<td>${plate.plateType}</td>
				<td>${plate.plateSequence}</td>
				<td>${plate.createDate}</td>
				<td>${plate.user.userName}</td>
				<td>${plate.clickNum}</td>
				<td><a href="#" onclick="return toupdateplate('${plate.plateId}')">修改</a>&nbsp;&nbsp;<a href="#" onclick="return deleteplate('${plate.plateId}')">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<!-- 页码 -->
	<div id="page_code" style=";font-size:16px;;width:700px;height:36px;margin: auto">
		&nbsp;&nbsp;&nbsp;<%@ include file="/WEB-INF/jsps/admin/plate/pageListPlatesCode.jsp"%>
	</div>
</div>










