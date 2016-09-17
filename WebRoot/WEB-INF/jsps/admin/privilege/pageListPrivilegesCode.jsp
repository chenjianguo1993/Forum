<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 当前第[${privilegePage.pagenum }]页&nbsp;&nbsp;&nbsp;
    
    <c:if test="${privilegePage.pagenum>1}">
    <a href="#" onclick="return toprivilegecode('${privilegePage.pagenum-1 }')" >上一页</a>
    </c:if>
    &nbsp;
	<c:forEach var="pagenum" begin="${privilegePage.startPage}" end="${privilegePage.endPage}">
		[<a  href="#" onclick="return toprivilegecode('${pagenum}')">${pagenum }</a>]
	</c:forEach>  
	&nbsp;
	
	<c:if test="${privilegePage.pagenum<privilegePage.totalpage}">
	<a href="#" onclick="return toprivilegecode('${privilegePage.pagenum+1}')">下一页</a>
	</c:if>
	
	&nbsp;&nbsp;&nbsp;
	共[${privilegePage.totalpage }]页,共[${privilegePage.totalrecord}]纪录,
	
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
			
			if(pagenum<1 || pagenum>${privilegePage.totalpage}){
				alert("无效的页码！");
				input.value="";
				return;
			}
			//发请求到后台
				$.post("/Forum/servlet/PageListPrivilegesServlet?pagenum="+ pagenum,
				
				function(data) {
				// 替换
				$(".admin_main_under_right_message_bdy").replaceWith(data);
			});
		}
	</script>
