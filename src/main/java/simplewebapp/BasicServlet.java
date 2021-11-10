package simplewebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/login.do/print")
public class BasicServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet base app</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My First Servlet");
		out.println(" No JSP, no HTML. Display with PrintWriter.");
		out.println("</body>");
		out.println("</html>");

	}

}