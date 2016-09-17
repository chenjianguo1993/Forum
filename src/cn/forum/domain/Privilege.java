package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * ClassName: Privilege
 * 
 * @Description: 权限实体
 * @author 陈建国
 * @date 2016-9-13
 */
public class Privilege implements Serializable
{
	
    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3412326617394884912L;
	private	String privilegeId; 
    private	String privilegeName; 
    private	String privilegeUrl; 
    private	Date createDate; 
    private	String userId; 
    //权限和角色，多对多
    Set<Role> roleList = new HashSet<Role>();
    //权限和用户，多对一
    User user = new User();
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public String getPrivilegeId()
	{
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId)
	{
		this.privilegeId = privilegeId;
	}
	public String getPrivilegeName()
	{
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName)
	{
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeUrl()
	{
		return privilegeUrl;
	}
	public void setPrivilegeUrl(String privilegeUrl)
	{
		this.privilegeUrl = privilegeUrl;
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
	public Set<Role> getRoleList()
	{
		return roleList;
	}
	public void setRoleList(Set<Role> roleList)
	{
		this.roleList = roleList;
	}
}
