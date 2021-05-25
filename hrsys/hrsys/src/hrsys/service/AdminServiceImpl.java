package hrsys.service;

import hrsys.dao.AdminDao;
import hrsys.dao.AdminDaoImpl;
import hrsys.vo.Admin;

public class AdminServiceImpl implements AdminService {
	AdminDao dao = new AdminDaoImpl();
	@Override
	public Admin selectAdmin(String adminName, String adminPwd) {
		// TODO Auto-generated method stub
		return dao.selectAdmin(adminName, adminPwd);
	}

}
