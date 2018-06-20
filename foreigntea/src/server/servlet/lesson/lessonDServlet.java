package server.servlet.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.lessonDao;

public class lessonDServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public lessonDServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPost(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
		lessonDao lessonDAO=new lessonDao();
		lessonDAO.deletelesson(id);
		System.out.println("É¾³ý³É¹¦");
        request.getRequestDispatcher("lessonM.jsp").forward(request, response);
    }
}
