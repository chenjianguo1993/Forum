package cn.forum.service.impl;

import java.sql.SQLException;

import cn.forum.dao.impl.RoleDaoImpl;
import cn.forum.domain.Role;
import cn.forum.service.RoleService;

/**
 * 
 * ClassName: RoleServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public class RoleServiceImpl implements RoleService
{
	RoleDaoImpl roleDao = new RoleDaoImpl();

	// 1.添加
	@Override
	public void addRole(Role role)
	{
		try
		{
			roleDao.addRole(role);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 2.按名查询
	public Role findByRoleName(String roleName)
	{
		try
		{
			return roleDao.findByRoleName(roleName);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		
	}

}
