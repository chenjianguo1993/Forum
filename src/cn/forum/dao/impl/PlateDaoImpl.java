package cn.forum.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.forum.dao.PlateDao;
import cn.forum.domain.Plate;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 
 * ClassName: PlateDaoImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-11
 */
public class PlateDaoImpl implements PlateDao
{
	private QueryRunner qr = new TxQueryRunner();

	// 1.添加版块
	@Override
	public void addPlate(Plate plate) throws SQLException
	{
		String sql = "insert into t_plate (plateId,plateName,createDate,plateSequence,clickNum,plateType,userid) values(?,?,?,?,?,?,?)";
		Object[] params = { plate.getPlateId(), plate.getPlateName(),
				plate.getCreateDate(), plate.getPlateSequence(),
				plate.getClickNum(), plate.getPlateType(), plate.getUserid() };
		qr.update(sql, params);
	}

	// 2.查所有
	public List<Plate> findAllPlates() throws SQLException
	{
		String sql = "select * from t_plate order by createDate";
		Object[] params = {};
		return (List<Plate>) qr.query(sql, new BeanListHandler(Plate.class),
				params);
	}

	// 3.根据id查找
	public Plate findByPlateId(String plateId) throws SQLException
	{
		String sql = "select * from t_plate where plateId=?";
		Object params[] = { plateId };
		return qr.query(sql, new BeanHandler<Plate>(Plate.class), params);
	}

	// 4.根据plateType查找
	public List<Plate> findByplateType(String plateType) throws SQLException
	{
		String sql = "select * from t_plate where plateType=?";
		Object params[] = { plateType };
		return (List<Plate>) qr.query(sql, new BeanListHandler(Plate.class),
				params);
	}

	// 5.获取版块总记录数
	public int getTotalPlatesRecord() throws SQLException
	{
		String sql = "select count(*) from t_plate";
		Object params[] = {};
		Number number = (Number) qr.query(sql, new ScalarHandler(), params);
		return number.intValue();
	}

	// 6.获取版块分页数据
	public List<Plate> getPageDate(int startindex, int pagesize)
			throws SQLException
	{
		String sql = "select * from t_plate  order by createDate desc limit ?,?";
		Object[] params = { startindex, pagesize };
		return (List<Plate>) qr.query(sql, new BeanListHandler(Plate.class),
				params);
	}

	// 7.修改
	public void updatePlate(Plate plate) throws SQLException
	{
		String sql = "update t_plate set plateName=?,createDate=?,plateType=?,userid=? where plateId=?";
		Object[] params = { plate.getPlateName(), plate.getCreateDate(),
				plate.getPlateType(), plate.getUserid(), plate.getPlateId() };
		qr.update(sql, params);
	}

	// 8.根据plateid删除
	public void deleteByPlateId(String plateId) throws SQLException
	{
		String sql = "delete from t_plate where plateId=?";
		Object[] params = { plateId };
		qr.update(sql, params);
	}

}
