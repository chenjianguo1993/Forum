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
import cn.forum.domain.Privilege;
import cn.forum.domain.User;
import cn.forum.service.impl.PrivilegeServiceImpl;
import cn.itcast.commons.CommonUtils;

/**
 * 
 * ClassName: AddPrivilegeServlet
 * 
 * @Description: 添加权限
 * @author 陈建国
 * @date 2016-9-13
 */
public class AddPrivilegeServlet extends HttpServlet
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
		// 获取该权限名字
		String encode_content = request.getParameter("encode_content");
		String decode_content = URLDecoder.decode(encode_content, "UTF-8");
		// 获取资源对应的路径
		String pUrl = request.getParameter("purl");
		// 封装实体
		Privilege privilege = new Privilege();
		privilege.setPrivilegeId(CommonUtils.uuid());
		privilege.setPrivilegeName(decode_content);
		privilege.setPrivilegeUrl(pUrl);
		privilege.setCreateDate(new Date(System.currentTimeMillis()));
		privilege.setUserId(user.getUserid());
		//
		PrivilegeServiceImpl privilegeService = new PrivilegeServiceImpl();
		privilegeService.addPrivilege(privilege);
		json.put("message", "success");
		// 将json写回js
		out.write(json.toString());
		// 刷新缓存
		out.flush();
		// 关闭资源
		out.close();

	}

}
