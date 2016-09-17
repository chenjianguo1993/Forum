package cn.forum.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.forum.domain.Plate;
import cn.forum.service.impl.PlateServiceImpl;

/**
 * 
 * ClassName: ToUpdatePlateServlet
 * 
 * @Description: 
 * @author 陈建国
 * @date 2016-9-15
 */
public class ToUpdatePlateServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//获取该版块信息，展示在提交表单上面
		String plateId = request.getParameter("plateId");
		//
		PlateServiceImpl plateService = new PlateServiceImpl();
		Plate plate = plateService.findByPlateId(plateId);
		request.setAttribute("plate", plate);
		//
		//
		List<Plate> highestPlatesList = new ArrayList<Plate>();
		highestPlatesList = plateService.findByplateType("root");
		request.getSession().setAttribute("plateList", highestPlatesList);
		
		//
		request.getRequestDispatcher("/WEB-INF/jsps/admin/plate/updatePlate.jsp")
		.forward(request, response);
	}

}
