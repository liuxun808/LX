package hrsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hrsys.service.AdminService;
import hrsys.service.AdminServiceImpl;
import hrsys.vo.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = new AdminServiceImpl();
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");	
		int adminLevel = Integer.parseInt(request.getParameter("adminlevel"));
		if (service.selectAdmin(adminName, adminPwd)!=null) {
			HttpSession session = request.getSession();
			Admin admin = new Admin();
			admin.setAdminName(adminName);
			admin.setAdminPwd(adminPwd);
			admin.setAdminLevel(adminLevel);
			session.setAttribute("admin", admin);
			response.sendRedirect("admin/Main.jsp");
		} else {
			String msg = "用户名或密码错误";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("admin/Login.jsp").forward(request, response);
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
