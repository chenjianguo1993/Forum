package cn.forum.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.forum.dao.RoleDao;
import cn.forum.domain.Role;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 
 * ClassName: RoleDaoImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public class RoleDaoImpl implements RoleDao
{
	private QueryRunner qr = new TxQueryRunner();

	// 1.添加
	public void addRole(Role role) throws SQLException
	{
		String sql = "insert into t_role values(?,?,?,?)";
		Object[] params = { role.getRoleId(), role.getRoleName(),
				role.getCreateDate(), role.getUserId() };
		qr.update(sql, params);
	}

	// 2.按名查询
	public Role findByRoleName(String roleName) throws SQLException
	{
		String sql="select * from t_role where roleName=?";
		Object params[]={roleName};
		return qr.query(sql, new BeanHandler<Role>(Role.class), params);
	}

}
