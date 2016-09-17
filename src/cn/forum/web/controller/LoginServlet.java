package cn.forum.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.forum.domain.User;
import cn.forum.service.UserService;
import cn.forum.service.impl.UserServiceImpl;
import cn.forum.utils.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
 * ClassName: LoginServlet
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-9
 */
public class LoginServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
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
				User user = WebUtils.request2Bean(request, User.class);
				// 1.判断表单提交的数据是否有数据输入，若为空，打回信息提醒
				if (user.getUserName() == null)
				{
					json.put("message", "null_input_username");
					jsonarray.add(json);
				}
				if (user.getPassword() == null)
				{
					json.put("message", "null_input_password");
					jsonarray.add(json);
				}
				if (user.getUserName() != null && user.getPassword() != null)
				{
					UserServiceImpl userservice = new UserServiceImpl();
					// 把用用户名和密码到数据库查一下
					User login_user = userservice.login(user.getUserName(), user.getPassword());
					// 判断从数据库中根据用户名和密码查询结果是否为空
					if (login_user == null)
					{
						// 查找不到，用户名或密码出错
						json.put("message", "usernameORpassword_wrong");
						jsonarray.add(json);
					} else
					{
						// 查找到，成功登录
						json.put("message", "success");
						jsonarray.add(json);
						request.getSession().setAttribute("user", login_user);
						//request.getRequestDispatcher("/index.jsp").forward(request, response);
					}

				}
				// 将json写回js
				out.write(jsonarray.toString());
				// 刷新缓存
				out.flush();
				// 关闭资源
				out.close();
	}

}
