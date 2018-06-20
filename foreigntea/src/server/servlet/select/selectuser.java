package server.servlet.select;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.selectDao;
import server.entity.select;

public class selectuser extends HttpServlet{
	public selectuser() {
        super();
        // TODO Auto-generated constructor stub  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        doPut(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        String type=request.getParameter("type");
        String value=new String(request.getParameter("value").getBytes("ISO8859-1"),"UTF-8");
//        System.out.println(type);
//        System.out.println(value);
        select select=new select();
        select.setType(type);
        select.setValue(value);
        selectDao selectDAO=new selectDao();
        selectDAO.selectuser(type,value);
        System.out.println("0"+"selectuser.jsp?type="+type+"&value="+value+" ");
        response.sendRedirect("selectuser.jsp?type="+type+"&value="+ java.net.URLEncoder.encode(value,"UTF-8")+" ");
 }
}
