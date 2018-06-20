package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.lesson;
import server.entity.teams;
import server.entity.user;
import server.util.DBUtil;

public class selectDao {
	//显示数据库信息
		public List<user> selectuser(String type,String value){
			// T-SQL语句
//			System.out.println(type);
//			System.out.println(value);
			String sql = "select * from foreigntea.user where "+type+"='"+value+"'";
			System.out.println(sql);
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
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setIdentity(rs.getString(3));
					list.add(user);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//显示数据库信息
				public List<teams> selecttea(String type,String value){
					// T-SQL语句
//					System.out.println(type);
//					System.out.println(value);
					String sql = "select * from foreigntea.teames where "+type+"='"+value+"'";
					System.out.println(sql);
					// 获得连接
					Connection conn = DBUtil.getConnection();
					try {
						// 获得预定义语句
						PreparedStatement pstmt = conn.prepareStatement(sql);
						// 执行查询
						ResultSet rs = pstmt.executeQuery();
						List<teams> list = new ArrayList<teams>();
						while (rs.next()) {
							// 封装信息
							teams teams = new teams();
							teams.setTeanum(rs.getString(1));
							teams.setName(rs.getString(2));
							teams.setSex(rs.getString(3));
							teams.setAge(rs.getInt(4));
							teams.setTel(rs.getString(5));
							teams.setEmail(rs.getString(6));
							teams.setPosition(rs.getString(7));
							teams.setCompany(rs.getString(8));
							teams.setYear(rs.getInt(9));
							list.add(teams);
						}
						conn.close();
						return list;
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return null;
				}
				
				//显示数据库信息
				public List<lesson> selectlesson(String type,String value){
					// T-SQL语句
//					System.out.println(type);
//					System.out.println(value);
					String sql = "select * from foreigntea.lesson where "+type+"='"+value+"'";
					System.out.println(sql);
					// 获得连接
					Connection conn = DBUtil.getConnection();
					try {
						// 获得预定义语句
						PreparedStatement pstmt = conn.prepareStatement(sql);
						// 执行查询
						ResultSet rs = pstmt.executeQuery();
						List<lesson> list = new ArrayList<lesson>();
						while (rs.next()) {
							// 封装信息
							lesson lesson = new lesson();
							lesson.setId(rs.getInt(1));
							lesson.setDept(rs.getString(2));
							lesson.setClasses(rs.getString(3));
							lesson.setSubject(rs.getString(4));
							lesson.setTime(rs.getString(5));
							lesson.setPlace(rs.getString(6));
							lesson.setTeanum(rs.getString(7));
							list.add(lesson);
						}
						conn.close();
						return list;
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return null;
				}
}
