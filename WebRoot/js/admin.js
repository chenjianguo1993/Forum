/***********************版块***********************/

//1.切换添加版块表单
function toaddplate(){
	$.post("/Forum/servlet/ToAddPlateServlet",
			  function( data ) 
			  {
		 		//将这些数据切换div
				$(".admin_main_under_right_message_bdy").replaceWith(data);
			  }); 
	return false;
}


//4.分页展示版块信息
function pagelistplate(){
	$.post("/Forum/servlet/PageListPlateServlet",
			function( data ) 
			{
		//将这些数据切换div
		$(".admin_main_under_right_message_bdy").replaceWith(data);
			}); 
	return false;
}
//修改版块
function toupdateplate(plateId){
	$.post("/Forum/servlet/ToUpdatePlateServlet?plateId="+plateId,
			function( data ) 
			{
		//将这些数据切换div
		$("#listPlates").replaceWith(data);
			}); 
	return false;
}
/************************权限*****************************/
//1.切换添加权限表单
function toaddprivilege(){
	$.post("/Forum/servlet/ToAddPrivilegeServlet",
			function( data ) 
			{
		//将这些数据切换div
		$(".admin_main_under_right_message_bdy").replaceWith(data);
			}); 
	return false;
}

//2.分页展示权限
function pagelistprivilege(){
	$.post("/Forum/servlet/PageListPrivilegesServlet",
			function( data ) 
			{
		//将这些数据切换div
		$(".admin_main_under_right_message_bdy").replaceWith(data);
			}); 
	return false;
}
//按照页码来的
function toprivilegecode(pagenum) {
	$.post("/Forum/servlet/PageListPrivilegesServlet?pagenum="+ pagenum,// 这是form的
	// id
	function(data) {
		// 替换
		$(".admin_main_under_right_message_bdy").replaceWith(data);
	});
	return false;
}




/************************角色********************************/
//2.切换添加角色表单
function toaddrole(){
	$.post("/Forum/servlet/ToAddRoleServlet",
			function( data ) 
			{
		//将这些数据切换div
		$(".admin_main_under_right_message_bdy").replaceWith(data);
			}); 
	return false;
}

