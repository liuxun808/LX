package com.teatact.team36.meetingManager.dao;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.vo.Dept;

public class DeptDao {
	//定义一个存放部门的list，向该list中放入三个部门
	static ArrayList<Dept> list = new ArrayList<Dept>();
	static{//添加测试数据
		Dept dept1 = new Dept(1,"销售部");
		Dept dept2 = new Dept(3, "技术部");
		Dept dept3 = new Dept(5, "财务部");
		list.add(dept1);
		list.add(dept2);
		list.add(dept3);
	}
	//获得所有的部门
	public ArrayList<Dept> selectAllDept(){
		return list;
	}
	
	//添加，dao需要几个方法
	//1需要根据名字查询部门
	public Dept selectDeptByName(String deptName){
		for(Dept dept:list){
			if(dept!=null&&dept.getDeptName().equals(deptName)){
				return dept;
			}
		}
		return null;
	}
	//2找到当前所有部门的最大id
	public int selectMaxId(){
		int max = 0;
		for(Dept dept:list){
			if(max<dept.getDeptId()){
				max = dept.getDeptId();
			}
		}
		return max;
	}
	//3添加的方法
	public boolean insertDept(int deptId,String deptName){
		Dept dept = new Dept(deptId, deptName);//将数据放到部门中
		list.add(dept);
		return true;
	}
	//根据id删除的方法
	public boolean deleteDept(int deptId){
		for(Dept dept:list){
			if(dept.getDeptId()==deptId){//输入id和对象id一致
				//移除对象
				list.remove(dept);
				return true;
			}
		}
		return false;
	}
	//修改dept
	public boolean updateDept(int deptId,String deptName){
		for(Dept dept:list){
			if(dept.getDeptId()==deptId){
				//找到该元素,修改名字
				dept.setDeptName(deptName);
				return true;
			}
		}
		return false;
	}
	
}
