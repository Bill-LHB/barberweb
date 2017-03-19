package com.lhb.barber.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lhb.barber.UserManager;
import com.lhb.barber.model.User;

public class SignOnFilter implements Filter {
	private FilterConfig config;

	/**
	 * nonProtectedUris 存贮不需要权限处理的URL
	 */
	private HashMap nonProtectedUris = new HashMap();

	/**
	 * init方法在tomcat启动、程序加载时执行
	 */
	public void init(FilterConfig config) {
		this.config = config;
		String uri = config.getInitParameter("non-protected.uri");
		String[] stringlist = uri.split(",");
		for (String s : stringlist) {
			nonProtectedUris.put(s, s);
		}
	}

	/**
	 * doFilter 每次.jspa的URL请求时执行，与web.xml配置文件有关
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = getStringIncisionString(req.getRequestURI());
		if (!isNonProtected(uri)) // 如果配置文件属性non-protected.uri（不处理uri地址）中不包含请求uri,则执行下面判继
		{
			if (!getPermission(req)) // 权限不够时执行
			{
				config.getServletContext().getRequestDispatcher("权限不够.jsp").forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		nonProtectedUris.clear();
	}

	private boolean getPermission(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) 
		{
			return false;
		}
		// 登录成功将userId保存到session中
		User presentUser = (User) session.getAttribute("presentUser");
		String action = getStringIncisionString(request.getRequestURI());
		try {
			return UserManager.getInstance().getGroupPermission(presentUser, action);
		} catch (Exception e) {
			return false;
		}
	}

	private String getStringIncisionString(String uri) {
		if (uri.startsWith("/")) 
		{
			uri = uri.substring(1);
		}
		if (uri.lastIndexOf("/") == uri.length() - 1) 
		{
			uri = uri.substring(0, uri.lastIndexOf("/"));
		}
		if (uri.lastIndexOf("?") >= 0) 
		{
			uri = uri.substring(0, uri.lastIndexOf("?"));
		}
		int lastSlashPos = uri.lastIndexOf("/");
		if (uri.lastIndexOf("/") >= 0) 
		{
			if (uri.lastIndexOf("/", uri.lastIndexOf("/")) >= 0) 
			{
				lastSlashPos = uri.lastIndexOf("/", uri.lastIndexOf("/"));
			}
		}
		return uri.substring(lastSlashPos + 1);
	}

	private boolean isNonProtected(String uri) {
		return (nonProtectedUris.get(uri) != null);
	}

}
