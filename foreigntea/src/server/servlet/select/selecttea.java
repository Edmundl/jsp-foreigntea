package server.servlet.select;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.selectDao;
import server.entity.select;

public class selecttea extends HttpServlet{
	public selecttea() {
        super();
        // TODO Auto-generated constructor stub  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doPut(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        String value=request.getParameter("value");
        System.out.println(value);
        select select=new select();
        select.setType(type);
        select.setValue(value);
        selectDao selectDAO=new selectDao();
        selectDAO.selecttea(type,value);
        response.sendRedirect("selecttea.jsp?type="+type+"&value="+ java.net.URLEncoder.encode(value,"UTF-8")+" ");
 }
}
