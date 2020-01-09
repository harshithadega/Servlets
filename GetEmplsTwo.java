package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class GetEmplsTwo
 */
@WebServlet("/GetEmplsTwo")
public class GetEmplsTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao = new EmpDaoImpl();
		List<Emp> emplist = dao.getEmpls();
		request.setAttribute("empls", emplist); 
		request.getRequestDispatcher("ViewEmpls.jsp").forward(request, response); 
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
