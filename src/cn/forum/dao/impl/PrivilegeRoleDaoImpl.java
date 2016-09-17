package cn.forum.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.forum.dao.PrivilegeRoleDao;
import cn.forum.domain.Plate;
import cn.forum.domain.PrivilegeRole;
import cn.itcast.jdbc.TxQueryRunner;

public class PrivilegeRoleDaoImpl implements PrivilegeRoleDao
{
	private QueryRunner qr = new TxQueryRunner();

	// 1.根据权限Id查询
	public PrivilegeRole findPrivilegeRoleByPrivilegeId(String privilegeId) throws SQLException
	{
		String sql = "select * from t_privilege_role where privilegeId=?";
		Object params[] = { privilegeId };
		return qr.query(sql, new BeanHandler<PrivilegeRole>(PrivilegeRole.class), params);
	}
}
