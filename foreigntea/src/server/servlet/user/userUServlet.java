package server.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.userDao;
import server.entity.user;

public class userUServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public userUServlet() {
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
         user user=new user();
         user.setUsername(username);
         user.setPassword(password);
         user.setIdentity(iden);
         user.setTeanum(teanum);
         userDao userDAO=new userDao();
         userDAO.updateUser(user);
         System.out.println("ÐÞ¸Ä³É¹¦");
         request.getRequestDispatcher("userM.jsp").forward(request, response);
    }
}
