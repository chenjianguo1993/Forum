package cn.forum.service;

import java.sql.SQLException;

import cn.forum.domain.User;

/**
 * 
 * ClassName: UserService
 * 
 * @Description: 用户服务
 * @author 陈建国
 * @date 2016-9-9
 */
public interface UserService
{
	//1.用户登陆
	public abstract User login(String userName,String password);
	
	public abstract void register(User user);
}
