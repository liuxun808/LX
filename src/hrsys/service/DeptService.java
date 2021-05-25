package hrsys.service;

import java.util.List;

import hrsys.vo.Dept;



public interface DeptService {
	int addDept(Dept dept);
	int Update(Dept dept);
	int deleteDept(int deptno);
	Dept selectByDeptno(int deptno);
	List<Dept> selectDept();
}
