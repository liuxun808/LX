package com.teatact.team36.meetingManager.service;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.dao.DeptDao;
import com.teatact.team36.meetingManager.vo.Dept;

public class DeptService {
	DeptDao dao = new DeptDao();
	//显示全部部门的方法
	public ArrayList<Dept> showAllDept(){
		return dao.selectAllDept();
	}
	//添加的功能：
	//步骤：1先判断重名，重名就失败；
	//2不重名：获得当前最大值，最大值+1为id，名字是前台传入的
	public boolean addDept(String deptName){
		Dept dept = dao.selectDeptByName(deptName);
		if(dept!=null){//添加的名字存在，不能添加
			return false;
		}else{
			//获得id最大值
			int maxId = dao.selectMaxId();
			//添加
			dao.insertDept(maxId+1, deptName);
			return true;
		}
	}
	//删除部门
	public boolean deleteDept(int deptId){
		return dao.deleteDept(deptId);
	}
	
	//修改
	//1修改成功2修改失败，重名3还保持原有的数据
	public int updateDept(int deptId,String deptName){
		//根据要改的名字看是否有部门
		Dept dept = dao.selectDeptByName(deptName);
		if(dept!=null){//找到重名
			if(dept.getDeptId()==deptId){//数据没动
				return 3;
			}else{//和别人重名
				return 2;
			}
		}else{
			//调用dao层修改的方法
			dao.updateDept(deptId, deptName);
			return 1;
		}
	}
}
