package server.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.userDao;

public class userDServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public userDServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPost(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
		userDao userdao=new userDao();
		userdao.deleteUser(username);
		System.out.println("É¾³ý³É¹¦");
        request.getRequestDispatcher("userM.jsp").forward(request, response);
    }
}
