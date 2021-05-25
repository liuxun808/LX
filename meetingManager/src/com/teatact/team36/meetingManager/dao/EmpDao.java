package com.teatact.team36.meetingManager.dao;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.vo.Emp;

public class EmpDao {
	//����һ�����Emp���list����
	static ArrayList<Emp> list = new ArrayList<Emp>();
	//��̬�飺��һ�μ�����ʱ���õĴ���
	static{
		//��Ӳ�������
		//ʵ����Ա������
		Emp emp1 = new Emp(1, "tom", "tom", "123", "111115", "sssss@163.com", 1, 1);
		Emp emp2 = new Emp(3, "jack", "jack", "123", "111115", "sfgggss@163.com", 1, 0);
		Emp emp3 = new Emp(5, "rose", "rose", "123", "111115", "sfyyys@163.com", 2, 2);
		//���˼��뵽������
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
	}
	
	//��ѯԱ�����ݵ�½���ֺ�����
	public Emp selectEmpByLoginNameAndPassword(String loginName,String password){
		//foreachѭ��   for(ѭ������������   ѭ����������:Ҫ���������������)
		for(Emp emp:list){
			//�ж�listԪ���е�Ԫ�ص��û����������Ƿ�ʹ����һ��
			if(emp.getLoginName().equals(loginName)&&emp.getPassword().equals(password)){
				return emp;
			}
		}
		return null;//���ؿ�
	}
	
	//1���ݵ�¼����ѯԱ��
	public Emp selectEmpByLoginName(String loginName){
		for(Emp emp:list){
			if(emp!=null&&emp.getLoginName().equals(loginName)){
				return emp;
			}
		}
		return null;
	}
	//2��id���ֵ
	public int selectMaxEmpId(){
		int max = 0;
		for(Emp emp:list){
			if(max<emp.getEmpId()){
				max = emp.getEmpId();
			}
		}
		return max;
	}
	//3���Ա��
	public boolean insertEmp(Emp emp){
		list.add(emp);
		return true;
	}
}
