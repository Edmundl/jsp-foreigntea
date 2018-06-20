package server.servlet.evaluate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.teavaluateDao;
import server.entity.teaevaluate;

public class evaluateUServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public evaluateUServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPut(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        
         String teanum=request.getParameter("teanum");
         String teagrade=request.getParameter("teagrade");
         String gradetxt=request.getParameter("gradetxt");
         
         teaevaluate teaevaluate=new teaevaluate();
         teaevaluate.setTeanum(teanum);
         teaevaluate.setGrade(teagrade);
         teaevaluate.setGradetxt(gradetxt);
         teavaluateDao teavaluateDAO=new teavaluateDao();
         teavaluateDAO.updateevaluate(teaevaluate);
         System.out.println("ÐÞ¸Ä³É¹¦");
         response.sendRedirect("teaevaluateM.jsp");
    }
}
