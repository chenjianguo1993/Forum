package cn.forum.web.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;
import cn.forum.service.impl.FatherChildPlateServiceImpl;
import cn.forum.service.impl.PlateServiceImpl;

/**
 * 
 * ClassName: ToAddPlateServlet
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public class ToAddPlateServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 获取当前所有的一级版块出来的版块
		PlateServiceImpl plateService = new PlateServiceImpl();
		//
		List<Plate> highestPlatesList = new ArrayList<Plate>();
		highestPlatesList = plateService.findByplateType("root");
		request.getSession().setAttribute("plateList", highestPlatesList);
		request.getRequestDispatcher("/WEB-INF/jsps/admin/plate/addPlate.jsp")
				.forward(request, response);
	}

}
