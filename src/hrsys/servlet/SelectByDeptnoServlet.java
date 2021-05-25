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
 * Servlet implementation class SelectByDeptnoServlet
 */
@WebServlet("/SelectByDeptnoServlet")
public class SelectByDeptnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByDeptnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptServiceImpl();
		Dept dept = service.selectByDeptno(Integer.parseInt(request.getParameter("department_id")));
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("admin/UpdateDept.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
