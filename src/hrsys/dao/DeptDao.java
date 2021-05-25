package hrsys.dao;

import java.util.List;

import hrsys.vo.Dept;



public interface DeptDao {
	int addDept(Dept dept);
	int Update(Dept dept);
	int deleteDept(int deptno);
	Dept selectByDeptno(int deptno);
	List<Dept> selectDept();
}
