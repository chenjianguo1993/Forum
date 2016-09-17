package cn.forum.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @Title: CharacterEncodingFilter.java
 * 
 * @Package cn.holiday.sheme.web.filter
 * 
 * @Description: 字符编码过滤器
 * 
 * @author 陈建国
 * 
 * @date 2015-5-7 上午11:11:56
 * 
 * @version V1.0
 */
public class CharacterEncodingFilter implements Filter
{

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException
	{

		//1.获取request和response请求
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		chain.doFilter(new MyRequest(request), response);

	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	public void destroy()
	{
		// TODO Auto-generated method stub

	}
}

/** 解决get请求的乱码问题 **/
class MyRequest extends HttpServletRequestWrapper
{
	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request)
	{
		super(request);
		this.request = request;

	}

	public String getParameter(String name)
	{

		String value = this.request.getParameter(name);
		if (value == null)
		{
			return null;
		}
		if (!this.request.getMethod().equalsIgnoreCase("get"))
		{
			return value;
		}
		try
		{
			//中间传输时采用iso8859-1，所有先用iso8859-1编码一下，在用utf-8解码一下
			value = new String(value.getBytes("iso8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
		return value;
	}

}
