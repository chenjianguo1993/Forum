package cn.forum.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.forum.dao.PrivilegeDao;
import cn.forum.domain.Plate;
import cn.forum.domain.Privilege;
import cn.forum.domain.Role;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 
 * ClassName: PrivilegeDaoImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public class PrivilegeDaoImpl implements PrivilegeDao
{
	private QueryRunner qr = new TxQueryRunner();

	// 1.添加
	public void addPrivilege(Privilege privilege) throws SQLException
	{
		String sql = "insert into t_privilege values(?,?,?,?,?)";
		Object[] params = { privilege.getPrivilegeId(),
				privilege.getPrivilegeName(), privilege.getPrivilegeUrl(),
				privilege.getCreateDate(), privilege.getUserId() };
		qr.update(sql, params);
	}

	// 2.获取权限总记录数
	public int getTotalPrivilegesRecord() throws SQLException
	{
		String sql = "select count(*) from t_privilege";
		Object params[] = {};
		Number number = (Number) qr.query(sql, new ScalarHandler(), params);
		return number.intValue();
	}

	// 3.获取权限分页数据
	public List<Privilege> getPageDate(int startindex, int pagesize)
			throws SQLException
	{
		String sql = "select * from t_privilege  order by createDate desc limit ?,?";
		Object[] params = { startindex, pagesize };
		return (List<Privilege>) qr.query(sql, new BeanListHandler(
				Privilege.class), params);
	}

	// 4.根据id删除
	public void deleteByPrivilegeId(String privilegeId) throws SQLException
	{
		String sql = "delete from t_privilege where privilegeId=?";
		Object[] params = { privilegeId };
		qr.update(sql, params);
	}

}
