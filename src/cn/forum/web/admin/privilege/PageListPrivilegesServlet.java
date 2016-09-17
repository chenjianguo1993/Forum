package cn.forum.web.admin.privilege;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.forum.domain.Page;
import cn.forum.service.impl.PrivilegeServiceImpl;

/**
 * 
 * ClassName: PageListPrivilegesServlet
 * 
 * @Description: 分页展示
 * @author 陈建国
 * @date 2016-9-17
 */
public class PageListPrivilegesServlet extends HttpServlet
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
		String url = "/Forum/servlet/PageListPrivilegesServlet";
		PrivilegeServiceImpl privilegeService = new PrivilegeServiceImpl();
		Page privilegePage = privilegeService.getPrivilegesPageData(pageNum,
				url);

		// 判断是否为空
		if (privilegePage.getList().size() != 0)
		{
			// 不为空
			// 存到域里面
			request.setAttribute("privilegePage", privilegePage);
			// 转发到相应的页面
			request.getRequestDispatcher(
					"/WEB-INF/jsps/admin/privilege/pageListPrivileges.jsp").forward(
					request, response);
		}else
		{
			//没有数据，转发到提示页面
			request.getRequestDispatcher(
					"/public/tips.jsp").forward(
					request, response);
		}

	}

}
