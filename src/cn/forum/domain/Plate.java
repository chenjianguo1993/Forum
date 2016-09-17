package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * ClassName: Plate
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public class Plate implements Serializable
{

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1732566709450029728L;

	private String plateId;//版块id
	private String plateName;//版块名字
	private Date createDate;//创建时间
	private int  plateSequence;//版块序列，标识排版
	private int clickNum;//点击次数
	private String  plateType;//版块类型，根结点为root,
	//用户和版块是1对多关系
	private String userid;//对应用户
	//版块和子版块，1对多
	private List<Plate> plateList;
	
	//版块和用户，多对一
	User user = new User();
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public String getPlateType()
	{
		return plateType;
	}
	public void setPlateType(String plateType)
	{
		this.plateType = plateType;
	}
	public List<Plate> getPlateList()
	{
		return plateList;
	}
	public void setPlateList(List<Plate> plateList)
	{
		this.plateList = plateList;
	}
	public String getPlateId()
	{
		return plateId;
	}
	public void setPlateId(String plateId)
	{
		this.plateId = plateId;
	}
	public String getPlateName()
	{
		return plateName;
	}
	public void setPlateName(String plateName)
	{
		this.plateName = plateName;
	}
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public int getPlateSequence()
	{
		return plateSequence;
	}
	public void setPlateSequence(int plateSequence)
	{
		this.plateSequence = plateSequence;
	}
	public int getClickNum()
	{
		return clickNum;
	}
	public void setClickNum(int clickNum)
	{
		this.clickNum = clickNum;
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
