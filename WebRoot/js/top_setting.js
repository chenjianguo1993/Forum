// 2.鼠标移动下拉和收缩
	$(document).ready(function() {
		$("#change_bg").mousemove(function() {
			$("#change_style_menu").slideDown().mouseleave(function() {
				$(this).slideUp()
			})
		})
	});



//3.点击改变背景图片
function changestyle(color){
	if(color=="red"){
		$(".bd").css("background","url(/Forum/images/bgimg_red.jpg) no-repeat 50% 0");
	}else if(color=="green"){
		$(".bd").css("background","url(/Forum/images/bgimg_green.jpg)no-repeat 50% 0");
	}else if(color=="yellow"){
		$(".bd").css("background","url(/Forum/images/bgimg_yellow.jpg) no-repeat 50% 0");
	}else if(color=="purple"){
		$(".bd").css("background","url(/Forum/images/bgimg_purple.jpg) no-repeat 50% 0");
	}else if(color=="blue"){
		$(".bd").css("background","url(/Forum/images/bgimg.jpg) no-repeat 50% 0");
	}
}

//切换后台管理页面
//转发到注册页面
function toadmin(){
	$.post("/Forum/servlet/AdminUIServlet",
			  function( data ) 
			  {
		 		//将这些数据切换div
				$("#nav_arraw_main_container").replaceWith(data);
			  }); 
	return false;
}



