package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class AddEmpl
 */
@WebServlet("/AddEmpl")
public class AddEmpl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int empno = Integer.parseInt(request.getParameter("empno"));
		String empname = request.getParameter("empname");
		double sal=Double.parseDouble(request.getParameter("sal"));
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		double comm=Double.parseDouble(request.getParameter("comm"));
		String job=request.getParameter("job");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String hiredate=request.getParameter("hiredate");
		Emp emp = new Emp(empno,empname,job,mgr,hiredate,sal,comm,deptno);
		EmpDao dao = new EmpDaoImpl();
		int rows = dao.addEmp(emp);
		if(rows>0)
			out.println("inserted");
		else
			out.println("not inserted");
	}
		
		
	}

