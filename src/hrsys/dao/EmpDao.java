package hrsys.dao;

import java.util.List;

import hrsys.vo.Emp;



public interface EmpDao {
	int insertEmp(Emp emp);
	int updateEmp(Emp emp);
	int deleteEmp(int empno);
	Emp selectByEmpno(int empno);
	List<Emp> selectAll();
}
