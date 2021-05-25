package hrsys.service;

import hrsys.vo.Admin;

public interface AdminService {
	Admin selectAdmin(String adminName,String adminPwd);
}
