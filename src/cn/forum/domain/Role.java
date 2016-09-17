package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * ClassName: Role
 * 
 * @Description: 角色实体
 * @author 陈建国
 * @date 2016-9-13
 */
public class Role implements Serializable
{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 6703816514812921530L;
	
	private String roleId;
	private String roleName;
	private String userId;//创建用户的ID
	private Date createDate;
	
	
	
	//用户和角色，多对多
	private Set<User> userList = new HashSet<User>();
	//用户和权限，多对多
	private Set<Privilege> privilegeList = new HashSet<Privilege>();
	
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public Set<Privilege> getPrivilegeList()
	{
		return privilegeList;
	}
	public void setPrivilegeList(Set<Privilege> privilegeList)
	{
		this.privilegeList = privilegeList;
	}
	public String getRoleId()
	{
		return roleId;
	}
	public Set<User> getUserList()
	{
		return userList;
	}
	public void setUserList(Set<User> userList)
	{
		this.userList = userList;
	}
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}
	public String getRoleName()
	{
		return roleName;
	}
	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	
	
}
