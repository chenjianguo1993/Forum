package cn.forum.service;

import java.sql.SQLException;
import java.util.List;

import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;

/**
 * 
 * ClassName: FatherChildPlateService
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-12
 */
public interface FatherChildPlateService
{
	// 1.创建
	public abstract void addFatherChildPlate(FartherChildPlate fartherChildPlate);

	// 2.查最高的
	public abstract List<FartherChildPlate> findHighestPlates();

	// 3.删除
	public abstract void deleteFatherPlateByChildId(String childPlateId);

	// 4.根据父id删除
	public abstract void deleteByFatherId(String fatherPlateId);

}
