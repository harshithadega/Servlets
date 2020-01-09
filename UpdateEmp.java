package com.deloitte.emp.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.emp.beans.Emp;
import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;

/**
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EmpDao dao=new EmpDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.parseInt(request.getParameter("code"));
		Emp emp = dao.getEmpByCode(code);
		request.setAttribute("emp",emp);
		request.getRequestDispatcher("UpdateEmp.jsp").forward(request, response);

		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno=Integer.parseInt(request.getParameter("empno"));
		String ename=request.getParameter("ename");
		String job=request.getParameter("job");
		Emp emp=new Emp();
		emp.setEmpno(empno);
		emp.setEname(ename);
		emp.setJob(job);
		int rows=dao.updEmp(emp);
		request.getRequestDispatcher("GetEmplsTwo").forward(request, response);
         doGet(request,response);
         
		}

		}

