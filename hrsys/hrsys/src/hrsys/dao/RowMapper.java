package hrsys.dao;

import java.sql.ResultSet;

public interface RowMapper<T> {
	
	T getOneObject(ResultSet rs);
}
