package cn.forum.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.forum.dao.UserDao;
import cn.forum.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

/**
 * 
 * ClassName: UserDaoImpl
 * 
 * @Description: 用户dao
 * @author 陈建国
 * @date 2016-9-9
 */
public class UserDaoImpl implements UserDao
{
	private QueryRunner qr = new TxQueryRunner();

	@Override
	public User login(String userName, String password) throws SQLException
	{
		String sql = "select * from t_user where username=? and password=?";
		Object params[] = { userName, password };
		return qr.query(sql, new BeanHandler<User>(User.class), params);
	}

	// 2.注册方法
	@Override
	public void register(User user) throws SQLException
	{
		String sql = "insert into t_user (userid,username,password,email,phone,sex,birthday,headimage,createdate,signnum,medal,money,prestige,enable) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = { user.getUserid(), user.getUserName(),
				user.getPassword(), user.getEmail(), user.getPhone(),
				user.getSex(), user.getBirthday(), user.getHeadimage(),
				user.getCreatedate(), user.getSignNum(), user.getMedal(),
				user.getMoney(), user.getPrestige(), user.getEnable() };
		qr.update(sql, params);
	}

	@Override
	public User findByUserId(String userId) throws SQLException
	{
		String sql = "select * from t_user where userId=?";
		Object params[] = {userId};
		return qr.query(sql, new BeanHandler<User>(User.class), params);
	}

	// 3.根据userId获取用户信息

}
