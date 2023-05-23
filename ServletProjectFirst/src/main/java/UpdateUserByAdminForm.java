

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UpdateUserByAdmin")
public class UpdateUserByAdminForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		// Getting id from admin dash board 
					String updateId = request.getParameter("update");
					updateId = updateId.substring(1, updateId.length()-1);
					int d = Integer.parseInt(updateId);
					String name = null;
				    String email = null;
				    String mobile = null;
				    String dob = null;
					
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "admin";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			PreparedStatement ps = conn.prepareStatement("select name, email, mobile, dob from signup where id = ?");
			ps.setInt(1, d);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				name = rs.getString(1);
				email = rs.getString(2);
				mobile = rs.getString(3);
				dob = rs.getString(4);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Update user admin</title>\r\n"
				+ "<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n"
				+ "\r\n"
				+ "<style>\r\n"
				+ "body {\r\n"
				+ "	margin-top: 20px;\r\n"
				+ "	color: #e6edf3;\r\n"
				+ "	text-align: left;\r\n"
				+ "	background-color: #161b22;\r\n"
				+ "}\r\n"
				+ ".formDesign{\r\n"
				+ "	background-color: rgba(0, 10, 9, 0.25);\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "	padding: 20px;\r\n"
				+ "	margin-top: 100px;\r\n"
				+ "}\r\n"
				+ ".update{\r\n"
				+ "	width: 100%;\r\n"
				+ "	background-color: transparent;\r\n"
				+ "	border-radius: 20px; \r\n"
				+ "	transition: 0.5s ease-out;\r\n"
				+ "}\r\n"
				+ ".update:hover{\r\n"
				+ "	background-color: darkgreen;\r\n"
				+ "	border-color: darkgreen;\r\n"
				+ "	\r\n"
				+ "}\r\n"
				+ ".fistCircle{\r\n"
				+ "	position: absolute;\r\n"
				+ "	width: 150px;\r\n"
				+ "	height: 150px;\r\n"
				+ "	background-color: rgba(252, 0, 130, 0.99);\r\n"
				+ "	border: none;\r\n"
				+ "	border-radius: 200px;\r\n"
				+ "	top: 53px;\r\n"
				+ "	left: 705px;\r\n"
				+ "	box-shadow: rgba(252, 0, 130, 0.99) 0px 48px 100px 0px;	\r\n"
				+ "}\r\n"
				+ ".secondCircle{\r\n"
				+ "	position: absolute;\r\n"
				+ "	width: 150px;\r\n"
				+ "	height: 150px;\r\n"
				+ "	background-color: rgba(0, 252, 244, 0.99);\r\n"
				+ "	border: none;\r\n"
				+ "	border-radius: 200px;\r\n"
				+ "	top: 500px;\r\n"
				+ "	right: 705px;\r\n"
				+ "	box-shadow: rgba(0, 252, 244, 0.99) 0px 48px 100px 0px;	\r\n"
				+ "}\r\n"
				+ ".thirdCircle{\r\n"
				+ "	position: absolute;\r\n"
				+ "	width: 40px;\r\n"
				+ "	height: 40px;\r\n"
				+ "	background-color: rgba(249, 252, 0, 0.99);\r\n"
				+ "	border: none;\r\n"
				+ "	border-radius: 200px;\r\n"
				+ "	top: 150px;\r\n"
				+ "	right: 780px;\r\n"
				+ "	box-shadow: rgba(249, 252, 0, 0.99) 0px 48px 100px 0px;	\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "		<div class=\"fistCircle\"></div>\r\n"
				+ "		<div class=\"secondCircle\"></div>\r\n"
				+ "		<div class=\"thirdCircle\"></div>\r\n"
				+ "	<div class=\"container\">\r\n"
				+ "		<div class=\"row\">\r\n"
				+ "			<div class=\"col-md-4 mx-auto formDesign\">\r\n"
				+ "				<form action = 'UpdateUserByAdminAction' method= 'post'>\r\n"
				+ "					<div>\r\n"
				+ "						<h4 class = \"text-center\">Update User Details</h4>\r\n"
				+ "					</div>\r\n"
				+ "					<div class=\"form-group\">\r\n"
				+ "						<label>Name</label> \r\n");
								pw.print("<input	type=\"text\" value = "+ name +" name = \"name\" class=\"form-control bg-transparent text-white\" required>\r\n");
								pw.print("</div>\r\n"
				+ "					<div class=\"form-group\">\r\n"
				+ "						<label>Email</label>\r\n"
				+ "						 <input	type=\"email\" value = "+email+" name = \"email\" class=\"form-control bg-transparent text-white\" required>\r\n"
				+ "					</div>\r\n"
				+ "					<div class=\"form-group\">\r\n"
				+ "						<label>Mobile</label>\r\n"
				+ "						 <input	type=\"text\" value = "+mobile+" name = \"mobile\" class=\"form-control bg-transparent text-white\" pattern=\"[1-9]{1}[0-9]{9}\" minlength = \"10\" maxlength = \"10\" required>\r\n"
				+ "					</div>\r\n"
				+ "					<div class=\"form-group\">\r\n"
				+ "						<label>Date of Birth</label> \r\n"
				+ "						<input	type=\"date\" value = "+dob+" name = \"dob\" class=\"form-control bg-transparent text-white\" required>\r\n"
				+ "					</div>\r\n"
				+ "					\r\n"
				+ "					<button type=\"submit\"class=\"btn btn-primary update\">Update</button>\r\n"
				+ "				</form>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
								
								// Preventing from getting back to previous page
								pw.print("<script type = \"text/javascript\" >  \r\n"
										+ "    function preventBack() { window.history.forward(); }  \r\n"
										+ "    setTimeout(\"preventBack()\", 0);  \r\n"
										+ "    window.onunload = function () { null };  \r\n"
										+ "</script>");
	}

}
