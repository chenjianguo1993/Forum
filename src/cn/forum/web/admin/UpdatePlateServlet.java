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
import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;
import cn.forum.domain.User;
import cn.forum.service.impl.FatherChildPlateServiceImpl;
import cn.forum.service.impl.PlateServiceImpl;
import cn.itcast.commons.CommonUtils;

/**
 * 
 * ClassName: UpdatePlateServlet
 * 
 * @Description:修改版块
 * @author 陈建国
 * @date 2016-9-15
 */
public class UpdatePlateServlet extends HttpServlet
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
		//
		String plateId = request.getParameter("plateId");
		// 获取该版块
		String encode_content = request.getParameter("encode_content");
		String decode_content = URLDecoder.decode(encode_content, "UTF-8");
		// 获取父版块值(父版块id值)
		String fatherPlateId = request.getParameter("fatherPlate");
		//
		Plate plate = new Plate();
		plate.setPlateId(plateId);
		plate.setCreateDate(new Date(System.currentTimeMillis()));
		plate.setPlateName(decode_content);
		plate.setUserid(user.getUserid());
		if (!fatherPlateId.equalsIgnoreCase("root"))
		{
			//有父版块，
			plate.setPlateType("no_root");
			//
			FatherChildPlateServiceImpl fatherChildPlateServiceImpl = new FatherChildPlateServiceImpl();
			//现将该版块的父版块删除，再将新修改的存到表里面
			fatherChildPlateServiceImpl.deleteFatherPlateByChildId(plate.getPlateId());
			// 该版块有父版块，将它和父版块id存到中间表
			FartherChildPlate fatherChildPlate = new FartherChildPlate();
			fatherChildPlate.setFartherPlateId(fatherPlateId);
			fatherChildPlate.setChildPlateId(plate.getPlateId());
			fatherChildPlate
					.setCreateDate(new Date(System.currentTimeMillis()));
		
			fatherChildPlateServiceImpl.addFatherChildPlate(fatherChildPlate);
		}else
		{
			//该板块没有根结点，自己就是根结点
			plate.setPlateType("root");
		}
		
		//在数据库中修改
		PlateServiceImpl plateService = new PlateServiceImpl();
		plateService.updatePlate(plate);
		//
		json.put("message", "success");
		// 将json写回js
		out.write(json.toString());
		// 刷新缓存
		out.flush();
		// 关闭资源
		out.close();
		
		
	}

}
