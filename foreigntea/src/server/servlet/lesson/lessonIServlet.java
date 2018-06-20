package server.servlet.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.lessonDao;
import server.entity.lesson;

public class lessonIServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public String timeall="";
    
    public lessonIServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
         
         String dept=request.getParameter("dept");
         String classes=request.getParameter("classes");
         String subject=request.getParameter("subject");
         
         String place=request.getParameter("place");
         String teanum=request.getParameter("teanum");
         
         String time[] =request.getParameterValues("time");
         for(int i=0;i<time.length;i++){
        	 timeall=timeall+time[i];
         }
         lesson lesson=new lesson();
         lesson.setDept(dept);
         lesson.setClasses(classes);
         lesson.setSubject(subject);
         lesson.setTime(timeall);
         lesson.setPlace(place);
         lesson.setTeanum(teanum);
         lesson.setStatus("ÉóºËÖÐ");
         lessonDao lessonDAO=new lessonDao();
         lessonDAO.addlesson(lesson);
         response.sendRedirect("lessonM.jsp");
    }
}
