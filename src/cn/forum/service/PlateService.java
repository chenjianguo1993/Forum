package cn.forum.service;

import java.sql.SQLException;
import java.util.List;

import cn.forum.domain.Page;
import cn.forum.domain.Plate;
import cn.forum.domain.User;

/**
 * 
 * ClassName: PlateDaoService
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public interface PlateService
{
	// 1.
	public abstract void addPlate(Plate plate);

	// 2.
	public abstract List<Plate> findAllPlates();

	// 3.根据id查找
	public abstract Plate findByPlateId(String plateId);

	// 4.根据plateType查找
	public abstract List<Plate> findByplateType(String plateType);

	// 5.分页获取版块数据
	public abstract Page getPlatesPageData(String pagenum, String url);

	// 7.修改
	public abstract void updatePlate(Plate plate);

	// 8.根据plateid删除
	public abstract void deleteByPlateId(String plateId);

}
