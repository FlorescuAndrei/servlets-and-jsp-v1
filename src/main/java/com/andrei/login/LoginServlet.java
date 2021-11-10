package com.andrei.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrei.login.LoginService;
import com.andrei.todo.Todo;
import com.andrei.todo.TodoService;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
//		       PrintWriter writer = resp.getWriter();
//		       writer.println("My response directly in the browser, no JSP");
		 		
		 		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		 		
		    }
	 
	 
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 		
		 LoginService uvs = new LoginService();
		 	
		       String name = req.getParameter("name");
		      
		       System.out.println(name);
		      
		       String password = req.getParameter("password");
		      
		       
		      
		       if(uvs.isUserValid(name, password)) {
		    	   
		    	   //Session request
		    	   req.getSession().setAttribute("name", name);
		    	   
		    	 
		    	  resp.sendRedirect("/todo.do");
		    	  
		       }else {
		    	   //Simple request
		    	   
		    	   req.setAttribute("name", name);
			       req.setAttribute("password", password);
		       
		    	   req.setAttribute("errorMessage","Invalid credentials name: " + name + " password: " + password);
		      
		    	   req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
		       }
		    }

	

}
