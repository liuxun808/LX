package com.teatact.team36.meetingManager.service;

import com.teatact.team36.meetingManager.dao.EmpDao;
import com.teatact.team36.meetingManager.vo.Emp;

public class EmpService {
	EmpDao dao = new EmpDao();
	//��¼�ķ���
	public int login(String loginName,String password){
		//�������ֺ������ѯԱ��
		Emp emp = dao.selectEmpByLoginNameAndPassword(loginName, password);
		if(emp!=null){//�鵽����
			return emp.getStatus();//����״̬
		}else{//û�и��ˣ�����һ���������
			return -1;
		}
	}
	//ע��ķ���
	public boolean register(Emp emp){
		Emp e = dao.selectEmpByLoginName(emp.getLoginName());
		if(e==null){
			//��õ�ǰ����Ա�������ֵ
			int max = dao.selectMaxEmpId();
			//�����ֵ��1��Ϊ�¼���Ա����idֵ
			emp.setEmpId(max+1);
			//����emp��list��
			dao.insertEmp(emp);
			return true;
		}else{
			return false;//������
		}
	}
	
}
