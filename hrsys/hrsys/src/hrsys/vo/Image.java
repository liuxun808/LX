package hrsys.vo;

public class Image {
	private int imgId;
	private int empNo;
	private String imgUrl;
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Image(int imgId, int empNo, String imgUrl) {
		super();
		this.imgId = imgId;
		this.empNo = empNo;
		this.imgUrl = imgUrl;
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
}
