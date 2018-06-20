package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.teams;
import server.util.DBUtil;

public class teamsDao {
	//显示数据库信息
			public List<teams> getAlluser(){
				// T-SQL语句
				String sql = "select * from teames";
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
			//增加教师
		    public void addTeams(teams teams) {  
		        Connection connection = null;
		        PreparedStatement psmt = null;
		        try {
		             connection = DBUtil.getConnection();
		             String sql  ="insert into foreigntea.teames(name,sex,age,tel,email,position,company,year,time,teanum)values(?,?,?,?,?,?,?,?,?,?);";
		             psmt = (PreparedStatement) connection.prepareStatement(sql);
		             //运用实体对象进行参数赋值  
		             psmt.setString(1, teams.getName());
		             psmt.setString(2, teams.getSex());
		             psmt.setInt(3, teams.getAge());
		             psmt.setString(4, teams.getTel());
		             psmt.setString(5, teams.getEmail());
		             psmt.setString(6, teams.getPosition());
		             psmt.setString(7, teams.getCompany());
		             psmt.setInt(8, teams.getYear());
		             psmt.setString(9, teams.getTime());
		             psmt.setString(10, teams.getTeanum());
		             psmt.executeUpdate();
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }finally {
		        	DBUtil.close(psmt, connection, null);
		        }  
		    }
		  //删除教师
		    public boolean deleteteams(String id) {
				String sql = "delete from teames WHERE id=?";
				
				Connection conn = DBUtil.getConnection();
				try {
					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					if (pstmt.executeUpdate() > 0) {
						conn.close();
						return true;
					} else {
						conn.close();
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
		  //更新教师
		    public void updateTeams(teams teams) {
		    	Connection connection = null;
		        PreparedStatement psmt = null;
		        System.out.println("1"+teams.getId());
				try {
					// 获得预定义语句
					connection = DBUtil.getConnection();
					String sql = "update teames set name=?,sex=?,age=?,tel=?,email=?,position=?,company=?,year=?,time=?,teanum=? where id=?";
					psmt = connection.prepareStatement(sql);
					// 设置修改参数
					psmt.setString(1,teams.getName());
					psmt.setString(2,teams.getSex());
					psmt.setInt(3,teams.getAge());
					psmt.setString(4, teams.getTel());
					psmt.setString(5, teams.getEmail());
					psmt.setString(6, teams.getPosition());
					psmt.setString(7,teams.getCompany());
					psmt.setInt(8, teams.getYear());
					psmt.setString(9, teams.getTime());
					psmt.setString(10, teams.getTeanum());
					psmt.setInt(11, teams.getId());
					psmt.executeUpdate();
				}catch(SQLException e){
					 e.printStackTrace();
				}finally{
					DBUtil.close(psmt, connection, null);
				}
		    }   
		    
}
