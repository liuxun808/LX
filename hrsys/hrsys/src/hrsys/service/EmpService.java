package hrsys.service;

import java.util.List;

import hrsys.vo.Emp;


public interface EmpService {
	int insertEmp(Emp emp);
	int updateEmp(Emp emp);
	int deleteEmp(int empno);
	Emp selectByEmpno(int empno);
	List<Emp> selectAll();
}
