package hrsys.service;

import java.util.List;

import hrsys.dao.ImageDao;
import hrsys.dao.ImageDaoImpl;
import hrsys.vo.Image;

public class ImageServiceImpl implements ImageService {
	private ImageDao dao = new ImageDaoImpl();
	@Override
	public int insertImg(Image image) {
		// TODO Auto-generated method stub
		return dao.insertImg(image);
	}

	@Override
	public List<Image> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
