package cn.forum.service;

import java.sql.SQLException;

import cn.forum.domain.PrivilegeRole;

/**
 * 
 * ClassName: PrivilegeRoleService
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-17
 */
public interface PrivilegeRoleService
{
	// 1.根据权限Id查询
	public PrivilegeRole findPrivilegeRoleByPrivilegeId(String privilegeId);
}
