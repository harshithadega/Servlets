package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		//Object a = session.getAttribute("admin");
		if(session.getAttribute("admin")==null)
		{
			out.println("Unathourisied access");
			}
		
		else
		{
			out.println("<h2>Welcome administrator!!</h2>");
			out.println("<a href =Form.html>Return to Form</a>");
			session.invalidate();
			}
		
		
	}

}