package com.teatact.team36.meetingManager.service;

import java.util.ArrayList;
import com.teatact.team36.meetingManager.dao.DeptDao;
import com.teatact.team36.meetingManager.vo.Dept;

public class DeptService {
	DeptDao dao = new DeptDao();
	//��ʾȫ�����ŵķ���
	public ArrayList<Dept> showAllDept(){
		return dao.selectAllDept();
	}
	//��ӵĹ��ܣ�
	//���裺1���ж�������������ʧ�ܣ�
	//2����������õ�ǰ���ֵ�����ֵ+1Ϊid��������ǰ̨�����
	public boolean addDept(String deptName){
		Dept dept = dao.selectDeptByName(deptName);
		if(dept!=null){//��ӵ����ִ��ڣ��������
			return false;
		}else{
			//���id���ֵ
			int maxId = dao.selectMaxId();
			//���
			dao.insertDept(maxId+1, deptName);
			return true;
		}
	}
	//ɾ������
	public boolean deleteDept(int deptId){
		return dao.deleteDept(deptId);
	}
	
	//�޸�
	//1�޸ĳɹ�2�޸�ʧ�ܣ�����3������ԭ�е�����
	public int updateDept(int deptId,String deptName){
		//����Ҫ�ĵ����ֿ��Ƿ��в���
		Dept dept = dao.selectDeptByName(deptName);
		if(dept!=null){//�ҵ�����
			if(dept.getDeptId()==deptId){//����û��
				return 3;
			}else{//�ͱ�������
				return 2;
			}
		}else{
			//����dao���޸ĵķ���
			dao.updateDept(deptId, deptName);
			return 1;
		}
	}
}
