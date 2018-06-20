package server.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public static  Connection getConnection(){//得到数据库连接
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/foreigntea","root","root");	
			return conn;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭的方法 
    public static void close(PreparedStatement preparedStatement,Connection conn,ResultSet resultSet){  
           if(preparedStatement !=null){
               try {
            	   	preparedStatement.close();
               } catch (SQLException e) {
            	   	e.printStackTrace();
               	 }
           }
           if(conn !=null){
               try {
            	   conn.close();
               } catch (SQLException e) {
               			e.printStackTrace();
               	 }
           }
           if(resultSet!=null){
               try {
            	   resultSet.close();
               } catch (SQLException e) {
            	   e.printStackTrace();
               }
           }
    }
}
