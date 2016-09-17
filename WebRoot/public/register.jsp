<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script src="${path}/js/jquery.mailAutoComplete-4.0.js" type="text/javascript"></script>
<div id="nav_arraw_main_container">
	<div id="nav_arraw_box_container">
		<div id="nav_arraw_box">
			<div id="nav_arraw_left_tips">
				<!-- 主页图标 -->
				<a href="${path}/servlet/IndexUIServlet" title="首页">
					<div id="nav_arraw_left_tips_one">
					</div>
				</a>
				<!-- 箭头图标 -->
				<div class="nav_arraw_left_tips_second">
				
				</div>
				<!-- 爱思论坛 文本 -->
				<a href="${path}/servlet/IndexUIServlet" title="首页">
				<div class="nav_arraw_text">
					爱思论坛
				</div>
				</a>
			</div>
			<div id="nav_arraw_right_tips">
				<!-- 箭头图标 -->
				<div class="nav_arraw_left_tips_second">
				
				</div>
				<div class="nav_arraw_text">
					注册表单
				</div>
			</div>
		</div>
	</div>
<div id="register_container_box">
		<form name="register_form" id="register_form"  onsubmit="return register()" method="post">
		<div id="register_container">
			<!-- 上面提醒信息 -->
			<div id="register_top" >
				<div class="top_left_tips">
					填写成为会员
				</div>
				<div class="top_right_tips">
					已有账号?按这登陆
				</div>
			</div>
			<!-- 下面注意内容盒子 -->
			<div id="register_main_messages">
				<div class="rfm" style="margin-top:30px;">
                          <div id="registerTip" style="width:99%;line-height:20px; ">欢迎您注册爱思论坛成为会员。		</div>
				</div>
				<!-- 1.用户名 -->
				<div class="userinfo_box">
					<div class="left_tips"><span style="color: red">*</span>用户名:</div>
					<div id="userName_container">
						<input id="username"  value="" name="userName" type="text" onblur="checkusername(this.value);"  required autocomplete="off" />
					</div>
					<div class="username_error_tips"></div>
				</div>	
				<!-- 2.密码 -->
				<div class="userinfo_box">
					<div class="left_tips"><span style="color: red">*</span>密码:</div>
					<div id="password_container">
						<input id="password"  value="" name="password" type="password" required autocomplete="off" />
					</div>
					<div class="password_error_tips"></div>
				</div>	
				<!-- 3.确认密码 -->
				<div class="userinfo_box">
					<div class="left_tips"><span style="color: red">*</span>确认密码:</div>
					<div id="confirm_password_container">
						<input id="password"  value="" name="confirmPassword" type="password" required autocomplete="off" />
					</div>
					<div class="confirm_password_error_tips"></div>
				</div>	
				<!-- 4.邮箱 -->
				<div class="userinfo_box">
					<div class="left_tips"><span style="color: red">*</span>邮箱:</div>
					<div id="email_container">
						<input id="email" class="inputMailList" autofocus value="" name="email" type="email" required autocomplete="off" />
					</div>
					<div class="email_error_tips"></div>
				</div>	
				<!-- 5.验证码 -->
				<div class="userinfo_box">
					<div class="left_tips"><span style="color: red">*</span>验证码:</div>
					<div id="verifyCode_container">
						<input id="verifyCode"  value="" name="verifyCode" type="text" required autocomplete="off" />
					</div>
					<div id="verifyCode_pic">
					   <img id="image" alt="换一张" style="cursor:pointer;"  onclick="changeImage(this)" src="/Forum/servlet/ImageFont">
					</div>
					<a onclick="changeImage2()" href="javascript:void(0)"><div id="chang_next">
						看不清,换一张
					</div></a>
					<div class="verify_error_tips"></div>
				</div>
				<!-- 注册按钮 -->
				<div id="submit_btn_box">
					<input id="submit_btn" type="submit" value="提交" />
				</div>	
			</div>
			
		</div>
		</form>
	</div>
	</div>