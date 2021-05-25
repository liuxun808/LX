package hrsys.dao;

import hrsys.vo.Admin;

public interface AdminDao {
	Admin selectAdmin(String adminName,String adminPwd);
}
