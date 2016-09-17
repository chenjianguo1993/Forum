package cn.forum.service.impl;

import java.sql.SQLException;

import cn.forum.dao.impl.PrivilegeRoleDaoImpl;
import cn.forum.domain.PrivilegeRole;
import cn.forum.service.PrivilegeRoleService;

/**
 * 
 * ClassName: PrivilegeRoleServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-17
 */
public class PrivilegeRoleServiceImpl implements PrivilegeRoleService
{
	PrivilegeRoleDaoImpl privilegeRoleDao = new PrivilegeRoleDaoImpl();
	
	//1.
	@Override
	public PrivilegeRole findPrivilegeRoleByPrivilegeId(String privilegeId)
	{
		try
		{
			return privilegeRoleDao.findPrivilegeRoleByPrivilegeId(privilegeId);
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
