package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatact.team36.meetingManager.service.EmpService;
import com.teatact.team36.meetingManager.vo.Emp;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmpService service = new EmpService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("employeename");
		String loginName = request.getParameter("accountname");
		String password = request.getParameter("password");
		String deptId = request.getParameter("deptId");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int deptid = Integer.parseInt(deptId);
		Emp emp = new Emp();
		emp.setName(name);
		emp.setDeptId(deptid);
		emp.setLoginName(loginName);
		emp.setEmail(email);
		emp.setNumber(phone);
		emp.setPassword(password);
		emp.setStatus(0);//½«×´Ì¬ÉèÎª0
		if(service.register(emp)){
			request.setAttribute("msg", "×¢²á³É¹¦");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "×¢²áÊ§°Ü");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
