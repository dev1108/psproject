

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		// fetching data from login
//		String username = request.getParameter("uname");
//		String password = request.getParameter("pass");
		
		response.setContentType("text/html"); 
		 
		
		//Fetching data from sign up
		String uname = request.getParameter("username");
		if (uname != null) {
			pw.println("<script type=\"text/javascript\">"); 
			pw.println("alert('You have registered successfully');"); 
			pw.println("</script>"); 
		}
				
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Login</title>	\r\n"
				+ "<style>\r\n"
				+ "* {\r\n"
				+ "	margin: 0px;\r\n"
				+ "	padding: 0px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body {\r\n"
				+ "	background: url(a.jpg);\r\n"
				+ "	background-repeat: no-repeat;\r\n"
				+ "	background-attachment: fixed;\r\n"
				+ "	background-size: cover;\r\n"
				+ "	background-color: black;\r\n"
				+ "	color: black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".overlay {\r\n"
				+ "	background: rgba(0, 0, 0, 0.5);\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 100vh;\r\n"
				+ "	position: absolute;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "	width: 360px;\r\n"
				+ "	height: 320px;\r\n"
				+ "	background-color: rgba(8, 215, 173, 0.18);\r\n"
				+ "	color: white;\r\n"
				+ "	margin: auto;\r\n"
				+ "	margin-top: -220px;\r\n"
				+ "	padding: 10px;\r\n"
				+ "	position: relative;\r\n"
				+ "	top: 50%;\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	box-shadow: 5px 10px 20px rgba(0, 230, 184, 0.96) inset;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".inneritem {\r\n"
				+ "	margin-top: 30px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input {\r\n"
				+ "	margin-bottom: 15px;\r\n"
				+ "	width: 300px;\r\n"
				+ "	height: 30px;\r\n"
				+ "	background-color: rgba(0, 0, 0, 0.25);\r\n"
				+ "	color: white;\r\n"
				+ "	font-size: 15px;\r\n"
				+ "	border: 1px solid silver;\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	caret-color: white;\r\n"
				+ "	padding: 3px;\r\n"
				+ "	padding-left: 10px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input[type=text]:focus {\r\n"
				+ "	border: 1px solid purple;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "h2 {\r\n"
				+ "	width: 50px;\r\n"
				+ "	height: 50px;\r\n"
				+ "	margin-top: -57px;\r\n"
				+ "	background-color: rgba(0, 155, 124, 0.96);\r\n"
				+ "	padding: 25px;\r\n"
				+ "	padding-right: 25px;\r\n"
				+ "	border-radius: 200px;\r\n"
				+ "	box-shadow: 5px, 5px, 7px, silver;\r\n"
				+ "}\r\n"
				+ ".btn{\r\n"
				+ "	width: 40%;\r\n"
				+ "	height: 30px;\r\n"
				+ "	border: 1px solid #0DFEE6;\r\n"
				+ "	background-color: transparent;\r\n"
				+ "	color: #0DFEE6;\r\n"
				+ "	border-radius: 30px;\r\n"
				+ "	transition-duration: 1s;\r\n"
				+ "}\r\n"
				+ ".btn:hover{\r\n"
				+ "	background-color: rgba(0, 155, 124, 0.96);\r\n"
				+ "	border-color: rgba(0, 155, 124, 0.96);\r\n"
				+ "	color: white\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".newuser{\r\n"
				+ "	margin-top: 20px;\r\n"
				+ "	background-color: transparent;\r\n"
				+ "	color: white;\r\n"
				+ "	transition-duration: 1s;\r\n"
				+ "	border: none;\r\n"
				+ "	padding: 5px;\r\n"
				+ "	border-radius: 20px;\r\n"
				+ "}\r\n"
				+ ".newuser:hover{\r\n"
				+ "	background-color: rgba(0, 155, 124, 0.96);\r\n"
				+ "	border-color: rgba(0, 155, 124, 0.96);\r\n"
				+ "}\r\n"
				+ "label{\r\n"
				+ "	color: #0DFEE6;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<div class = \"overlay\">\r\n"
				+ "	<div class=\"container\" align=center>\r\n"
				+ "	<h2>Sign In</h2>\r\n"
				+ "		<form action=\"LoginValidation\" method=\"post\">\r\n"
				+ "		\r\n"
				+ "			<div class=\"inneritem\">\r\n"
				+ "			\r\n"
				+ "				<table>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><label>Username</label></td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><input type=\"text\" name=\"uname\" placeholder = \"username\" required>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><label>Password</label></td>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><input type=\"password\" name=\"pass\" placeholder = \"password\" required>\r\n"
				+ "					</tr>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><button type=\"submit\" class = \"btn\">Login</button></td>\r\n"
				+ "					</tr>\r\n"
				+ "					\r\n"
				+ "				</table>\r\n"
				+ "			</div>\r\n"
				+ "		</form>\r\n"
				+ "		<form action= \"SignUp\" method= \"post\"><label >Are you new user? </label><button type = \"submit\" class = \"newuser\">Click here</button></form>\r\n"
				+ "	</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
//		if (username.equals("Heera") && password.equals("12345")) {
//			RequestDispatcher rd1 = request.getRequestDispatcher("LoginUserDashboard");
//			rd1.forward(request, response);
//		}
//		else {
//			
//			RequestDispatcher rd = request.getRequestDispatcher("LoginError");
//			rd.forward(request, response);
//		}
		
	}

}
