package cn.forum.web.listener;

//网站当前在线人数
public class OnlineCounter
{
	//记录用户人数
	private static long online = 0;

	//返回当前在线人数
	public static long getOnline()
	{
		return online;
	}

	//人数++
	public static void raise()
	{
		online++;
	}
	//人数--
	public static void reduce()
	{
		online--;
	}
}
