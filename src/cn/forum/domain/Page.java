package cn.forum.domain;

import java.util.List;

/**
 * 分页实体
 * ClassName: Page
 * 
 * @Description:
 * @author 陈建国
 * @date 2015-3-16
 */
public class Page
{

	private int totalpage; // 记住总页数
	private int pagesize = 6; // 页面大小

	private int totalrecord; // 总记录数
	private int pagenum; // 记住当前页

	private int startindex; // 记住用户想看的页的数据从哪个地方开始取

	private List list; // 记住页面数据

	private int startPage;
	private int endPage;

	private String url; // 记住用于处理分页的servlet

	public Page(int pagenum, int totalrecord)
	{
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;

		// 算出总页数
		this.totalpage = (this.totalrecord + this.pagesize - 1) / this.pagesize;
		// 算出用户想看的页的数据从数据库哪个地方开始取
		this.startindex = (this.pagenum - 1) * this.pagesize;

		if (this.totalpage <= 10)
		{
			this.startPage = 1;
			this.endPage = this.totalpage;
		} else
		{
			this.startPage = pagenum - 5;
			this.endPage = pagenum + 6;

			if (this.startPage < 1)
			{
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.totalpage)
			{
				this.endPage = this.totalpage;
				this.startPage = this.totalpage - 9;
			}
		}
	}

	public int getTotalpage()
	{
		return totalpage;
	}

	public void setTotalpage(int totalpage)
	{
		this.totalpage = totalpage;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public int getTotalrecord()
	{
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord)
	{
		this.totalrecord = totalrecord;
	}

	public int getPagenum()
	{
		return pagenum;
	}

	public void setPagenum(int pagenum)
	{
		this.pagenum = pagenum;
	}

	public int getStartindex()
	{
		return startindex;
	}

	public void setStartindex(int startindex)
	{
		this.startindex = startindex;
	}

	public List getList()
	{
		return list;
	}

	public void setList(List list)
	{
		this.list = list;
	}

	public int getStartPage()
	{
		return startPage;
	}

	public void setStartPage(int startPage)
	{
		this.startPage = startPage;
	}

	public int getEndPage()
	{
		return endPage;
	}

	public void setEndPage(int endPage)
	{
		this.endPage = endPage;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
