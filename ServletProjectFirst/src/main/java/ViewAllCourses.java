
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllCourses")
public class ViewAllCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String[] course = null;
		String publishedDate = null;
		int counter = 0;
		try {
			Connection conn = ConnectionPg.getConnection();

			PreparedStatement pst1 = conn.prepareStatement("select max(id) as id from courses");
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {
				counter = rs1.getInt(1);
			}

			
		
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Welcome to User Management System</title>\r\n"
				+ "<style>\r\n"
				+ "* {\r\n"
				+ "	margin: 0px;\r\n"
				+ "	padding: 0px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body {\r\n"
				+ "	background-image: url('image/home.jpg');\r\n"
				+ "	background-repeat: no-repeat;\r\n"
				+ "	background-attachment: fixed;\r\n"
				+ "	background-size: cover;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn {\r\n"
				+ "	width: 200px;\r\n"
				+ "	height: 35px;\r\n"
				+ "	margin-top: 0px;\r\n"
				+ "	background-color: transparent;\r\n"
				+ "	color: white;\r\n"
				+ "	border: none;\r\n"
				+ "	border-radius: 5px;\r\n"
				+ "	border: 2px solid green;\r\n"
				+ "	transition: 0.8s ease-out;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".btn:hover {\r\n"
				+ "	background-color: darkgreen;\r\n"
				+ "	color: white;\r\n"
				+ "	border: green;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "	width: 100%;\r\n"
				+ "	height: 100vh;\r\n"
				+ "	background-color: black;\r\n"
				+ "	opacity: 0.8;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".courseButton {\r\n"
				+ "	display: flex;\r\n"
				+ "	text-align: center;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "h2 {\r\n"
				+ "	padding-top: 150px;\r\n"
				+ "	font-size: 40px;\r\n"
				+ "	font-family: cursive;\r\n"
				+ "	animation-name: texthead;\r\n"
				+ "	animation-duration: 4s;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@\r\n"
				+ "keyframes texthead {\r\n"
				+ "	from {color: red;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "to {\r\n"
				+ "	color: green;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ ".btn {\r\n"
				+ "	position: relative;\r\n"
				+ "	animation-name: btnanimate;\r\n"
				+ "	animation-duration: 3s;\r\n"
				+ "	animation-fill-mode: forwards;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "@\r\n"
				+ "keyframes btnanimate {\r\n"
				+ "	from {top: 0px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "to {\r\n"
				+ "	top: 50px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ ".btn {\r\n"
				+ "	margin-top: 20px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "#course {\r\n"
				+ "	font-family: Arial, Helvetica, sans-serif;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "	width: 40%;\r\n"
				+ "	\r\n"
				+ "	background-color: silver;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "#course td, #course th {\r\n"
				+ "	border: 1px solid #ddd;\r\n"
				+ "	padding: 8px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* #course tr:nth-child(even){background-color: #f2f2f2;} \r\n"
				+ "\r\n"
				+ "#course tr:hover {background-color: #ddd;} */\r\n"
				+ "#course th {\r\n"
				+ "	padding-top: 12px;\r\n"
				+ "	padding-bottom: 12px;\r\n"
				+ "	text-align: left;\r\n"
				+ "	background-color: #04AA6D;\r\n"
				+ "	color: white;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"container\" align=center>\r\n"
				+ "		<div class=\"box\">\r\n"
				+ "			<h2 style=\"color: white;\">\r\n"
				+ "				Welcome to <span style=\"color: red;\">User Management</span> System\r\n"
				+ "			</h2>\r\n"
				+ "		</div>\r\n"
				+ "\r\n"
				
				+ "\r\n"
				+ "\r\n");
		
				pw.print("<h3 style = \"color: white; margin-top: 100px;\">All Courses</h3>\r\n"
				+ "\r\n"
				+ "		<table id=\"course\">\r\n"
				+ "			<tr>\r\n"
				+ "				<th>S.No.</th>\r\n"
				+ "				<th>Course Name</th>\r\n"
				+ "				<th>Published Date</th>\r\n"
				+ "			</tr>\r\n");
				
				PreparedStatement pst = conn.prepareStatement("select course_name, published_date from courses where id = ?");
				int sno = 1;
				for (int i = 1; i <= counter; i++) {

					pst.setInt(1, i);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						Array c = rs.getArray("course_name");
						course = (String[]) c.getArray();
						publishedDate = rs.getString("published_date");
						
						  pw.print("<tr>\r\n");
						  pw.print("<td>"+sno+"</td>\r\n");
						  					  
						  for (String x : course) {
								pw.print("<td>"+x+"</td>\r\n");
							}
						  pw.print("<td>"+publishedDate+"</td>\r\n");	
						 
						  pw.print("</tr>\r\n");
						
					}
					sno++;
				}

			} catch (Exception e) {
				System.out.println(e);
			}
				 
				   
				pw.print("			\r\n"
				+ "\r\n"
				+ "		</table>\r\n"
				+ "		<form action=\"Login\" method=\"post\">\r\n"
				+ "			<button type=\"submit\" class=\"btn\">Login</button>\r\n"
				+ "		</form>\r\n"				
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
	}

}
