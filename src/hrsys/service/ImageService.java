package hrsys.service;

import java.util.List;

import hrsys.vo.Image;

public interface ImageService {
	int insertImg(Image image);
	List<Image> selectAll();
}
