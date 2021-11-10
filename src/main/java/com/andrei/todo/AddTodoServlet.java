package com.andrei.todo;

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


@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {
	
	private TodoService todoService = new TodoService();
	 
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 	   
 	  Todo todo = new Todo( req.getParameter("todo"));
 	  
 	  todoService.addTodo(todo);
 	
 	  resp.sendRedirect("/todo.do");
    
 }


	

}
