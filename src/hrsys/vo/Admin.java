package hrsys.vo;

public class Admin {
	String adminName;
	String adminPwd;
	int adminLevel;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAdminLevel() {
		return adminLevel;
	}
	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
	public Admin(String adminName, String adminPwd, int adminLevel) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminLevel = adminLevel;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
