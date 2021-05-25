package hrsys.service;

import java.util.List;

import hrsys.vo.Jobs;

public interface JobsService {
	int insertJob(Jobs jobs);
	int updateJob(Jobs jobs);
	int deleteJob(String jobno);
	Jobs selectJob(String jobno);
	List<Jobs> selectAll();
}
