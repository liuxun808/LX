package hrsys.dao;

import java.sql.SQLException;

import hrsys.vo.Admin;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin selectAdmin(String adminName, String adminPwd) {
		String sql = "SELECT * FROM admin WHERE Adminname = ? AND Adminpwd = ?;";
		Object[] paramters = {adminName,adminPwd};
		RowMapper<Admin> rm = (rs)->{
			Admin admin = new Admin();
			try {
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setAdminLevel(rs.getInt("adminLevel"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return admin;
		};
		Dbutil<Admin> dbutil = new Dbutil<Admin>();
		return dbutil.executeQueryOne(sql, paramters, rm);
	}

}
