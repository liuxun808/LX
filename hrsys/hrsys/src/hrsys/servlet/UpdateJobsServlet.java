package hrsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hrsys.service.JobsService;
import hrsys.service.JobsServiceImpl;
import hrsys.vo.Jobs;

/**
 * Servlet implementation class UpdateJobsServlet
 */
@WebServlet("/UpdateJobsServlet")
public class UpdateJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobsService service = new JobsServiceImpl();
		Jobs jobs = new Jobs(request.getParameter("job_id"), request.getParameter("job_title"), Integer.parseInt(request.getParameter("min_salary")), Integer.parseInt(request.getParameter("max_salary")));
		if (service.updateJob(jobs)>0) {
			response.sendRedirect("JobsViewServlet");
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
