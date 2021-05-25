package com.teatact.team36.meetingManager.vo;

public class Emp {
	//员工id，姓名，登陆名，密码，电话，邮箱，部门编号，状态（int类型  ：0待审核1审核通过2审核被拒绝）
	private int empId;
	private String name;
	private String loginName;
	private String password;
	private String number;
	private String email;
	private int deptId;
	private int status;
	
	public Emp() {
		super();
	}
	public Emp(int empId, String name, String loginName, String password, String number, String email, int deptId,
			int status) {
		super();
		this.empId = empId;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.number = number;
		this.email = email;
		this.deptId = deptId;
		this.status = status;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", loginName=" + loginName + ", password=" + password
				+ ", number=" + number + ", email=" + email + ", deptId=" + deptId + ", status=" + status + "]";
	}
}
