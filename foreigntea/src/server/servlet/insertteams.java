package server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.dao.teamsDao;
import server.entity.teams;

public class insertteams extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public String timeall="";
    
    public insertteams() {
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
         
         String teaname=request.getParameter("teaname");
         String teasex=request.getParameter("teasex");
         int teaage=Integer.parseInt(request.getParameter("teaage"));
         String tel=request.getParameter("tel");
         String email=request.getParameter("email");
         String position=request.getParameter("position");
         String company=request.getParameter("company");
         int year=Integer.parseInt(request.getParameter("year"));
         String time[] =request.getParameterValues("time");
         for(int i=0;i<time.length;i++){
        	 timeall=timeall+time[i];
         }
         teams teams=new teams();
         teams.setTeanum(teanum);
         teams.setName(teaname);
         teams.setSex(teasex);
         teams.setAge(teaage);
         teams.setTel(tel);
         teams.setEmail(email);
         teams.setPosition(position);
         teams.setCompany(company);
         teams.setYear(year);
         teams.setTime(timeall);
         teamsDao teamsDAO=new teamsDao();
         teamsDAO.addTeams(teams);
         response.sendRedirect("indexperinfo.jsp");
    }
}
