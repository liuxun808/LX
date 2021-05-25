package hrsys.service;

import java.util.List;

import hrsys.dao.EmpDao;
import hrsys.dao.EmpDaoImpl;
import hrsys.vo.Emp;



public class EmpServiceImpl implements EmpService {
	EmpDao dao = new EmpDaoImpl();
	//添加
	@Override
	public int insertEmp(Emp
			emp) {
		// TODO Auto-generated method stub
		if (dao.selectByEmpno(emp.getEmpno()) == null) {
			return dao.insertEmp(emp);
		} else {
			return 0;
		}
	}

	//修改
	@Override
	public int updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return dao.updateEmp(emp);
	}

	//删除
	@Override
	public int deleteEmp(int empno) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(empno);
	}

	//编号查询
	@Override
	public Emp selectByEmpno(int empno) {
		// TODO Auto-generated method stub
		return dao.selectByEmpno(empno);
	}

	//查询全部

	@Override
	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
