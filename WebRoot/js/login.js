function login() {
	$.post("/Forum/servlet/LoginServlet", $("#login_form").serialize(),// 这是form的
	function(msg) {
		// 解析json数组，根据不同情况做不同回显或者操作
		var data = eval("(" + msg + ")");
		// alert(data);
		// 1.获取json数组长度
		var jsonarraylength = data.length;
		// 2.根据json数组的长度判断
		if (jsonarraylength == 2) {// 用户名和密码都为空
			// 将出错信息打印在登录表单下方
			$("#login_error_tips").text("用户名和密码不能为空,请重新输入！");
			$("#login_error_tips").css("fontSize", "12px");
			$("#login_error_tips").css("fontWeight", "bold");
			$("#login_error_tips").css("color", "red");
		}
		if (jsonarraylength == 1) {// 可能登录成功，也可能是登录失败
			var message = data[0].message;
			// 1.登录成功
			if (message == "success") {
				// 让进度条旋转一下
				window.location.href='/Forum/servlet/IndexUIServlet';
			}

			// 2.登录失败
			if (message == "usernameORpassword_wrong") {
				$("#login_error_tips").text("用户名或密码有误,请重新输入！");
				$("#login_error_tips").css("fontSize", "12px");
				$("#login_error_tips").css("fontWeight", "bold");
				$("#login_error_tips").css("color", "red");
			}
		}

	});
	return false;
}
// 退出登录
function logout() {
	$.post("/Forum/servlet/LogoutServlet", function(data) {
		// 重新加载
		// location.reload();
		window.location.href = "/Forum/servlet/IndexUIServlet";
	});
	return false;
}
