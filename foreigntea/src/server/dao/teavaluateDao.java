package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import server.entity.teaevaluate;
import server.entity.teams;
import server.entity.user;
import server.util.DBUtil;

public class teavaluateDao {
	//��ʾ���ݿ���Ϣ
	public List<teaevaluate> getAllvaluate(){
		// T-SQL���
		String sql = "select * from teaevaluate";
		// �������
		Connection conn = DBUtil.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery();
			List<teaevaluate> list = new ArrayList<teaevaluate>();
			while (rs.next()) {
				// ��װ��Ϣ
				teaevaluate evaluate = new teaevaluate();
				evaluate.setTeanum(rs.getString(1));
				evaluate.setGrade(rs.getString(2));
				evaluate.setGradetxt(rs.getString(3));
				list.add(evaluate);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��������
    public void addevaluate(teaevaluate teaevaluate) {  
        Connection connection = null;
        PreparedStatement psmt = null;
        try {
             connection = DBUtil.getConnection();
             String sql  ="insert into foreigntea.teaevaluate(teanum,grade,gradetxt)values(?,?,?);";
             psmt = (PreparedStatement) connection.prepareStatement(sql);
             //����ʵ�������в�����ֵ  
             psmt.setString(1,teaevaluate.getTeanum());
             psmt.setString(2,teaevaluate.getGrade());
             psmt.setString(3,teaevaluate.getGradetxt());
             psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	DBUtil.close(psmt, connection, null);
        }  
    }
	
	//ɾ������
    public boolean deleteevalueate(String teanum) {
		String sql = "delete from teaevaluate WHERE teanum=?";
		
		Connection conn = DBUtil.getConnection();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teanum);
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
    
  //��������
    public void updateevaluate(teaevaluate teaevaluate) {
    	Connection connection = null;
        PreparedStatement psmt = null;

		try {
			// ���Ԥ�������
			connection = DBUtil.getConnection();
			String sql = "update teaevaluate set grade=?,gradetxt=? where teanum=?";
			psmt = connection.prepareStatement(sql);
			// �����޸Ĳ���
			psmt.setString(1,teaevaluate.getGrade());
			psmt.setString(2,teaevaluate.getGradetxt());
			psmt.setString(3,teaevaluate.getTeanum());
			psmt.executeUpdate();
		}catch(SQLException e){
			 e.printStackTrace();
		}finally{
			DBUtil.close(psmt, connection, null);
		}
    }
	
}
