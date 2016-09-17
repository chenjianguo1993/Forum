package cn.forum.dao;

import java.sql.SQLException;
import java.util.List;

import cn.forum.domain.Plate;
import cn.forum.domain.User;

/**
 * 
 * ClassName: PlateDao
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public interface PlateDao
{
	// 1.创建版块
	public abstract void addPlate(Plate plate) throws SQLException;

	// 2.
	public abstract List<Plate> findAllPlates() throws SQLException;

	// 3.根据id查找
	public abstract Plate findByPlateId(String plateId) throws SQLException;

	// 4.根据plateType查找
	public abstract List<Plate> findByplateType(String plateType)
			throws SQLException;

	// 5.获取版块总记录数
	public int getTotalPlatesRecord() throws SQLException;

	// 6.获取版块分页数据
	public abstract List<Plate> getPageDate(int startindex, int pagesize)
			throws SQLException;

	// 7.修改
	public abstract void updatePlate(Plate plate) throws SQLException;

	// 8.根据plateid删除
	public abstract void deleteByPlateId(String plateId) throws SQLException;
}
