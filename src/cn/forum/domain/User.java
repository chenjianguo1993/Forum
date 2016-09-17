package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ClassName: User
 * 
 * @Description: 用户实体
 * @author 陈建国
 * @date 2016-9-9
 */
public class User implements Serializable
{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 8286972789428403648L;
	private String userid;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String sex;
	private Date birthday;
	private String headimage;
	private Date createdate;
	private int signNum;//签到次数
	private int medal;//勋章
	private int money;//金钱
	private int prestige;//威望
	private int enable;//签到次数
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public String getHeadimage()
	{
		return headimage;
	}
	public void setHeadimage(String headimage)
	{
		this.headimage = headimage;
	}
	public Date getCreatedate()
	{
		return createdate;
	}
	public void setCreatedate(Date createdate)
	{
		this.createdate = createdate;
	}
	
	public int getSignNum()
	{
		return signNum;
	}
	public void setSignNum(int signNum)
	{
		this.signNum = signNum;
	}
	public int getMedal()
	{
		return medal;
	}
	public void setMedal(int medal)
	{
		this.medal = medal;
	}
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int money)
	{
		this.money = money;
	}
	public int getPrestige()
	{
		return prestige;
	}
	public void setPrestige(int prestige)
	{
		this.prestige = prestige;
	}
	public int getEnable()
	{
		return enable;
	}
	public void setEnable(int enable)
	{
		this.enable = enable;
	}
	
}
