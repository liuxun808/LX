package com.teatact.team36.meetingManager.dao;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.vo.Emp;

public class EmpDao {
	//定义一个存放Emp类的list集合
	static ArrayList<Emp> list = new ArrayList<Emp>();
	//静态块：第一次加载类时调用的代码
	static{
		//添加测试数据
		//实例化员工对象
		Emp emp1 = new Emp(1, "tom", "tom", "123", "111115", "sssss@163.com", 1, 1);
		Emp emp2 = new Emp(3, "jack", "jack", "123", "111115", "sfgggss@163.com", 1, 0);
		Emp emp3 = new Emp(5, "rose", "rose", "123", "111115", "sfyyys@163.com", 2, 2);
		//将人加入到集合中
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
	}
	
	//查询员工根据登陆名字和密码
	public Emp selectEmpByLoginNameAndPassword(String loginName,String password){
		//foreach循环   for(循环变量的类型   循环变量名字:要遍历的数组的名字)
		for(Emp emp:list){
			//判断list元素中的元素的用户名和密码是否和传入的一致
			if(emp.getLoginName().equals(loginName)&&emp.getPassword().equals(password)){
				return emp;
			}
		}
		return null;//返回空
	}
	
	//1根据登录名查询员工
	public Emp selectEmpByLoginName(String loginName){
		for(Emp emp:list){
			if(emp!=null&&emp.getLoginName().equals(loginName)){
				return emp;
			}
		}
		return null;
	}
	//2找id最大值
	public int selectMaxEmpId(){
		int max = 0;
		for(Emp emp:list){
			if(max<emp.getEmpId()){
				max = emp.getEmpId();
			}
		}
		return max;
	}
	//3添加员工
	public boolean insertEmp(Emp emp){
		list.add(emp);
		return true;
	}
}
