package cn.forum.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * ClassName: IndexUIServlet
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-9
 */
public class IndexUIServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
