package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.user;
import server.util.DBUtil;

public class userDao {
	public String i;
	public String iden;
	
	//��ʾ���ݿ���Ϣ
		public List<user> getAlluser(){
			// T-SQL���
			String sql = "select * from user";
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
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setIdentity(rs.getString(3));
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
		
		//ע���û�
	    public void registerUser(user user) {  
	        Connection connection = null;
	        PreparedStatement psmt = null;
	        try {
	             connection = DBUtil.getConnection();
	             String sql  ="insert into foreigntea.user(username,password,identity,teanum)values(?,?,?,?);";
	             psmt = (PreparedStatement) connection.prepareStatement(sql);
	             //����ʵ�������в�����ֵ  
	             psmt.setString(1, user.getUsername());
	             psmt.setString(2, user.getPassword());
	             psmt.setString(3, "2");
	             psmt.setString(4, user.getTeanum());
	             psmt.executeUpdate();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	        	DBUtil.close(psmt, connection, null);
	        }  
	    }
	
	//�����û�
    public void addUser(user user) {  
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
             connection = DBUtil.getConnection();
             String sql  ="insert into foreigntea.user(username,password,identity,teanum)values(?,?,?,?);";
               
             psmt = (PreparedStatement) connection.prepareStatement(sql);
             i=user.getIdentity();
             if(i.equals("����Ա")){
            	 iden="1";
             }else if(i.equals("��Ƹ��ʦ")){
            	 iden="2";
             }
             //����ʵ�������в�����ֵ  
             psmt.setString(1, user.getUsername());
             psmt.setString(2, user.getPassword());
             psmt.setString(3, iden);
             psmt.setString(4, user.getTeanum());
             psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(psmt, connection, null);
        }  
    }
    
  //ɾ���û�int userId
    public boolean deleteUser(String username) {
		
		String sql = "delete from user WHERE username=?";
		
		Connection conn = DBUtil.getConnection();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
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
    
  //�����û�
    public void updateUser(user user) {
    	Connection connection = null;
        PreparedStatement psmt = null;

		try {
			// ���Ԥ�������
			connection = DBUtil.getConnection();
			String sql = "update user set password=?,identity=?,teanum=? where username=?";
			psmt = connection.prepareStatement(sql);
			// �����޸Ĳ���
			psmt.setString(1,user.getPassword());
			psmt.setString(2,user.getIdentity());
			psmt.setString(3,user.getTeanum());
			psmt.setString(4,user.getUsername());
			psmt.executeUpdate();
		}catch(SQLException e){
			 e.printStackTrace();
		}finally{
			DBUtil.close(psmt, connection, null);
		}
    }
}
