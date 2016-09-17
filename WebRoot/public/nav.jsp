<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 2.logo和导航条 -->
<div id="logo_nav_container">
		<!-- 中间 -->
		<div class="logo_nav">
			<!-- logo -->
			<div class="logo">
				<!-- 左边 -->
				<div class="logo_left">
					<a href="${path}/servlet/IndexUIServlet" title="爱思论坛"><img
						src="${path}/images/nav/logo.png" alt="爱思论坛" border="0"> </a>
				</div>
				<!-- 右边 -->
				<div class="logo_right">
					<!-- 用户未登陆显示以下个人信息 -->
					<c:if test="${user==null}">
						<div class="login_container" >
							<form id="login_form" onsubmit="return login()" method="post">
								<table cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td><span class="ftid" style="margin-top: 5px;">
													<a initialized="true" href="javascript:;" id="ls_fastloginfield_ctrl" style="width:40px;font-size: 12px;color:#444" tabindex="900">用户名</a> </span></td>
											<td><input name="userName" id="ls_username" autocomplete="off" class="px vm" style="width:131px;height:23px;" tabindex="901" type="text">
											</td>
											<td class="fastlg_l"><label for="ls_cookietime"><input name="cookietime" id="ls_cookietime" class="pc" value="2592000" tabindex="903" style="margin-left: 4px;" type="checkbox"><span style="font-size: 12px">自动登陆</span> </label>
											</td>
											<td>&nbsp;<a href="javascript:;" onclick="showWindow('login', 'member.php?mod=logging&amp;action=login&amp;viewlostpw=1')" style="font-size: 12px;color:#333">找回密码</a>
											</td>
										</tr>
										<tr>
											<td><label for="ls_password" class="z psw_w" style="font-size: 12px;margin-top: 5px">密码</label>
											</td>
											<td><input name="password" id="ls_password" class="px vm" autocomplete="off" style="width:131px;height:23px;margin-top: 5px" tabindex="902" type="password">
											</td>
											<td class="fastlg_l"><input value="登陆" class="pn vm" tabindex="904" style="width: 63px;font-size: 12px;margin-left: 4px;margin-top: 4px" type="submit">
											</td>
											<td>&nbsp;<a href="#" onclick="return toRegister()" class="xi2 xw1" style="font-size: 12px;color:#369;font-weight: bold;">成为会员</a>
											</td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					
					</c:if>
					<!-- 用户登陆成功显示以下个人信息 -->
					<c:if test="${user!=null}">
					<!-- 头像 -->
					<div id="headimage_container">
						<img id="headimage" alt=""
							src="${path}/${user.headimage}">
					</div>
					<!-- 用户基本详细信息 -->
					<div id="user_info_container">
						<!-- 上面信息 -->
						<div class="user_info_over">
							<p>
								<strong class="vwmy"><a href="#" target="_blank"
									title="访问我的空间">${user.userName}</a>
								</strong> <span class="pipe">|</span><a href="#">设置</a> <span
									class="pipe">|</span><a href="#" id="pm_ntc">消息</a> <span
									class="pipe">|</span><a href="#" id="myprompt">提醒</a><span
									id="myprompt_check"></span> <span class="pipe">|</span><a
									href="#">门户管理</a> <span class="pipe">|</span><a href="#" onclick="return logout()">退出</a>
							</p>
						</div>
						<!-- 下面信息 -->
						<div class="user_info_under">
							<p>
								<a initialized="true" href="#" id="extcreditmenu"
									onmouseover="delayShow(this, showCreditmenu);" class="showmenu">金钱:
									${user.money}</a> <span class="pipe">|</span>用户组: <a initialized="true"
									href="#" id="g_upmine" class="xi2"
									onmouseover="delayShow(this, showUpgradeinfo)">幼儿生</a>
							</p>
						</div>
					</div>
					</c:if>
				</div>
			</div>
			<!-- 导航条 -->
			<div id="nv">
				<!-- 右边第一个 快捷菜单 -->
				<a class="" initialized="true" href="javascript:;" id="qmenu" onmouseover="showMenu({'ctrlid':'qmenu','pos':'34!','ctrlclass':'a','duration':2});">快捷导航</a>
			
			</div>
			<!-- 搜索框 -->
			<div id="scbar" class="c1">
				<form id="scbar_form" method="post" autocomplete="off" onsubmit="searchFocus($('scbar_txt'))" action="search.php?searchsubmit=yes" target="_blank">
					<input name="mod" id="scbar_mod" value="search" type="hidden">
					<input name="formhash" value="4d671856" type="hidden">
					<input name="srchtype" value="title" type="hidden">
					<input name="srhfid" value="" type="hidden">
					<input name="srhlocality" value="forum::index" type="hidden">
					<table cellpadding="0" cellspacing="0">
						<tbody><tr>
						<td class="scbar_icon_td"></td>
						<td class="scbar_txt_td"><input placeholder="请输入搜索內容" class=" xg1" name="srchtxt" id="scbar_txt" value="请输入搜索內容" autocomplete="off" x-webkit-speech="" speech="" type="text"></td>
						<td class="scbar_type_td"><a href="javascript:;" id="scbar_type" class="showmenu xg1 xs2" onclick="showMenu(this.id)" hidefocus="true">搜索</a></td>
						<td class="scbar_btn_td"><button type="submit" name="searchsubmit" id="scbar_btn" sc="1" class="pn pnc" value="true"><strong class="xi2 xs2" style="color:#235994;">搜索</strong></button></td>
						<td class="scbar_hot_td">
						<div id="scbar_hot">
						</div>
						</td>
						</tr>
						</tbody>
					</table>
					</form>
			</div>
		
		</div>
	</div>


