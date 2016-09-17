//注册表单的js
//这是jquery里的,是当文档载入完毕就执行,的意思

//转发到注册页面
function toRegister(){
	$.post("/Forum/servlet/RegisterUIServlet",
			  function( data ) 
			  {
		 		//将这些数据切换div
				$("#nav_arraw_main_container").replaceWith(data);
			  }); 
	return false;
}

//中文验证码切换
function changeImage(img) {
	img.src = img.src + "?" + new Date().getTime();
}
// 中文验证码切换
function changeImage2() {
	var img = document.getElementById("image");
	img.src = img.src + "?" + new Date().getTime();
}

//注册
function register() {
	$.post("/Forum/servlet/RegisterServlet", $("#register_form").serialize(),// 这是form的
	// id
	function(msg) {
		// 解析json数组，根据不同情况做不同回显或者操作
		var data = eval("(" + msg + ")");
		// alert(data);
		var tips
		[ 4 ];
		// 1.获取json数组长度
		var jsonarraylength = data.length;
		// 2.根据json数组的长度判断
		if (jsonarraylength > 2) {// 肯定是有错误的，遍历出来，看是哪一个错误，将出错信息打印在登录表单下方
			for (i = 0; i < jsonarraylength; i++) {
				// 分别获取出这些出错信息先
				if (data[i] == "null_input_username") {
					$(".username_error_tips").text("用户名不能为空,请重新输入！");
					$(".username_error_tips").css("fontSize", "12px");
					$(".username_error_tips").css("fontWeight", "bold");
					$(".username_error_tips").css("color", "red");
				} else if (data[i] == "null_input_password") {
					$(".password_error_tips").text("密码不能为空,请重新输入！");
					$(".password_error_tips").css("fontSize", "12px");
					$(".password_error_tips").css("fontWeight", "bold");
					$(".password_error_tips").css("color", "red");
				} else if (data[i] == "passwordnotequal2") {
					$(".confirm_password_error_tips").text("密码和确认密码不匹配,请重新输入！");
					$(".confirm_password_error_tips").css("fontSize", "12px");
					$(".confirm_password_error_tips").css("fontWeight", "bold");
					$(".confirm_password_error_tips").css("color", "red");
				} else if (data[i] == "null_input_email") {
					$(".email_error_tips").text("邮箱不能为空,请重新输入！");
					$(".email_error_tips").css("fontSize", "12px");
					$(".email_error_tips").css("fontWeight", "bold");
					$(".email_error_tips").css("color", "red");
				} else if (data[i] == "verifycodenotequal") {
					$(".verify_error_tips").text("检验码不匹配,请重新输入！");
					$(".verify_error_tips").css("fontSize", "12px");
					$(".verify_error_tips").css("fontWeight", "bold");
					$(".verify_error_tips").css("color", "red");
				}

			}
		}
		if (jsonarraylength == 1) {// 可能登录成功，也可能是登录失败
			var message = data[0].message;
			// 1.登录成功
			if (message == "success") {
				//准备做一个旋转的进度条
				window.location.href = '/Forum/servlet/IndexUIServlet';
			}else if(message=="user_exist"){
				$(".username_error_tips").text("用户名已存在,请更改用户名重新注册！");
				$(".username_error_tips").css("fontSize", "12px");
				$(".username_error_tips").css("fontWeight", "bold");
				$(".username_error_tips").css("color", "red");
			}
			
		}

	});
	return false;
}