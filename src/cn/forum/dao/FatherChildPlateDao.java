package cn.forum.dao;

import java.sql.SQLException;
import java.util.List;

import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;

/**
 * 
 * ClassName: FatherChildPlateDao
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-12
 */
public interface FatherChildPlateDao
{
	// 1.创建
	public abstract void addFatherChildPlate(FartherChildPlate fartherChildPlate)
			throws SQLException;

	// 2.查最高的
	public abstract List<FartherChildPlate> findHighestPlates()
			throws SQLException;

	// 3.删除
	public abstract void deleteFatherPlateByChildId(String childPlateId)
			throws SQLException;

	// 4.根据父id删除
	public abstract void deleteByFatherId(String fatherPlateId)
			throws SQLException;

}
