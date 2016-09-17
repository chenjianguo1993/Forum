package cn.forum.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.forum.dao.impl.PrivilegeDaoImpl;
import cn.forum.dao.impl.UserDaoImpl;
import cn.forum.domain.Page;
import cn.forum.domain.Plate;
import cn.forum.domain.Privilege;
import cn.forum.domain.User;
import cn.forum.service.PrivilegeService;

/**
 * 
 * ClassName: PrivilegeServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public class PrivilegeServiceImpl implements PrivilegeService
{
	PrivilegeDaoImpl privilegeDao = new PrivilegeDaoImpl();
	UserDaoImpl userDao = new UserDaoImpl();

	// 1.
	@Override
	public void addPrivilege(Privilege privilege)
	{
		try
		{
			privilegeDao.addPrivilege(privilege);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 2.分页展示权限
	public Page getPrivilegesPageData(String pageNum, String url)
	{
		// 1、从数据库获取所有的版块，为在进一步的封装准备
		List<Privilege> list = new ArrayList<Privilege>();
		List<Privilege> getUserList = new ArrayList<Privilege>();
		try
		{
			// 2.获取所用权限的总记录数
			int totalrecord = privilegeDao.getTotalPrivilegesRecord();
			// 3.定义一个分页，为返回做准备
			Page page = null;
			// 4.判断当前的页码，为点击分页的其他页码做准备
			if (pageNum == null)
			{
				page = new Page(1, totalrecord);
			} else
			{
				page = new Page(Integer.parseInt(pageNum), totalrecord);
			}
			// 5.从数据库拿出当前访问页码的权限记录
			list = privilegeDao.getPageDate(page.getStartindex(),
					page.getPagesize());
			for (Privilege privilege : list)
			{
				User user = userDao.findByUserId(privilege.getUserId());
				privilege.setUser(user);
				getUserList.add(privilege);
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

	@Override
	public void deleteByPrivilegeId(String privilegeId)
	{
		try
		{
			privilegeDao.deleteByPrivilegeId(privilegeId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
