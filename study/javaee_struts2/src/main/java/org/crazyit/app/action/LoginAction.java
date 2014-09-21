package org.crazyit.app.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletResponseAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//定义封装请求参数的username和password属性
	private String username;
	private String password;
	private HttpServletResponse response;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	//定义处理用户请求的execute方法
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		Integer counter = (Integer)ctx.getApplication().get("counter");
		if(counter == null)
			counter = 1;
		else
			++counter;
		ctx.getApplication().put("counter", counter);
		ctx.getSession().put("user", getUsername());
		//当username为crazyit.org，password为leegang时即登录成功
		if (getUsername().equals("crazyit.org") && getPassword().equals("leegang")) {
			Cookie c = new Cookie("user", getUsername());
			c.setMaxAge(60*60);
			response.addCookie(c);
			ctx.put("tip", "服务器提示：您已经成功登陆");
			return SUCCESS;
		}
		else {
			ctx.put("tip", "服务器提示：登陆失败");
			return ERROR;
		}
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}