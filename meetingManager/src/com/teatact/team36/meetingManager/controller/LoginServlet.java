package com.teatact.team36.meetingManager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatact.team36.meetingManager.service.EmpService;

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
		//对应前台input的name属性
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(name+"   "+pwd);
		EmpService service = new EmpService();
		int flag = service.login(name, pwd);
		if(flag==0){
			//servlet向jsp传值
			request.setAttribute("msg","正在审核中，请耐心等待");
			//跳转页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(flag==1){//成功
			request.getRequestDispatcher("adminindex.jsp").forward(request, response);
		}else if(flag==2){
			request.setAttribute("msg","很抱歉，审核被拒绝");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg","用户名密码错误");
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
