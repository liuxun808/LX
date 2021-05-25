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
		//���ǰ̨�����ֵ
		String id = request.getParameter("deptId");
		String deptName = request.getParameter("deptname");
		System.out.println(id);
		System.out.println(deptName);
		int deptId = Integer.parseInt(id);
		int flag  = service.updateDept(deptId, deptName);
		if(flag==1){
			request.setAttribute("msg", "�޸ĳɹ�");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else if(flag==2){
			request.setAttribute("msg", "�������޸�ʧ��");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}else{
			request.setAttribute("msg", "ԭ���ݣ�δ���޸�");
			request.getRequestDispatcher("ShowAllDeptServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
