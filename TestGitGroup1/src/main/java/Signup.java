import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		  out.println("<form action='uportal' method='post' style='text-align: centre;margin-left: 10cm;'>");
		        out.println("<h1 >Welcome to User Management Systems</h1>");
		        out.println("<input style='text-align: centre;margin-left: 7cm;' type='submit' value='logout'>");
		        out.println("</form>");
		
	}

}
