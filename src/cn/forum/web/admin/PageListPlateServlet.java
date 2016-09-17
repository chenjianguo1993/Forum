package cn.forum.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.forum.domain.Page;
import cn.forum.service.impl.PlateServiceImpl;

/**
 * 
 * ClassName: PageListPlateServlet
 * 
 * @Description: 分页展示所有的版块
 * @author 陈建国
 * @date 2016-9-14
 */
public class PageListPlateServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 1.获取页码，为下一次点击页码做准备
		String pageNum = request.getParameter("pagenum");
		// 2.获取链接
		String url = "/Forum/servlet/PageListPlateServlet";
		//
		PlateServiceImpl plateService = new PlateServiceImpl();
		Page platesPage = plateService.getPlatesPageData(pageNum, url);
		if (platesPage.getList().size() != 0)
		{
			// 有数据
			//存到域里面
			request.setAttribute("platesPage", platesPage);
			// 转发到相应的页面
			request.getRequestDispatcher(
					"/WEB-INF/jsps/admin/plate/pageListPlates.jsp").forward(
					request, response);
		} else
		{
			// 没有数据
			request.getRequestDispatcher("/public/tips.jsp").forward(request, response);
		}

	}

}
