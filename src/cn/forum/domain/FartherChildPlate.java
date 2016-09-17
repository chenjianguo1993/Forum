package cn.forum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ClassName: FartherChildPlate
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-12
 */
public class FartherChildPlate implements Serializable
{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8812238922418858732L;
	private String fartherPlateId;
	private String childPlateId;
	private Date createDate;
	
	public Date getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public String getFartherPlateId()
	{
		return fartherPlateId;
	}
	public void setFartherPlateId(String fartherPlateId)
	{
		this.fartherPlateId = fartherPlateId;
	}
	public String getChildPlateId()
	{
		return childPlateId;
	}
	public void setChildPlateId(String childPlateId)
	{
		this.childPlateId = childPlateId;
	}
	
}
