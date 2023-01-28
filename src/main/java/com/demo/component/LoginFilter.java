package com.demo.component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@WebFilter(filterName = "", urlPatterns = { "/*" })
@Order(value = 1)
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		String uri = new String(req.getRequestURI());

		// 放行所有靜態檔案
		if (uri.contains("/css") || uri.contains("/images") || uri.contains("/js") || uri.contains("/favicon.ico")) {
			chain.doFilter(request, response);
			return;
		}

		// No 登入
		if (true) {
			System.err.println("No Login---> " + uri);
			if (uri.contains("/login") || uri.contains("/register")) {
				chain.doFilter(request, response);
			} else {
//				res.sendRedirect("/back/login");
			}
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
