package cn.forum.service.impl;

import java.sql.SQLException;

import cn.forum.dao.impl.UserDaoImpl;
import cn.forum.domain.User;
import cn.forum.service.UserService;

/**
 * 
 * ClassName: UserServiceImpl
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-9
 */
public class UserServiceImpl implements UserService
{
	UserDaoImpl userdao = new UserDaoImpl();

	@Override
	public User login(String userName, String password)
	{
		try
		{
			return userdao.login(userName, password);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public void register(User user)
	{
		try
		{
			userdao.register(user);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}

}
