package cn.forum.dao;

import java.sql.SQLException;

import cn.forum.domain.Plate;
import cn.forum.domain.User;

/**
 * 
 * ClassName: UserDao
 * 
 * @Description: 用户接口
 * @author 陈建国
 * @date 2016-9-9
 */
public interface UserDao
{
	//1.登陆方法
	public abstract User login(String userName,String password)throws SQLException;
	//2.注册方法
	public abstract void register(User user)throws SQLException;
	//3.
	public abstract User findByUserId(String userId) throws SQLException;
	
}
