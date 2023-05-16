

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginError
 */
@WebServlet("/LoginError")
public class LoginError extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Printing error of login section
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Error</title>\r\n"
				+ "<style>\r\n"
				+ "	.container{\r\n"
				+ "		text-align: center;\r\n"
				+ "		margin-top: 150px;\r\n"
				+ "		\r\n"
				+ "	}\r\n"
				+ "	h2{\r\n"
				+ "		color: red;\r\n"
				+ "	}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "		<div class = \"container\">\r\n"
				+ "			<img src = 'google error.gif' width = 'auto' height ='200px'>\r\n"
				+ "			<h2>Invalid username or password !</h2>\r\n"
				+ "		</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		pw.print("<center><form action = 'Login' method = 'post'><button type = 'submit'>Try Agin</button></form>");
		
	}

}
