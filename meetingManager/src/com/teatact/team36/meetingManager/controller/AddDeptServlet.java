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
		//���ǰ̨������
		String deptName = request.getParameter("departmentname");
		System.out.println(deptName);
		boolean flag = service.addDept(deptName);
		if(flag){
			//��ǰ̨������ʾ��Ϣ
			request.setAttribute("msg", "��ӳɹ�");
			//servlet����servlet
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else{
			//��ǰ̨������ʾ��Ϣ
			request.setAttribute("msg", "�����ˣ����ʧ��");
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
