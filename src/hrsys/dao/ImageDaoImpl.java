package hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import hrsys.vo.Image;

public class ImageDaoImpl implements ImageDao {

	@Override
	public int insertImg(Image image) {
		String sql = "INSERT INTO images(Employee_id,imgUrl) VALUES (?,?);";
		Object[] paramters = {image.getEmpNo(),image.getImgUrl()};
		return Dbutil.executeUpdate(sql, paramters);
	}

	@Override
	public List<Image> selectAll() {
		String sql = "SELECT * FROM images ;";
		RowMapper<Image> rm = (rs)->{
			Image image = new Image();
			try {
				image.setEmpNo(rs.getInt("Employee_id"));
				image.setImgId(rs.getInt("imgId"));
				image.setImgUrl(rs.getString("imgUrl"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return image;
		};
		Dbutil<Image> dbutil = new Dbutil<Image>();
		return dbutil.executeQuery(sql, null, rm);
	}

}
