package hrsys.service;

import java.util.List;

import hrsys.dao.JobsDao;
import hrsys.dao.JobsDaoImpl;
import hrsys.vo.Jobs;

public class JobsServiceImpl implements JobsService {
	private JobsDao dao = new JobsDaoImpl();
	@Override
	public int insertJob(Jobs jobs) {
		if (dao.selectJob(jobs.getJobno()) ==null) {
			return dao.insertJob(jobs);
		} else {
			return 0;
		}
	}

	@Override
	public int updateJob(Jobs jobs) {
		// TODO Auto-generated method stub
		return dao.updateJob(jobs);
	}

	@Override
	public int deleteJob(String jobno) {
		// TODO Auto-generated method stub
		return dao.deleteJob(jobno);
	}

	@Override
	public Jobs selectJob(String jobno) {
		// TODO Auto-generated method stub
		return dao.selectJob(jobno);
	}

	@Override
	public List<Jobs> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
