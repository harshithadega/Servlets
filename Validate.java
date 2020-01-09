package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("admin","admin");
		//session.invalidate();
		String user =request.getParameter("user");
		String password = request.getParameter("password");
		RequestDispatcher rd= null;
		if(user.isEmpty()||password.isEmpty())
		{
			out.println("<font color =red>username and password should not be empty</font>");
			rd=request.getRequestDispatcher("Form.html");
		    rd.include(request, response);
		}
		else 
			{
			if(user.equals("admin")&&password.equals("admin"))
			{
			rd = request.getRequestDispatcher("Admin");
			rd.forward(request,response);
			//response.sendRedirect("http://www.yahoo.com");
			}
	       else
	       {
			rd=request.getRequestDispatcher("User");
	        rd.forward(request,response);
	       }
		//,rd.include(request, response);
	}
		//out.println("success");
	}
}
