package cn.forum.service;

import java.sql.SQLException;

import cn.forum.domain.Role;

/**
 * 
 * ClassName: RoleService
 * 
 * @Description: 
 * @author 陈建国
 * @date 2016-9-13
 */
public interface RoleService
{
	//1.添加角色
	public abstract void addRole(Role role);
	//2.
	public abstract Role findByRoleName(String roleName);
}
