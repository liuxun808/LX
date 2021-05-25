package hrsys.vo;

public class Emp {
	int empno;
	String ename;
	String email;
	String phone;
	String hire;
	String jobno;
	int sal;
	int deptno;
	Dept dept;
	Jobs jobs;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHire() {
		return hire;
	}
	public void setHire(String hire) {
		this.hire = hire;
	}
	public String getJobno() {
		return jobno;
	}
	public void setJobno(String jobno) {
		this.jobno = jobno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public Emp(int empno, String ename, String email, String phone, String hire, String jobno, int sal, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.email = email;
		this.phone = phone;
		this.hire = hire;
		this.jobno = jobno;
		this.sal = sal;
		this.deptno = deptno;
	}
	
	
	public Emp(String ename, String email, String phone, String hire, String jobno, int sal, int deptno) {
		super();
		this.ename = ename;
		this.email = email;
		this.phone = phone;
		this.hire = hire;
		this.jobno = jobno;
		this.sal = sal;
		this.deptno = deptno;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
}
