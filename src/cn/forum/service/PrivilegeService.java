package cn.forum.service;

import java.sql.SQLException;

import cn.forum.domain.Page;
import cn.forum.domain.Privilege;

/**
 * 
 * ClassName: PrivilegeService
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-13
 */
public interface PrivilegeService
{
	// 1.添加
	public abstract void addPrivilege(Privilege privilege);

	// 2.分页展示权限
	public Page getPrivilegesPageData(String pagenum, String url);

	// 3.根据id删除
	public void deleteByPrivilegeId(String privilegeId);
}
