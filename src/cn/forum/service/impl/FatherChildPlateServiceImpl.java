package cn.forum.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.forum.dao.impl.FatherChildPlateDaoImpl;
import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;
import cn.forum.service.FatherChildPlateService;

/**
 * 
 * ClassName: FatherChildPlateServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-12
 */
public class FatherChildPlateServiceImpl implements FatherChildPlateService
{
	FatherChildPlateDaoImpl fatherChildPlateDao = new FatherChildPlateDaoImpl();

	// 1.
	@Override
	public void addFatherChildPlate(FartherChildPlate fartherChildPlate)
	{
		try
		{
			fatherChildPlateDao.addFatherChildPlate(fartherChildPlate);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 2.
	public List<FartherChildPlate> findHighestPlates()
	{

		try
		{
			return fatherChildPlateDao.findHighestPlates();
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 3.删除
	@Override
	public void deleteFatherPlateByChildId(String childPlateId)
	{
		try
		{
			fatherChildPlateDao.deleteFatherPlateByChildId(childPlateId);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	// 4.删除
	@Override
	public void deleteByFatherId(String fatherPlateId)
	{
		try
		{
			fatherChildPlateDao.deleteByFatherId(fatherPlateId);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
}
