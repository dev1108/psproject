

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailValidation
 */
@WebServlet("/EmailValidation")
public class EmailValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// Preventing from getting back to previous page
		pw.print("<script type = \"text/javascript\" >  \r\n"
				+ "    function preventBack() { window.history.forward(); }  \r\n"
				+ "    setTimeout(\"preventBack()\", 0);  \r\n"
				+ "    window.onunload = function () { null };  \r\n"
				+ "</script>");
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>SignUp Error</title>\r\n"
				+ "<style>\r\n"
				+ "* {\r\n"
				+ "	margin: 0px;\r\n"
				+ "	padding: 0px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body {\r\n"
				+ "	background: url(image/allbackground.jpg);\r\n"
				+ "	background-repeat: no-repeat;\r\n"
				+ "	background-attachment: fixed;\r\n"
				+ "	background-size: cover;\r\n"
				+ "	background-color: black;\r\n"
				+ "	color: black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".overlay {\r\n"
				+ "	background: rgba(0, 0, 0, 0.6);\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 100vh;\r\n"
				+ "	position: absolute;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "	width: 400px;\r\n"
				+ "	height: 40px;\r\n"
				+ " 	background-color: rgba(249, 11, 11, 0.1);\r\n"
				+ "	color: rgba(248, 0, 0, 1);\r\n"
				+ "	margin: auto;\r\n"
				+ "	margin-top: -100px;\r\n"
				+ "	padding: 10px;\r\n"
				+ "	position: relative;\r\n"
				+ "	top: 50%;\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	box-shadow: 5px 10px 15px rgba(249, 11, 11, 0.44) inset;\r\n"
				+ "	border: 1px solid red;\r\n"
				+ "	font-family: cursive;\r\n"
				+ "	\r\n"
				+ "	animation: zoom-in-zoom-out 2s ease infinite;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@keyframes zoom-in-zoom-out {\r\n"
				+ "  0% {\r\n"
				+ "    transform: scale(1, 1);\r\n"
				+ "  }\r\n"
				+ "  50% {\r\n"
				+ "    transform: scale(1.3, 1.3);\r\n"
				+ "  }\r\n"
				+ "  100% {\r\n"
				+ "    transform: scale(1, 1);\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ ".container h3{\r\n"
				+ "	margin-top: 6px;\r\n"
				+ "}\r\n"
				+ ".inneritem {\r\n"
				+ "	margin-top: 30px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".newuser {\r\n"
				+ "	width: 150px;\r\n"
				+ "	height: 30px;\r\n"
				+ "	border: 1px solid #0DFEE6;\r\n"
				+ "	background-color: transparent;\r\n"
				+ "	color: #0DFEE6;\r\n"
				+ "	border-radius: 30px;\r\n"
				+ "	transition-duration: 1s;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".newuser:hover {\r\n"
				+ "	background-color: rgba(2, 106, 1, 1);\r\n"
				+ "	border-color: rgba(2, 106, 1, 1);\r\n"
				+ "	color: white;\r\n"
				+ "}\r\n"
				+ ".previuosBtn{\r\n"
				+ "	margin-top: 490px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"overlay\">\r\n"
				+ "		<div class= \"container\" align=center>\r\n"
				+ "			<h3>Email already exist !</h3>\r\n"
				+ "		</div>\r\n"
				+ "		<div class = \"previuosBtn\" align=center>\r\n"
				+ "			<form action= \"SignUp\" method=\"post\">\r\n"
				+ "				<button type= \"submit\" class=\"newuser\">Back to SignUp</button>\r\n"
				+ "			</form>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}

}
