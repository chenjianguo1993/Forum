package cn.forum.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.forum.dao.impl.PlateDaoImpl;
import cn.forum.dao.impl.UserDaoImpl;
import cn.forum.domain.Page;
import cn.forum.domain.Plate;
import cn.forum.domain.User;
import cn.forum.service.PlateService;

/**
 * 
 * ClassName: PlateServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public class PlateServiceImpl implements PlateService
{
	PlateDaoImpl plateDao = new PlateDaoImpl();
	UserDaoImpl userDao = new UserDaoImpl();

	// 1.
	@Override
	public void addPlate(Plate plate)
	{
		try
		{
			plateDao.addPlate(plate);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 2.
	public List<Plate> findAllPlates()
	{
		try
		{
			return plateDao.findAllPlates();
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 3.
	@Override
	public Plate findByPlateId(String plateId)
	{
		try
		{
			return plateDao.findByPlateId(plateId);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 4.
	@Override
	public List<Plate> findByplateType(String plateType)
	{
		try
		{
			return plateDao.findByplateType(plateType);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 5.分页获取版块数据
	public Page getPlatesPageData(String pagenum, String url)
	{
		// 1、从数据库获取所有的版块，为在进一步的封装准备
		List<Plate> list = new ArrayList<Plate>();
		List<Plate> getUserList = new ArrayList<Plate>();

		try
		{
			// 2.获取所用版块的总记录数
			int totalrecord = plateDao.getTotalPlatesRecord();
			// 3.定义一个分页，为返回做准备
			Page page = null;

			// 4.判断当前的页码，为点击分页的其他页码做准备
			if (pagenum == null)
			{
				page = new Page(1, totalrecord);
			} else
			{
				page = new Page(Integer.parseInt(pagenum), totalrecord);
			}
			// 5.从数据库拿出当前访问页码的版块记录
			list = plateDao.getPageDate(page.getStartindex(),
					page.getPagesize());
			// 遍历list，获取对应的创建它的用户封装到版块里面
			for (Plate plate : list)
			{
				User user = userDao.findByUserId(plate.getUserid());
				plate.setUser(user);
				getUserList.add(plate);
			}

			page.setList(getUserList);
			page.setUrl(url);
			return page;
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	// 6.修改
	@Override
	public void updatePlate(Plate plate)
	{
		try
		{
			plateDao.updatePlate(plate);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//8.删除
	@Override
	public void deleteByPlateId(String plateId)
	{
		try
		{
			plateDao.deleteByPlateId(plateId);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

}
