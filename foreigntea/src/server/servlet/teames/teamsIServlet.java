package server.servlet.teames;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.teamsDao;
import server.entity.teams;

public class teamsIServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public String timeall="";
    
    public teamsIServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
         
         String teanum=request.getParameter("teanum");
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
         
         System.out.println(teanum);
         teams teams=new teams();
         teams.setName(teaname);
         teams.setSex(teasex);
         teams.setAge(teaage);
         teams.setTel(tel);
         teams.setEmail(email);
         teams.setPosition(position);
         teams.setCompany(company);
         teams.setYear(year);
         teams.setTime(timeall);
         teams.setTeanum(teanum);
         teamsDao teamsDAO=new teamsDao();
         teamsDAO.addTeams(teams);
         response.sendRedirect("teamsM.jsp");
    }
}