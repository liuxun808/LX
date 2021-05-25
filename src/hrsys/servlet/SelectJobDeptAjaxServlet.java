package hrsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import hrsys.service.DeptService;
import hrsys.service.DeptServiceImpl;
import hrsys.service.JobsService;
import hrsys.service.JobsServiceImpl;
import hrsys.vo.Dept;
import hrsys.vo.Jobs;

/**
 * Servlet implementation class SelectJobDeptAjaxServlet
 */
@WebServlet("/SelectJobDeptAjaxServlet")
public class SelectJobDeptAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectJobDeptAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService deptService = new DeptServiceImpl();
		JobsService jobsService = new JobsServiceImpl();
		List<Dept> depts = deptService.selectDept();
		List<Jobs> jobs = jobsService.selectAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobs", jobs);
		map.put("depts", depts);
		
		response.setContentType("application/json; charset=UTF-8");
		ObjectMapper mapper =  new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
