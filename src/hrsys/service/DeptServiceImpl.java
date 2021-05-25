package hrsys.service;

import java.util.List;

import hrsys.dao.DeptDao;
import hrsys.dao.DeptDaoImpl;
import hrsys.vo.Dept;



public class DeptServiceImpl implements DeptService {
	private DeptDao dao = new DeptDaoImpl();
	//添加
	@Override
	public int addDept(Dept dept) {
		// TODO Auto-generated method stub
		if (dao.selectByDeptno(dept.getDeptno()) == null) {
			return dao.addDept(dept);
		} else {
			return 0;
		}
		
	}
	//修改
	@Override
	public int Update(Dept dept) {
		// TODO Auto-generated method stub
		return dao.Update(dept);
	}
	//删除
	@Override
	public int deleteDept(int deptno) {
		// TODO Auto-generated method stub
		return dao.deleteDept(deptno);
	}
	//编号查询
	@Override
	public Dept selectByDeptno(int deptno) {
		// TODO Auto-generated method stub
		return dao.selectByDeptno(deptno);
	}
	//查询全部
	@Override
	public List<Dept> selectDept() {
		// TODO Auto-generated method stub
		return dao.selectDept();
	}

}
