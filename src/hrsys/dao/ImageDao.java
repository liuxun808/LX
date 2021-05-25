package hrsys.dao;

import java.util.List;

import hrsys.vo.Image;

public interface ImageDao {
	int insertImg(Image image);
	List<Image> selectAll();
}
