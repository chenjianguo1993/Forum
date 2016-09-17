package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ClassName: Sign
 * 
 * @Description: 签到实体
 * @author 陈建国
 * @date 2016-9-9
 */
public class Sign implements Serializable
{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7405925518409618289L;
	private String signid;
	private Date signdate;
	private String feel;//心情
	private String userid;
	public String getSignid()
	{
		return signid;
	}
	public void setSignid(String signid)
	{
		this.signid = signid;
	}
	public Date getSigndate()
	{
		return signdate;
	}
	public void setSigndate(Date signdate)
	{
		this.signdate = signdate;
	}
	public String getFeel()
	{
		return feel;
	}
	public void setFeel(String feel)
	{
		this.feel = feel;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	
}
