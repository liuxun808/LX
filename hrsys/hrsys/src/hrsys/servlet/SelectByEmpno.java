package hrsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrsys.service.DeptService;
import hrsys.service.DeptServiceImpl;
import hrsys.service.EmpService;
import hrsys.service.EmpServiceImpl;
import hrsys.service.JobsService;
import hrsys.service.JobsServiceImpl;
import hrsys.vo.Dept;
import hrsys.vo.Emp;
import hrsys.vo.Jobs;

/**
 * Servlet implementation class SelectByEmpno
 */
@WebServlet("/SelectByEmpno")
public class SelectByEmpno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByEmpno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service = new EmpServiceImpl();
		Emp emp = service.selectByEmpno(Integer.parseInt(request.getParameter("empno")));
		request.setAttribute("emp", emp);
		DeptService deptServiceservice = new DeptServiceImpl();
		List<Dept> depts = deptServiceservice.selectDept();
		request.setAttribute("depts", depts);
		JobsService jobsServiceservice = new JobsServiceImpl();
		List<Jobs> jobs = jobsServiceservice.selectAll();
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("admin/UpdateEmp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
