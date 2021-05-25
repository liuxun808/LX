package hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import hrsys.vo.Jobs;

public class JobsDaoImpl implements JobsDao {
	private RowMapper<Jobs> rm = (rs)->{
		Jobs jobs = new Jobs();
		try {
			jobs.setJobno(rs.getString("Job_id"));
			jobs.setJname(rs.getString("Job_title"));
			jobs.setMinSal(rs.getInt("min_salary"));
			jobs.setMaxSal(rs.getInt("max_salary"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs;
	};
	
	@Override
	public int insertJob(Jobs jobs) {
		String sql = "INSERT INTO jobs(Job_id,job_title,min_salary,max_salary)VALUES(?,?,?,?);";
		Object[] paramters = {jobs.getJobno(),jobs.getJname(),jobs.getMinSal(),jobs.getMaxSal()};
		return Dbutil.executeUpdate(sql, paramters);
	}

	@Override
	public int updateJob(Jobs jobs) {
		String sql = "UPDATE jobs SET job_title = ?,min_salary = ?,max_salary =? WHERE Job_id = ?;";
		Object[] paramters = {jobs.getJname(),jobs.getMinSal(),jobs.getMaxSal(),jobs.getJobno()};
		return Dbutil.executeUpdate(sql, paramters);
	}

	@Override
	public int deleteJob(String jobno) {
		String sql = "DELETE FROM jobs WHERE job_id = ?;";
		Object[] paramters = {jobno};
		return Dbutil.executeUpdate(sql, paramters);
	}

	@Override
	public Jobs selectJob(String jobno) {
		String sql = "select * FROM jobs WHERE job_id = ?;";
		Object[] paramters = {jobno};
		Dbutil<Jobs> dbutil = new Dbutil<Jobs>();
		return dbutil.executeQueryOne(sql, paramters, rm);
	}

	@Override
	public List<Jobs> selectAll() {
		String sql = "select * FROM jobs;";
		Dbutil<Jobs> dbutil = new Dbutil<Jobs>();
		return dbutil.executeQuery(sql, null, rm);
	}

}
