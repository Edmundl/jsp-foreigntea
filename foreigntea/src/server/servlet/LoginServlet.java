package server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.LoginDao;
import server.entity.user;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;  
    
    /** 
     * @see HttpServlet#HttpServlet() 
     */  
    public LoginServlet() {  
        super();  
        // TODO Auto-generated constructor stub  
    }  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
         doPost(request, response);  
       }    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        
        request.getSession().setAttribute("uname", username);
        
        String password = request.getParameter("password");
        String iden = request.getParameter("iden");
        System.out.println(iden);
        LoginDao loginDAO=new LoginDao();
        user user=loginDAO.login(username,password,iden);
        if(user!=null){
        	if(iden.equals("管理员")){
        		request.getRequestDispatcher("userM.jsp").forward(request, response);
        	}else if(iden.equals("外聘教师")){
        		request.getSession().setAttribute("teanum", user.teanum);
        		request.getRequestDispatcher("indexperinfo.jsp").forward(request, response);
        	}else if(iden.equals("教学助理")){
        		request.getRequestDispatcher("assistant.jsp").forward(request, response);
        	}
        }else{  
            request.getRequestDispatcher("error.jsp").forward(request, response);  
        }
    }
}
