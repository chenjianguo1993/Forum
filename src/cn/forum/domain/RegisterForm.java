package cn.forum.domain;

/**
 * 
 * ClassName: RegisterForm
 * 
 * @Description: TODO
 * @author 陈建国
 * @date 2016-9-10
 */
public class RegisterForm
{
	private String userName;
	private String password;
	private String confirmPassword;
	private String email;
	private String verifyCode;
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getConfirmPassword()
	{
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getVerifyCode()
	{
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode)
	{
		this.verifyCode = verifyCode;
	}
	
}
