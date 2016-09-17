<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	//1.先删除
	UE.delEditor('role_container');
	//2.再加载
	var ue = UE.getEditor('role_container', {
		//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个  
		toolbars : [ [ 'FullScreen', 'Source', 'Undo', 'Redo', 'bold', 'test',
				'indent', 'italic', 'underline', 'strikethrough', 'subscript',
				'fontborder', 'superscript', 'formatmatch', 'horizontal',
				'removeformat','fontfamily','fontsize','paragraph','imagecenter','backcolor','forecolor','emotion', 'print', ] ],
		//focus时自动清空初始化时的内容  
		autoClearinitialContent : true,
		//关闭字数统计  
		wordCount : true,
		//关闭elementPath  
		elementPathEnabled : false,
		//默认的编辑区域高度  
		initialFrameHeight : 300
	//更多其他参数，请参考ueditor.config.js中的配置项  
	});
	
//2.添加角色
function addplate(){
	//获取表单内容
	var content = ue.getContent();
	//获取添加角色名称
	var roleName = ue.getContentTxt();
	//两次url编码
	var encode_content =encodeURI(encodeURI(content));
	
	//解码decodeURI(test1);
	$.post("/Forum/servlet/AddRoleServlet?encode_content="+encode_content, $("#add_role_form").serialize(),// 这是form的
			// id
			function(msg) {
				// 解析json数组，根据不同情况做不同回显或者操作
				var data = eval("(" + msg + ")");
				//添加成功
				if(data.message=="success"){
					//存入成功之后
		 			$("#tips").text("成功添加"+roleName+"角色");
		 			$("#tips").css("display","block");
		 			$("#tips").css("background-color","#D8F9FE");
		 			$("#tips").css("color","#725B64");
					$("#tips").fadeIn(1000);
					$("#tips").fadeOut(6000);
				}else if(data.message=="failure"){
					$("#tips").text("添加失败");
		 			$("#tips").css("display","block");
		 			$("#tips").css("background-color","#D8F9FE");
		 			$("#tips").css("color","red");
					$("#tips").fadeIn(1000);
					$("#tips").fadeOut(8000);
				}
				
			});
			return false;
}
	
	
</script>

	<div  class="admin_main_under_right_message_bdy">
	<form id="add_role_form"  method="post" onsubmit="return addplate()">
		<script id="role_container" name="content" type="text/plain">
		请输入角色名称
    </script>
  
    
    <div id="addplate_submit">
    	<input type="submit" value="提交" />
    </div>
    </form>
	</div>
<!-- 提示 -->
<div id="tips" style="line-height:100px;;text-align:center;font-weight:bold;z-index:999;font-size:14px;display:none;width:200px;height:100px;position: absolute;margin-left: 400px;margin-top: 350px;"></div>








