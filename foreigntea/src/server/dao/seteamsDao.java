package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.teams;
import server.util.DBUtil;

public class seteamsDao{
	//显示数据库信息
	public List<teams> getAlluser(String teanum){
		// T-SQL语句
		String sql = "select * from teames where teanum=?";
		// 获得连接
		Connection conn = DBUtil.getConnection();
		try {
			// 获得预定义语句
			System.out.println(teanum);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teanum);
			// 执行查询
			ResultSet rs = pstmt.executeQuery();
			List<teams> list = new ArrayList<teams>();
			while (rs.next()) {
				// 封装信息
				teams tea = new teams();
				tea.setId(rs.getInt(1));
				tea.setName(rs.getString(2));
				tea.setSex(rs.getString(3));
				tea.setAge(rs.getInt(4));
				tea.setTel(rs.getString(5));
				tea.setEmail(rs.getString(6));
				tea.setPosition(rs.getString(7));
				tea.setCompany(rs.getString(8));
				tea.setYear(rs.getInt(9));
				tea.setTime(rs.getString(10));
				tea.setTeanum(rs.getString(11));
				list.add(tea);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
