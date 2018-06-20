package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.lesson;
import server.entity.teams;
import server.util.DBUtil;

public class lessonDao {
	//��ʾ���ݿ���Ϣ
	public List<lesson> getAlluser(){
		// T-SQL���
		String sql = "select * from lesson";
		// �������
		Connection conn = DBUtil.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			List<lesson> list = new ArrayList<lesson>();
			while (rs.next()) {
				// ��װ��Ϣ
				lesson les = new lesson();
				les.setId(rs.getInt(1));
				les.setDept(rs.getString(2));
				les.setClasses(rs.getString(3));
				les.setSubject(rs.getString(4));
				les.setTime(rs.getString(5));
				les.setPlace(rs.getString(6));
				les.setTeanum(rs.getString(7));
				les.setStatus(rs.getString(8));
				list.add(les);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//��ʾ��Ƹ��Ϣ��
		public List<lesson> getSelect(String teanum){
			// T-SQL���
			String sql = "select * from lesson where teanum='"+teanum+"'";
			// �������
			Connection conn = DBUtil.getConnection();
			try {
				// ���Ԥ�������
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ִ�в�ѯ
				ResultSet rs = pstmt.executeQuery();
				List<lesson> list = new ArrayList<lesson>();
				while (rs.next()) {
					// ��װ��Ϣ
					lesson les = new lesson();
					les.setId(rs.getInt(1));
					les.setDept(rs.getString(2));
					les.setClasses(rs.getString(3));
					les.setSubject(rs.getString(4));
					les.setTime(rs.getString(5));
					les.setPlace(rs.getString(6));
					les.setTeanum(rs.getString(7));
					les.setStatus(rs.getString(8));
					list.add(les);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	//���ӿγ�
    public void addlesson(lesson lesson) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
             connection = DBUtil.getConnection();
             String sql  ="insert into foreigntea.lesson(dept,classes,subject,time,place,teanum,status)values(?,?,?,?,?,?,?);";
             psmt = (PreparedStatement) connection.prepareStatement(sql);
             //����ʵ�������в�����ֵ  
             psmt.setString(1, lesson.getDept());
             psmt.setString(2, lesson.getClasses());
             psmt.setString(3, lesson.getSubject());
             psmt.setString(4, lesson.getTime());
             psmt.setString(5, lesson.getPlace());
             psmt.setString(6, lesson.getTeanum());
             psmt.setString(7, lesson.getStatus());
             psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(psmt, connection, null);
        }  
    }
  //ɾ���γ�int Id
    public boolean deletelesson(int id) {
		
		String sql = "delete from lesson WHERE id=?";
		
		Connection conn = DBUtil.getConnection();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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
  //�������
    public void updatelesson(lesson lesson) {
    	Connection connection = null;
        PreparedStatement psmt = null;

		try {
			// ���Ԥ�������
			connection = DBUtil.getConnection();
			String sql = "update lesson set dept=?,classes=?,subject=?,time=?,place=?,teanum=?,status=? where id=?";
			psmt = connection.prepareStatement(sql);
			// �����޸Ĳ���
			psmt.setString(1,lesson.getDept());
			psmt.setString(2,lesson.getClasses());
			psmt.setString(3,lesson.getSubject());
			psmt.setString(4,lesson.getTime());
			psmt.setString(5,lesson.getPlace());
			psmt.setString(6,lesson.getTeanum());
			psmt.setString(7,lesson.getStatus());
			psmt.setInt(8,lesson.getId());
			psmt.executeUpdate();
		}catch(SQLException e){
			 e.printStackTrace();
		}finally{
			DBUtil.close(psmt, connection, null);
		}
    } 
    
  //����γ�
    public void applaylesson(lesson lesson) {
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
             connection = DBUtil.getConnection();
             String sql  ="insert into foreigntea.lesson(subject,time,teanum,status)values(?,?,?,?);";
             psmt = (PreparedStatement) connection.prepareStatement(sql);
             //����ʵ�������в�����ֵ  
             psmt.setString(1, lesson.getSubject());
             psmt.setString(2, lesson.getTime());
             psmt.setString(3, lesson.getTeanum());
             psmt.setString(4, lesson.getStatus());
             psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(psmt, connection, null);
        }  
    }
}
