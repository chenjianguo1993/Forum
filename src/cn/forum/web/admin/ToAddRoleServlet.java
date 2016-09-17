package cn.forum.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * ClassName: ToAddRoleServlet
 * 
 * @Description: 添加角色界面
 * @author 陈建国
 * @date 2016-9-13
 */
public class ToAddRoleServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/jsps/admin/role/addRole.jsp").forward(request, response);
	}

}
