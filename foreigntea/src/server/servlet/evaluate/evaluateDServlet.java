package server.servlet.evaluate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import server.dao.teavaluateDao;

public class evaluateDServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    public evaluateDServlet() {
        super();
        // TODO Auto-generated constructor stub  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
            doPost(request, response);
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        String teanum = request.getParameter("teanum");
		teavaluateDao teavaluatedao=new teavaluateDao();
		teavaluatedao.deleteevalueate(teanum);
		System.out.println("É¾³ý³É¹¦");
        request.getRequestDispatcher("teaevaluateM.jsp").forward(request, response);
    }
}
