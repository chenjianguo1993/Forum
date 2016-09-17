package cn.forum.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//记录当前在线人数（这是粗略计算，通过计算机当前该网站创建会话个数来计算当前在线使用网站人数）
public class OnlineCounterListener implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		//回话创建，人数++
		 OnlineCounter.raise(); 
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		//回话被销毁，人数--
		OnlineCounter.reduce();
	}

}
