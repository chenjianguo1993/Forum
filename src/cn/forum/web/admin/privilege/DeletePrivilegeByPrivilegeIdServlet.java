package cn.forum.web.admin.privilege;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.forum.domain.Page;
import cn.forum.domain.PrivilegeRole;
import cn.forum.service.impl.PrivilegeRoleServiceImpl;
import cn.forum.service.impl.PrivilegeServiceImpl;

/**
 * 
 * ClassName: DeletePrivilegeByPrivilegeIdServlet
 * 
 * @Description: 删除权限
 * @author 陈建国
 * @date 2016-9-17
 */
public class DeletePrivilegeByPrivilegeIdServlet extends HttpServlet
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
		// 1.获取页码，为下一次点击页码做准备
		String pageNum = request.getParameter("pagenum");
		// 获取版块id
		String privilegeId = request.getParameter("privilegeId");
		// 2.获取链接
		String url = "/Forum/servlet/PageListPrivilegesServlet";

		PrivilegeServiceImpl privilegeService = new PrivilegeServiceImpl();
		PrivilegeRoleServiceImpl privilegeRoleService = new PrivilegeRoleServiceImpl();

		// 查询该权限是否已经分配给了角色
		PrivilegeRole privilegeRole = privilegeRoleService
				.findPrivilegeRoleByPrivilegeId(privilegeId);
		if (privilegeRole != null)
		{
			// 不为空，已经分配给了角色
			// 写一个失败的json回去
			//json.put("message", "failure");
			// 将json写回js
			//out.write(json.toString());
			//转发到一个提示页面，提示先解除角色再删除
			

		} else
		{
			// 写一个成功的json回去
			//json.put("message", "success");
			//out.write(json.toString());
			// 为空，还没有分配给角色，可以删除
			privilegeService.deleteByPrivilegeId(privilegeId);
			// 获取分页数据
			Page privilegePage = privilegeService.getPrivilegesPageData(
					pageNum, url);
			if (privilegePage.getList().size() != 0)
			{
				// 不为空
				// 存到域里面
				request.setAttribute("privilegePage", privilegePage);
				// 转发到相应的页面
				request.getRequestDispatcher(
						"/WEB-INF/jsps/admin/privilege/pageListPrivileges.jsp")
						.forward(request, response);
			} else
			{
				// 没有数据，转发到提示页面
				request.getRequestDispatcher("/public/tips.jsp").forward(
						request, response);
			}
		}
		// 刷新缓存
		//out.flush();
		// 关闭资源
		//out.close();

	}

}
