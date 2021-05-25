package com.teatact.team36.meetingManager.dao;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.vo.Dept;

public class DeptDao {
	//����һ����Ų��ŵ�list�����list�з�����������
	static ArrayList<Dept> list = new ArrayList<Dept>();
	static{//��Ӳ�������
		Dept dept1 = new Dept(1,"���۲�");
		Dept dept2 = new Dept(3, "������");
		Dept dept3 = new Dept(5, "����");
		list.add(dept1);
		list.add(dept2);
		list.add(dept3);
	}
	//������еĲ���
	public ArrayList<Dept> selectAllDept(){
		return list;
	}
	
	//��ӣ�dao��Ҫ��������
	//1��Ҫ�������ֲ�ѯ����
	public Dept selectDeptByName(String deptName){
		for(Dept dept:list){
			if(dept!=null&&dept.getDeptName().equals(deptName)){
				return dept;
			}
		}
		return null;
	}
	//2�ҵ���ǰ���в��ŵ����id
	public int selectMaxId(){
		int max = 0;
		for(Dept dept:list){
			if(max<dept.getDeptId()){
				max = dept.getDeptId();
			}
		}
		return max;
	}
	//3��ӵķ���
	public boolean insertDept(int deptId,String deptName){
		Dept dept = new Dept(deptId, deptName);//�����ݷŵ�������
		list.add(dept);
		return true;
	}
	//����idɾ���ķ���
	public boolean deleteDept(int deptId){
		for(Dept dept:list){
			if(dept.getDeptId()==deptId){//����id�Ͷ���idһ��
				//�Ƴ�����
				list.remove(dept);
				return true;
			}
		}
		return false;
	}
	//�޸�dept
	public boolean updateDept(int deptId,String deptName){
		for(Dept dept:list){
			if(dept.getDeptId()==deptId){
				//�ҵ���Ԫ��,�޸�����
				dept.setDeptName(deptName);
				return true;
			}
		}
		return false;
	}
	
}
