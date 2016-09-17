package cn.forum.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.forum.dao.FatherChildPlateDao;
import cn.forum.domain.FartherChildPlate;
import cn.forum.domain.Plate;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 
 * ClassName: FatherChildPlateDaoImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-12
 */
public class FatherChildPlateDaoImpl implements FatherChildPlateDao
{
	private QueryRunner qr = new TxQueryRunner();

	// 1.
	@Override
	public void addFatherChildPlate(FartherChildPlate fartherChildPlate)
			throws SQLException
	{
		String sql = "insert into t_fatherchildplate (fartherPlateId,childPlateId,createDate) values(?,?,?)";
		Object[] params = { fartherChildPlate.getFartherPlateId(),
				fartherChildPlate.getChildPlateId(),
				fartherChildPlate.getCreateDate() };
		qr.update(sql, params);
	}

	// 2.查所有
	public List<FartherChildPlate> findHighestPlates() throws SQLException
	{
		String sql = "select * from t_fatherchildplate group by fartherPlateId;";
		Object[] params = {};
		return (List<FartherChildPlate>) qr.query(sql, new BeanListHandler(FartherChildPlate.class),
				params);
	}
	//3.根据子id删除
	public void deleteFatherPlateByChildId(String childPlateId)
			throws SQLException
	{
		String sql = "delete from t_fatherchildplate where childPlateId=?";
		Object[] params = { childPlateId};
		qr.update(sql, params);
	}
	//4.根据父id删除
	public void deleteByFatherId(String fatherPlateId)
			throws SQLException
	{
		String sql = "delete from t_fatherchildplate where fartherPlateId=?";
		Object[] params = { fatherPlateId};
		qr.update(sql, params);
	}
}
