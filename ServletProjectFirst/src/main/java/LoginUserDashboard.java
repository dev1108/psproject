

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUserDashboard
 */
@WebServlet("/LoginUserDashboard")
public class LoginUserDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("uname");
//		String password = request.getParameter("pass");
		
		pw.print("<html><head></head><body bgcolor='#161b22' style = 'color: silver;'>");
		pw.print("<h2><center>Hello, " + username);
		pw.print("<h3><center>Welcome to User Management System<br>");
		pw.print("<center><form action= 'Login' method = 'post'><button type = 'submit' >Logout</button></form>");
		
		
		
		// Preventing from getting back to previous page
		pw.print("<script type = \"text/javascript\" >  \r\n"
				+ "    function preventBack() { window.history.forward(); }  \r\n"
				+ "    setTimeout(\"preventBack()\", 0);  \r\n"
				+ "    window.onunload = function () { null };  \r\n"
				+ "</script>");
	}
	}

