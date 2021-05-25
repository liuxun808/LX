package hrsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrsys.service.DeptService;
import hrsys.service.DeptServiceImpl;
import hrsys.vo.Dept;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DeptService service = new DeptServiceImpl();
		Dept dept = new Dept(Integer.parseInt(request.getParameter("department_id")), request.getParameter("department_name"), request.getParameter("location_name"));
		int sum = service.addDept(dept);
		if (sum>0) {
			response.sendRedirect("DeptViewServlet");
		} else if(sum == 0){
			String msg = "部门编号冲突,请重新录入";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("admin/AddDept.jsp").forward(request, response);
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
