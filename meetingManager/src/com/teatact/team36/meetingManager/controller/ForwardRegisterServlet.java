package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teatact.team36.meetingManager.service.DeptService;
import com.teatact.team36.meetingManager.vo.Dept;

/**
 * Servlet implementation class ForwardRegisterServlet
 */
@WebServlet("/ForwardRegisterServlet")
public class ForwardRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptService service = new DeptService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForwardRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Dept> list = service.showAllDept();//获得所有的部门
		//将list放到前台
		request.setAttribute("list", list);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
