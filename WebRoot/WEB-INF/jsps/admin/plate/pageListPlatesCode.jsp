<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 当前第[${platesPage.pagenum }]页&nbsp;&nbsp;&nbsp;
    
    <c:if test="${platesPage.pagenum>1}">
    <a href="#" onclick="return topagecode('${platesPage.pagenum-1 }')" >上一页</a>
    </c:if>
    &nbsp;
	<c:forEach var="pagenum" begin="${platesPage.startPage}" end="${platesPage.endPage}">
		[<a  href="#" onclick="return topagecode('${pagenum}')">${pagenum }</a>]
	</c:forEach>  
	&nbsp;
	
	<c:if test="${platesPage.pagenum<platesPage.totalpage}">
	<a href="#" onclick="return topagecode('${platesPage.pagenum+1}')">下一页</a>
	</c:if>
	
	&nbsp;&nbsp;&nbsp;
	共[${platesPage.totalpage }]页,共[${platesPage.totalrecord}]纪录,
	
	<input type="text" style="width: 30px" id="pagenum">
	<input type="button" value=" GO " onclick="goWhich(document.getElementById('pagenum'))">
	
	<script type="text/javascript">
		function goWhich(input){
			var pagenum = input.value;
			if(pagenum==null || pagenum==""){
				alert("请输入页码！");
				return;
			}
			
			if(!pagenum.match("\\d+")){
				alert("请输入数字！");
				input.value="";
				return;
			}
			
			if(pagenum<1 || pagenum>${platesPage.totalpage}){
				alert("无效的页码！");
				input.value="";
				return;
			}
			//发请求到后台
				$.post("/Forum/servlet/PageListPlateServlet?pagenum="+ pagenum, $("#add_plate_form").serialize(),// 这是form的
				// id
				function(data) {
				// 替换
				$("#listPlates").replaceWith(data);
			});
		}
	</script>
