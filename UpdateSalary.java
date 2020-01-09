package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class UpdateSalary
 */
@WebServlet("/UpdateSalary")
public class UpdateSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int empno=Integer.parseInt(request.getParameter("empno"));
		double sal =Double.parseDouble(request.getParameter("newsal"));
		EmpDao emp = new EmpDaoImpl();
		emp.updEmp(sal,empno);
		out.println("Salary is updated to "+sal+"for employee number "+empno);
	}

}
