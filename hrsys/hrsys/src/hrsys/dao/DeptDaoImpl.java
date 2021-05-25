package hrsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hrsys.vo.Dept;



public class DeptDaoImpl implements DeptDao {
	private RowMapper<Dept> rm = (rs)->{
		Dept dept = new Dept();
		try {
			dept.setDeptno(rs.getInt("Department_id"));
			dept.setDname(rs.getString("Department_name"));
			dept.setLoc(rs.getString("Location_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	};
	//添加
	@Override
	public int addDept(Dept dept) {
		String sql = "INSERT INTO departments(department_id,department_name,location_name)VALUES(?,?,?)";
		Object[] paramters = {dept.getDeptno(),dept.getDname(),dept.getLoc()};
		return Dbutil.executeUpdate(sql, paramters);
	}
	//修改
	@Override
	public int Update(Dept dept) {
		String sql = "UPDATE departments SET  department_name= ?,location_name = ? WHERE department_id = ?";
		Object[] paramters = {dept.getDname(),dept.getLoc(),dept.getDeptno()};
		return Dbutil.executeUpdate(sql, paramters);
 	}
	//删除
	@Override
	public int deleteDept(int deptno) {
		String sql = "delete from departments where department_id=?";
		Object[] paramters = {deptno};
		return Dbutil.executeUpdate(sql, paramters);
 	}
	//按编号查询
	@Override
	public Dept selectByDeptno(int deptno) {	
		String sql = "SELECT * FROM departments WHERE department_id = ? ";
		Object[] paramters = {deptno};
		Dbutil<Dept> dbutil = new Dbutil<Dept>();
		return dbutil.executeQueryOne(sql, paramters, rm);
	}
	//查询全部
	@Override
	public List<Dept> selectDept() {
		String sql = "SELECT * FROM departments ";
		Object[] paramters = {};
		Dbutil<Dept> dbutil = new Dbutil<Dept>();
		return dbutil.executeQuery(sql, paramters, rm);
	}

}
