package cn.forum.dao;

import java.sql.SQLException;

import cn.forum.domain.PrivilegeRole;

public interface PrivilegeRoleDao
{
	// 1.根据权限Id查询
	public PrivilegeRole findPrivilegeRoleByPrivilegeId(String privilegeId)
			throws SQLException;
}
