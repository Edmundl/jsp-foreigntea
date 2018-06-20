package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.user;
import server.util.DBUtil;

public class teanumDao {
	//显示数据库信息
			public List<user> getAllteanum(){
				// T-SQL语句
				String sql = "select * from user where identity='2'";
				// 获得连接
				Connection conn = DBUtil.getConnection();
				try {
					// 获得预定义语句
					PreparedStatement pstmt = conn.prepareStatement(sql);
					// 执行查询
					ResultSet rs = pstmt.executeQuery();
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						// 封装信息
						user user = new user();
						user.setTeanum(rs.getString(4));
						list.add(user);
					}
					conn.close();
					return list;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
}
