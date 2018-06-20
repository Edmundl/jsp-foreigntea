package server.servlet.evaluate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.teavaluateDao;
import server.entity.teaevaluate;

public class evaluateIServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public evaluateIServlet() {
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
         
         String action=request.getParameter("action");
         
         teaevaluate teaevaluate=new teaevaluate();
         teaevaluate.setTeanum(teanum);
         teaevaluate.setGrade(teagrade);
         teaevaluate.setGradetxt(gradetxt);
         
         teavaluateDao evaluateDAO=new teavaluateDao();
         evaluateDAO.addevaluate(teaevaluate);
         if(action.equals("1")){
        	 response.sendRedirect("teaevaluateM.jsp");
         }else if(action.equals("2")){
        	 response.sendRedirect("assistant.jsp");
         }
         
    }
}
