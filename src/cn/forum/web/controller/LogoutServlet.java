package cn.forum.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * ClassName: LogoutServlet
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-9
 */
public class LogoutServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getSession().removeAttribute("user");
		// 重定向到网站的首页
		response.sendRedirect("/Forum/servlet/IndexUIServlet");
	}

}
