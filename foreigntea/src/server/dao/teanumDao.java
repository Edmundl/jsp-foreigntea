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
	//��ʾ���ݿ���Ϣ
			public List<user> getAllteanum(){
				// T-SQL���
				String sql = "select * from user where identity='2'";
				// �������
				Connection conn = DBUtil.getConnection();
				try {
					// ���Ԥ�������
					PreparedStatement pstmt = conn.prepareStatement(sql);
					// ִ�в�ѯ
					ResultSet rs = pstmt.executeQuery();
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						// ��װ��Ϣ
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
