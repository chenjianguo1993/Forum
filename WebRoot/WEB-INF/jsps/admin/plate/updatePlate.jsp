<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var ue = UE.getEditor('container', {
		//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个  
		toolbars : [ [ 'FullScreen', 'Source', 'Undo', 'Redo', 'bold', 'test',
				'indent', 'italic', 'underline', 'strikethrough', 'subscript',
				'fontborder', 'superscript', 'formatmatch', 'horizontal',
				'removeformat','fontfamily','fontsize','paragraph','imagecenter','backcolor','forecolor','emotion', 'print', ] ],
		//focus时自动清空初始化时的内容  
		autoClearinitialContent : true,
		//关闭字数统计  
		wordCount : false,
		//关闭elementPath  
		elementPathEnabled : false,
		//默认的编辑区域高度  
		initialFrameHeight : 300
	//更多其他参数，请参考ueditor.config.js中的配置项  
	});
	
//2.添加版块
function updatePlate(){
	//获取版块id
	var plateId =  $("#plateId").val();
	//获取表单内容
	var content = ue.getContent();
	//获取添加版块名称
	var plateName = ue.getContentTxt();
	//两次url编码
	var encode_content =encodeURI(encodeURI(content));
	//获取select中value的值--获取父版块id
	var fatherPlate=$("#sl_father_plate").val();
	
	//解码decodeURI(test1);
	$.post("/Forum/servlet/UpdatePlateServlet?encode_content="+encode_content+"&fatherPlate="+fatherPlate+"&plateId="+plateId, $("#update_plate_form").serialize(),// 这是form的
			// id
			function(msg) {
				// 解析json数组，根据不同情况做不同回显或者操作
				var data = eval("(" + msg + ")");
				//添加成功
				if(data.message=="success"){
					//存入成功之后
		 			$("#tips").text("成功修改"+plateName+"版块");
		 			$("#tips").css("display","block");
		 			$("#tips").css("background-color","#D8F9FE");
		 			$("#tips").css("color","#725B64");
					$("#tips").fadeIn(1000);
					$("#tips").fadeOut(6000);
				}else if(data.message=="failure"){
					$("#tips").text("修改失败");
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

	<div class="admin_main_under_right_message_bdy">
	<form id="update_plate_form" method="post" onsubmit="return updatePlate()">
		<script id="container" name="content" type="text/plain">
		${plate.plateName}
    </script>
    <div id="father_plate">
    	<select id="sl_father_plate">
    		<option selected="selected" value="root">--根结点--</option>
    		<!-- 迭代出来所有的版块 -->
    		<c:forEach var="plate" items="${plateList}">
    		<option value="${plate.plateId}">--${plate.plateName}--</option>
    		</c:forEach>
    	</select>
    	<!-- 隐藏一下版块id -->
    	<input id="plateId" type="hidden" value="${plate.plateId}" />
    </div>
    
    <div id="addplate_submit">
    	<input type="submit" value="提交" />
    </div>
    </form>
	</div>
<!-- 提示 -->
<div id="tips" style="line-height:100px;;text-align:center;font-weight:bold;z-index:999;font-size:14px;display:none;width:200px;height:100px;position: absolute;margin-left: 400px;margin-top: 350px;"></div>








