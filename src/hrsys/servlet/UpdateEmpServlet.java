package hrsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrsys.service.EmpService;
import hrsys.service.EmpServiceImpl;
import hrsys.vo.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmpService service = new EmpServiceImpl();
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(request.getParameter("employee_id")));
		emp.setEname(request.getParameter("empname"));
		emp.setEmail(request.getParameter("email"));
		emp.setPhone(request.getParameter("phone_number"));
		emp.setHire(request.getParameter("hire_date"));
		emp.setJobno( request.getParameter("job_id"));
		emp.setSal(Integer.parseInt(request.getParameter("salary")));
		emp.setDeptno(Integer.parseInt(request.getParameter("department_id")));
		int sum = service.updateEmp(emp);
		if (sum>0) {
			response.sendRedirect("EmpViewServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
