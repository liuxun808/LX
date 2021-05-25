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
import hrsys.vo.Jobs;

/**
 * Servlet implementation class SelectJobDeptServlet
 */
@WebServlet("/SelectJobDeptServlet")
public class SelectJobDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectJobDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService deptServiceservice = new DeptServiceImpl();
		List<Dept> depts = deptServiceservice.selectDept();
		request.setAttribute("depts", depts);
		JobsService service = new JobsServiceImpl();
		List<Jobs> jobs = service.selectAll();
		request.setAttribute("jobs", jobs);
		request.getRequestDispatcher("admin/AddEmp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
