package cn.forum.dao;

import java.sql.SQLException;
import java.util.List;

import cn.forum.domain.Privilege;

/**
 * 
 * ClassName: PrivilegeDao
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public interface PrivilegeDao
{
	// 1.添加
	public void addPrivilege(Privilege privilege) throws SQLException;

	// 2.获取权限总记录数
	public int getTotalPrivilegesRecord() throws SQLException;

	// 3.获取权限分页数据
	public List<Privilege> getPageDate(int startindex, int pagesize)
			throws SQLException;

	// 4.根据id删除
	public void deleteByPrivilegeId(String privilegeId) throws SQLException;
}
