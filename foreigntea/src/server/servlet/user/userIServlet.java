package server.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.userDao;
import server.entity.user;

public class userIServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public userIServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
         
         String username=request.getParameter("uname");
         String password=request.getParameter("pwd");
         String iden=request.getParameter("iden");
         String teanum=request.getParameter("teanum");
         System.out.println(username);
         System.out.println(iden);
         System.out.println(password);
         System.out.println(teanum);
         user user=new user();
         user.setUsername(username);
         user.setPassword(password);
         user.setIdentity(iden);
         user.setTeanum(teanum);
         userDao userDAO=new userDao();
         userDAO.addUser(user);
         response.sendRedirect("userM.jsp");
    }
}
