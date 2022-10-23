package data.api.json;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data.do")
public class ServletAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAPI() {
       
	    super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	 response.setContentType("test/html;charset=UTF-8");

	 String command = request.getParameter("command");

	 if(command.equals("list")) {
		 response.sendRedirect("dataList.jsp");
	 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
