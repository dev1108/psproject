import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewUser n1 = new NewUser("Rakesh","rakesh@rtr","+98-9898-898");
		new DBOperation().insertNewUser(n1);
		System.out.println(n1);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
<<<<<<< HEAD
		out.println("<form action='uportal' method='post' style='text-align: centre;margin-left: 10cm;'>");
		out.println("<h1 >Welcome to User Management Systems</h1>");
		out.println("<input style='text-align: centre;margin-left: 6cm;' type='submit' value='log In'>");
		out.println("<br>");
		out.println("</form>");
		System.out.println("Hello");
		out.println("<form action='signup' method='post' style='text-align: centre;margin-left: 10cm;'>");
		out.println("<br><input style='text-align: centre;margin-left: 5cm;' type='submit' value='New User? Sign up!'>");
		out.println("</form>");
=======
		  out.println("<form action='uportal' method='post' style='text-align: centre;margin-left: 10cm;'>");
		        out.println("<h1 >Welcome to User Management Systems</h1>");
		        out.println("<input style='text-align: centre;margin-left: 6cm;' type='submit' value='Log In'>");
		        out.println("<br>");
		        out.println("</form>");
		        
		        out.println("<form action='signup' method='post' style='text-align: centre;margin-left: 10cm;'>");
		        out.println("<br><input style='text-align: centre;margin-left: 5cm;' type='submit' value='New User? Sign up!'>");
		        out.println("</form>");
		
>>>>>>> deeshu
		
	}
}
