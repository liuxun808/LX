package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatact.team36.meetingManager.service.DeptService;

/**
 * Servlet implementation class DeleteDeptServlet
 */
@WebServlet("/DeleteDeptServlet")
public class DeleteDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DeptService service = new DeptService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptId = request.getParameter("deptId");
		//String转int类型
		int id = Integer.parseInt(deptId);
		if(service.deleteDept(id)){
			request.setAttribute("msg", "删除成功");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else{
			request.setAttribute("msg", "删除失败");
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
