package server.servlet.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.dao.lessonDao;
import server.entity.lesson;

public class applayservelet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public String timeall="";
    
    public applayservelet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
         String teanum =  (String)session.getAttribute("teanum");
         String subject=request.getParameter("subject");
         String time[] =request.getParameterValues("time");
         for(int i=0;i<time.length;i++){
        	 timeall=timeall+time[i];
         }
         lesson lesson=new lesson();
         lesson.setSubject(subject);
         lesson.setTime(timeall);
         lesson.setTeanum(teanum);
         lesson.setStatus("ÉóºËÖÐ");
         lessonDao lessonDAO=new lessonDao();
         lessonDAO.applaylesson(lesson);
         response.sendRedirect("indexapply.jsp");
    }
}