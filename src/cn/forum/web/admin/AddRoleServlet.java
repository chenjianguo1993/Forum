package cn.forum.web.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.forum.domain.Role;
import cn.forum.domain.User;
import cn.forum.service.impl.RoleServiceImpl;
import cn.itcast.commons.CommonUtils;

/**
 * 
 * ClassName: AddRoleServlet
 * 
 * @Description: 添加角色
 * @author 陈建国
 * @date 2016-9-13
 */
public class AddRoleServlet extends HttpServlet
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
		User user = (User) request.getSession().getAttribute("user");
		// 获取该版块
		String encode_content = request.getParameter("encode_content");
		String decode_content = URLDecoder.decode(encode_content, "UTF-8");

		// 封装角色实体
		Role role = new Role();
		role.setRoleId(CommonUtils.uuid());
		role.setRoleName(decode_content);
		role.setCreateDate(new Date(System.currentTimeMillis()));
		role.setUserId(user.getUserid());
		// 存到数据库
		// 先查询该角色名是否存在，存在则不可以存进入，不存在就可以存进去
		RoleServiceImpl roleService = new RoleServiceImpl();
		Role findRole = roleService.findByRoleName(decode_content);
		if (findRole == null)
		{
			// 存
			roleService.addRole(role);
			json.put("message", "success");
		} else
		{
			json.put("message", "failure");
		}
		// 打回前端
		// 将json写回js
		out.write(json.toString());
		// 刷新缓存
		out.flush();
		// 关闭资源
		out.close();

	}

}
