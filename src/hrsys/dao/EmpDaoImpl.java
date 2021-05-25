package hrsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hrsys.vo.Dept;
import hrsys.vo.Emp;
import hrsys.vo.Jobs;



public class EmpDaoImpl implements EmpDao {
	private RowMapper<Emp> rm = (rs)->{
		Emp emp = new Emp();
		Dept dept = new Dept();
		Jobs jobs = new Jobs();
		try {
			dept.setDname(rs.getString("Department_name"));
			jobs.setJname(rs.getString("Job_title"));
			emp.setEname(rs.getString("Emp_name"));
			emp.setEmpno(rs.getInt("Employee_id"));
			emp.setEmail(rs.getString("Email"));
			emp.setPhone(rs.getString("Phone_number"));
			emp.setHire(rs.getString("Hire_date"));
			emp.setJobno(rs.getString("Job_id"));
			emp.setSal(rs.getInt("Salary"));
			emp.setDeptno(rs.getInt("Department_id"));
			emp.setDept(dept);
			emp.setJobs(jobs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	};
	
	@Override
	//添加
	public int insertEmp(Emp emp) {
		String sql = "INSERT INTO employees(emp_name,email,phone_number,hire_date,job_id,salary,department_id)VALUES(?,?,?,?,?,?,?);";
		Object[] paramters = {emp.getEname(),emp.getEmail(),emp.getPhone(),emp.getHire(),emp.getJobno(),emp.getSal(),emp.getDeptno()};
		return Dbutil.executeUpdate(sql, paramters);
	}
	//修改
	@Override
	public int updateEmp(Emp emp) {
		String sql = "UPDATE employees set emp_name = ?,email = ?,phone_number = ?,hire_date = ?,job_id = ?,salary = ?,department_id = ? WHERE employee_id = ?;";
		Object[] paramters = {emp.getEname(),emp.getEmail(),emp.getPhone(),emp.getHire(),emp.getJobno(),emp.getSal(),emp.getDeptno(),emp.getEmpno()};
		return Dbutil.executeUpdate(sql, paramters);
	}
	//删除
	@Override
	public int deleteEmp(int empno) {
		String sql = "DELETE FROM employees WHERE employee_id = ?";
		Object[] paramters = {empno};
		return Dbutil.executeUpdate(sql, paramters);
	}
	//编号查询
	@Override
	public Emp selectByEmpno(int empno) {
		String sql = "SELECT * FROM employees WHERE Employee_id =  ?";
		Object[] paramters = {empno};
		RowMapper<Emp> rm = (rs)->{
			Emp emp = new Emp();
			try {
				emp.setEname(rs.getString("Emp_name"));
				emp.setEmpno(rs.getInt("Employee_id"));
				emp.setEmail(rs.getString("Email"));
				emp.setPhone(rs.getString("Phone_number"));
				emp.setHire(rs.getString("Hire_date"));
				emp.setJobno(rs.getString("Job_id"));
				emp.setSal(rs.getInt("Salary"));
				emp.setDeptno(rs.getInt("Department_id"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emp;
		};
		Dbutil<Emp> dbutil = new Dbutil<Emp>();
		
		return dbutil.executeQueryOne(sql, paramters, rm);
	}
	//查询全部
	@Override
	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT e.Employee_id,e.Emp_name,e.Email,e.Phone_number,e.Hire_date ,e.Job_id,e.Department_id,d.Department_name,e.Salary,j.Job_title\r\n" + 
				"from Employees e JOIN departments d ON e.Department_id = d.Department_id\r\n" + 
				"JOIN jobs j ON e.Job_id = j.Job_id";
		
		Dbutil<Emp> dbutil = new Dbutil<Emp>();
		return dbutil.executeQuery(sql, null, rm);
	}

}
