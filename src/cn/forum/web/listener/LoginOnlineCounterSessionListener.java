package cn.forum.web.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.forum.domain.User;

//记录当前登录在线人数
public class LoginOnlineCounterSessionListener implements HttpSessionAttributeListener
{
	// 上下文对象，用来保存当前保存用户的list 
    ServletContext servletContext; 
	public final static String LISTENER_NAME = "user";
	private static HashMap hashUserName = new HashMap();
	private Object lock = new Object();
	
	//在session中添加对象时触发此操作 笼统的说就是调用setAttribute这个方法时候会触发的
	public void attributeAdded(HttpSessionBindingEvent se)
	{
		servletContext = se.getSession().getServletContext();
		// 此处可能会发生线程安全问题
		synchronized (lock)
		{
			if (LISTENER_NAME.equals(se.getName()))
			{

				User user = (User) se.getValue();
				hashUserName.put(user.getUserid(), se.getSession());

			}
		}
		servletContext.setAttribute("list", hashUserName);  
	}
	//修改、删除session中添加对象时触发此操作  笼统的说就是调用 removeAttribute这个方法时候会触发的
	public void attributeRemoved(HttpSessionBindingEvent se)
	{
		synchronized (lock)
		{
			if (LISTENER_NAME.equals(se.getName()))
			{
				User user = (User) se.getValue();
				hashUserName.remove(user.getUserid());
			}
		}
	}
	//在Session属性被重新设置时
	public void attributeReplaced(HttpSessionBindingEvent se)
	{
	}

	public static boolean isOnline(HttpSession session) throws Exception
	{
		return hashUserName.containsValue(session);
	}

	public static boolean isLogining(String Userid) throws Exception
	{
		return hashUserName.containsKey(Userid);
	}

	public static HttpSession getsession(String userid)
	{
		return (HttpSession) hashUserName.get(userid);
	}

	// 统计当前登录在线人数
	public static int getOnlineNumber()
	{
		return hashUserName.size();
	}

}
