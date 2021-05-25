package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teatact.team36.meetingManager.service.DeptService;

/**
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DeptService service = new DeptService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得前台传入的值
		String id = request.getParameter("deptId");
		String deptName = request.getParameter("deptname");
		System.out.println(id);
		System.out.println(deptName);
		int deptId = Integer.parseInt(id);
		int flag  = service.updateDept(deptId, deptName);
		if(flag==1){
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else if(flag==2){
			request.setAttribute("msg", "重名，修改失败");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else{
			request.setAttribute("msg", "原数据，未作修改");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理中文
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
