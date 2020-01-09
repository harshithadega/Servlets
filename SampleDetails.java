package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleDetails
 */
@WebServlet("/SampleDetails")
public class SampleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SampleDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("empname");
		String emailid = request.getParameter("mailid");
		int sal = Integer.parseInt(request.getParameter("sal"));
		String doj = request.getParameter("doj");
		String job = request.getParameter("job");
		
		
		out.println("Employee name : " +" "+name +"<br>");
		out.println("emailid is  "+" "+emailid+"<br>");
		out.println("Salary is  "+" "+ sal+"<br>");
		out.println("doj is "+" "+ doj+"<br>");
		out.println("job is "+" "+ job+"<br>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
