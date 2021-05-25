package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatact.team36.meetingManager.service.DeptService;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/AddDeptServlet")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DeptService service = new DeptService();   
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
		//获得前台的数据
		String deptName = request.getParameter("departmentname");
		System.out.println(deptName);
		boolean flag = service.addDept(deptName);
		if(flag){
			//向前台传递提示信息
			request.setAttribute("msg", "添加成功");
			//servlet跳到servlet
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else{
			//向前台传递提示信息
			request.setAttribute("msg", "重名了，添加失败");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
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
