package hrsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import hrsys.service.JobsService;
import hrsys.service.JobsServiceImpl;
import hrsys.vo.Jobs;

/**
 * Servlet implementation class SelectByJobAjaxServlet
 */
@WebServlet("/SelectByJobAjaxServlet")
public class SelectByJobAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByJobAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobno = request.getParameter("job_id");
		JobsService service = new JobsServiceImpl();
		Jobs jobs = service.selectJob(jobno);
		response.setContentType("application/json; charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jobs);
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
