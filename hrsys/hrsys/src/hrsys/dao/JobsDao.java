package hrsys.dao;

import java.util.List;

import hrsys.vo.Jobs;

public interface JobsDao {
	int insertJob(Jobs jobs);
	int updateJob(Jobs jobs);
	int deleteJob(String jobno);
	Jobs selectJob(String jobno);
	List<Jobs> selectAll();
}
