package server.servlet.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.lessonDao;

public class cancleapplay extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public cancleapplay() {
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
		System.out.println("ɾ���ɹ�");
        request.getRequestDispatcher("indexExinfo.jsp").forward(request, response);
    }
}
