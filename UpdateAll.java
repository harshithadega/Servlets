package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.emp.dao.EmpDao;
import com.deloitte.emp.dao.impl.EmpDaoImpl;
import com.deloitte.emp.utils.ConvertDate;

/**
 * Servlet implementation class UpdateAll
 */
@WebServlet("/UpdateAll")
public class UpdateAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter out= response.getWriter();
	    EmpDao emp = new EmpDaoImpl();
	    int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		double sal=Double.parseDouble(request.getParameter("sal"));
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		double comm=Double.parseDouble(request.getParameter("comm"));
		String job=request.getParameter("job");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Date hiredate=ConvertDate.parseDate(request.getParameter("hiredate"));
		int rows=emp.updAll(ename, job, mgr, hiredate, sal, comm, deptno, empno);
		if(rows>0)
		{
		out.println("updated");
	    
	}
		else
		{ out.println("not updated");

}
	}
}
