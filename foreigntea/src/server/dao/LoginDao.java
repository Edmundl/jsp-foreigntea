package server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import server.entity.user;
import server.util.DBUtil;

public class LoginDao {
	public String i;
	//���ݿ����Ӷ���  (�жϵ�¼)
    public user login(String username,String password,String iden) {
//    	System.out.println(username);
//    	System.out.println(password);
//    	System.out.println(iden);
    	if(iden.equals("����Ա")){
    		i="1";
    	}else if(iden.equals("��Ƹ��ʦ")){
    		i="2";
    	}else if(iden.equals("��ѧ����")){
    		i="3";
    	}
       user u=null;
       Connection connection =null;
       PreparedStatement pstmt=null;
       ResultSet resultSet=null;
      try {
			connection=DBUtil.getConnection();
			String sql = "select * from foreigntea.user where username=? and password=? and identity=?";
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, i);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){  
				u=new user();
				u.setUsername(resultSet.getString("username"));
				u.setPassword(resultSet.getString("password"));
				u.setIdentity(resultSet.getString("identity"));
				u.setTeanum(resultSet.getString("teanum"));
				System.out.println("��¼�ɹ���");
			}else{  
				System.out.println("�û����������ʹ����ݴ���");  
			}    
      } catch (SQLException e) {  
    	  	e.printStackTrace();  
      }finally {    
    	  	DBUtil.close(pstmt, connection, resultSet);    
      }  
      	return u;
    }  
}