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

//Filter is a feature from JavaEE that intercept call to servlets 
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
		
		//We check if a user name has been entered, 
		//to prevent the user to directly access todo list via URL(http://localhost:8080/todo.do) and skip the login page.
		//If there is a name in the session we will allow the request to go throw, as usual, else we will redirect to login page.
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
