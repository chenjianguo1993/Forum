package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ClassName: PrivilegeRole
 * 
 * @Description: 权限角色实体
 * @author 陈建国
 * @date 2016-9-17
 */
public class PrivilegeRole implements Serializable
{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7830129197045034896L;
	private String privilegeId;
	private String roleId;
	private Date createDate;
	private String userId;
	public String getPrivilegeId()
	{
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId)
	{
		this.privilegeId = privilegeId;
	}
	public String getRoleId()
	{
		return roleId;
	}
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
}
