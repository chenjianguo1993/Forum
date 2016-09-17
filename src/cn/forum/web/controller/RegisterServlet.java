package cn.forum.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.forum.domain.RegisterForm;
import cn.forum.domain.User;
import cn.forum.service.impl.UserServiceImpl;
import cn.forum.utils.WebUtils;
import cn.itcast.commons.CommonUtils;

/**
 * 
 * ClassName: RegisterServlet
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-10
 */
public class RegisterServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		StringBuffer verifycode =  (StringBuffer) request.getSession().getAttribute("sb");
		// 设置防止乱码
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		// out为下面将json数据返回客户端做准备
		PrintWriter out = response.getWriter();
		// 单个JSON对象
		JSONObject json = new JSONObject();
		// 实例化一个json数组
		JSONArray jsonarray = new JSONArray();
		// 获取表单封装数据
		RegisterForm registerForm = WebUtils.request2Bean(request,
				RegisterForm.class);
		// 1.做后台校验
		// trim()剪切掉字符串首尾的空格，中间的空格没有剪切掉
		if (registerForm.getPassword().trim().equalsIgnoreCase(""))
		{
			json.put("message", "null_input_username");
			jsonarray.add(json);
		}
		if (registerForm.getPassword().trim().equalsIgnoreCase(""))
		{
			json.put("message", "null_input_password");
			jsonarray.add(json);
		}
		if (!registerForm.getPassword().trim()
				.equalsIgnoreCase(registerForm.getConfirmPassword().trim()))
		{
			json.put("message", "passwordnotequal2");
			jsonarray.add(json);
		}
		if (registerForm.getEmail().trim()==null)
		{
			json.put("message", "null_input_email");
			jsonarray.add(json);
		}
		if (!registerForm.getVerifyCode().equalsIgnoreCase(verifycode.toString()))
		{
			json.put("message", "verifycodenotequal");
			jsonarray.add(json);
		}
		//检验该用户是否已经注册，只判断用户名和密码组合是否存在，存在就打回俩个数据
		UserServiceImpl userservice = new UserServiceImpl();
		User check_user = new User();
		check_user.setUserName(registerForm.getUserName());
		check_user.setPassword(registerForm.getPassword());
		User verify_user = userservice.login(check_user.getUserName(), check_user.getPassword());
		if(verify_user!=null)
		{
			json.put("message", "user_exist");
			jsonarray.add(json);
		}
		
		if (jsonarray.size() == 0)
		{
			User user = new User();
			// 说明校验都正确，注册到数据库
			// 1.1准备好一些默认数据封装到实体
			user.setUserid(CommonUtils.uuid());
			user.setBirthday(new Date(System.currentTimeMillis()));
			user.setCreatedate(new Date(System.currentTimeMillis()));
			//产生1-10的随机数，将其对于的图片作为用户头像
			Random random = new Random();
			//以后想改就改这里好了
			//int i = random.nextInt(10);
			user.setHeadimage("images/default_headimage.gif");
			user.setEnable(1);
			// 1.2准备好表单带过来数据封装到实体
			user.setUserName(registerForm.getUserName());
			user.setPassword(registerForm.getPassword());
			user.setEmail(registerForm.getEmail());
			// 1.3存到数据库
			userservice.register(user);
			//将用户存到session域里面
			request.getSession().setAttribute("user", user);
			json.put("message", "success");
			jsonarray.add(json);
		}
		// 将json写回js
		out.write(jsonarray.toString());
		// 刷新缓存
		out.flush();
		// 关闭资源
		out.close();
	}

}
