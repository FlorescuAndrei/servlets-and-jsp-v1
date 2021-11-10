package com.andrei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter{
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//Filter.super.init(filterConfig);
	}
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println(req.getRequestURI());
		
		if(req.getSession().getAttribute("name")!=null) {
			chain.doFilter(request, response);
		}else {
			req.getRequestDispatcher("/login.do").forward(request, response);
		}
		
		
		
	}

	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//Filter.super.destroy();
	}
	
	

}
