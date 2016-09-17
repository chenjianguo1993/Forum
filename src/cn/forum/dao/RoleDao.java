package cn.forum.dao;

import java.sql.SQLException;

import cn.forum.domain.Role;

/**
 * 
 * ClassName: RoleDao
 * 
 * @Description: 角色Dao
 * @author 陈建国
 * @date 2016-9-13
 */
public interface RoleDao
{
	//1.添加角色
	public abstract void addRole(Role role)throws SQLException;
	// 2.按名查询
	public abstract Role findByRoleName(String roleName)throws SQLException;
}
