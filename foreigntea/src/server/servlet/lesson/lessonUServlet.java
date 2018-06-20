package server.servlet.lesson;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.lessonDao;
import server.entity.lesson;

public class lessonUServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public String timeall="";
    
    public lessonUServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");

         int id=Integer.valueOf(request.getParameter("id"));
         String dept=request.getParameter("dept");
         String classes=request.getParameter("classes");
         String subject=request.getParameter("subject");
         String place=request.getParameter("place");
         String teanum=request.getParameter("teanum");
         String status=request.getParameter("status");
         
         timeall="";
         String time[] =request.getParameterValues("time");
         for(int i=0;i<time.length;i++){
        	 timeall=timeall+time[i];
         }
         
         lesson lesson=new lesson();
         lesson.setId(id);
         lesson.setDept(dept);
         lesson.setClasses(classes);
         lesson.setSubject(subject);
         lesson.setTime(timeall);
         lesson.setPlace(place);
         lesson.setTeanum(teanum);
         lesson.setStatus(status);
         lessonDao lessonDAO=new lessonDao();
         lessonDAO.updatelesson(lesson);
         System.out.println("ÐÞ¸Ä³É¹¦");
         request.getRequestDispatcher("lessonM.jsp").forward(request, response);
    }
}
