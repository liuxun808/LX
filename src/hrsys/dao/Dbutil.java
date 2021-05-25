package hrsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Dbutil<T> {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/hrsys";
	private static final String USER_NAME="root";
	private static final String PASSWORD="root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取数据库连接对象
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	//关闭conn
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement psmt) {
		try {
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}
	public static void close(Connection conn,PreparedStatement psmt,ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn,psmt);
	}
    //增、删、改
	public static int executeUpdate(String sql,Object[]paramters) {
		Connection conn=getConnection();
		PreparedStatement psmt=null;
		try {
			psmt=conn.prepareStatement(sql);
			for (int i = 0; i < paramters.length; i++) {
				psmt.setObject(i+1, paramters[i]);
				
			}
			return psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}finally {
			close(conn, psmt);
		}
	}
    //查询方法的封装，返回对象集合
	public  List<T> executeQuery(String sql,Object[]paramters,RowMapper<T> rm){
    	List<T> lists=new ArrayList<T>();
    	Connection conn=null;
    	PreparedStatement psmt=null;
    	ResultSet rs=null;
    	conn=Dbutil.getConnection();
    	try {
			psmt=conn.prepareStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					psmt.setObject(i+1, paramters[i]);
				}
			}
			rs=psmt.executeQuery();
			while(rs.next()) {
				//调用接口方法封装对象
				T obj=rm.getOneObject(rs);
				//将封装好的对象添加到集合里
				lists.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
    	return lists;
    }
	 //查询方法封装，返回一个对象
	public T executeQueryOne(String sql,Object[]paramters,RowMapper<T> rm){
    	T obj=null;
    	Connection conn=null;
    	PreparedStatement psmt=null;
    	ResultSet rs=null;
    	conn=Dbutil.getConnection();
    	try {
			psmt=conn.prepareStatement(sql);
			if (paramters != null) {
				for (int i = 0; i < paramters.length; i++) {
					psmt.setObject(i+1, paramters[i]);
				}
			}
			
			rs=psmt.executeQuery();
			if(rs.next()) {
				//调用接口方法封装对象
				obj=rm.getOneObject(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
    	return obj;
    }
}
