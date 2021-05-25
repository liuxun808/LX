package hrsys.vo;

public class Jobs {
	String jobno;
	String jname;
	int minSal;
	int maxSal;
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getMinSal() {
		return minSal;
	}
	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}
	public int getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(int maxSal) {
		this.maxSal = maxSal;
	}
	public Jobs(String jobno, String jname, int minSal, int maxSal) {
		super();
		this.jobno = jobno;
		this.jname = jname;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
}
