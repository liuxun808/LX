package com.teatact.team36.meetingManager.service;

import com.teatact.team36.meetingManager.dao.EmpDao;
import com.teatact.team36.meetingManager.vo.Emp;

public class EmpService {
	EmpDao dao = new EmpDao();
	//登录的方法
	public int login(String loginName,String password){
		//根据名字和密码查询员工
		Emp emp = dao.selectEmpByLoginNameAndPassword(loginName, password);
		if(emp!=null){//查到该人
			return emp.getStatus();//返回状态
		}else{//没有该人，返回一个错误代码
			return -1;
		}
	}
	//注册的方法
	public boolean register(Emp emp){
		Emp e = dao.selectEmpByLoginName(emp.getLoginName());
		if(e==null){
			//获得当前已有员工的最大值
			int max = dao.selectMaxEmpId();
			//将最大值加1作为新加入员工的id值
			emp.setEmpId(max+1);
			//加入emp到list中
			dao.insertEmp(emp);
			return true;
		}else{
			return false;//重名了
		}
	}
	
}
