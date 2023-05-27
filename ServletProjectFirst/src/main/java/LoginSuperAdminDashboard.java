

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuperAdminDashboard
 */
@WebServlet("/LoginSuperAdminDashboard")
public class LoginSuperAdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
//      Getting admin data from database
      String namedb = null;
      String emaildb = null;
		
              
		int count = 0;
		try {
			Connection conn = ConnectionPg.getConnection(); // Calling static getConnection method using class name
			
			//Fetching admin data from database
			PreparedStatement pstmt = conn.prepareStatement("select name, email from signup where issuperadmin = ?");			
			pstmt.setInt(1, 1);			
			ResultSet rst = pstmt.executeQuery();
			
			while (rst.next()) {
				namedb = rst.getString(1);
				emaildb = rst.getString(2);
			}
					
			
			// Fetching max id from sign up table for auto increment id
			
			String query = "select max(id) as id from signup";
			Statement stmt = conn.createStatement();

			ResultSet rs1 = stmt.executeQuery(query);
			while (rs1.next()) {
				count = rs1.getInt("id");
			}
									
			
		
//		Table Data
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Super Admin Dashboard</title>\r\n"
				+ "<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<style>\r\n"
				+ "	body{\r\n"
				+ "		margin-top:20px;\r\n"
				+ "		color: #e6edf3;\r\n"
				+ "		text-align: left;\r\n"
				+ "		background-color: #161b22;\r\n"
				+ "	}\r\n"
				+ "	.design{\r\n"
				+ "		box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "	}\r\n"
				+ "	.greet{\r\n"
				+ "		box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "		padding-left: 100px;\r\n"
				+ "		background-color: rgba(255, 66, 170, 0.45);\r\n"
				+ "	}\r\n"
				+ ".profile {\r\n"
				+ "		position: absolute;\r\n"
				+ "		right: 120px;\r\n"
				+ "		top: 40px;\r\n"
				+ "		bottom: 40px;\r\n"
				+ "		font-weight: 400;\r\n"
				+ "		line-height: 10px;\r\n"
				+ "		margin-botton: 1px;\r\n"
				+ "	\r\n"
				+ "}\r\n"
				+ ".popup{\r\n"
				+ "	background-color: rgba(0, 10, 9, 0.78);\r\n"
				+ "	border-radius: 10px;\r\n"
				+ "	box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "	padding: 20px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".logout {\r\n"
				+ "		width: 150px;\r\n"
				+ "		height: 30px;\r\n"
				+ "		border: 1px solid silver;\r\n"
				+ "		border-radius: 20px;\r\n"
				+ "		color: white;\r\n"
				+ "		background-color: transparent;\r\n"
				+ "		transition: 0.5s ease-out;\r\n"
				+ "}\r\n"
				+ ".logout:hover{\r\n"
				+ "		background-color: #b23b3b;\r\n"
				+ "		border: 1px solid #b23b3b;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n");
				
				
				
			pw.print("<div class = \"container\">\r\n"
				+ "	<div class=\"row\">\r\n"
				+ "			<div class=\"col-md-12 mx-auto\">\r\n"
				+ "\r\n"
				+ "				<div class=\"jumbotron greet\">\r\n");
		
									pw.print("<h1 class=\"display-4 text-white\">Hello, <br><b>"+namedb+"!</b></h1>\r\n");
									pw.print("<div class = \"profile text-center\">\r\n"
											+ "		<img src=\"https://bootdey.com/img/Content/avatar/avatar7.png\" alt=\"Admin\" class=\"rounded-circle\" width=\"90\">\r\n");
											pw.print("<p class=\"text-white mt-2\">"+namedb+"</p>\r\n");
											pw.print("<p class=\"text-silver\">"+emaildb+"</p>\r\n");
											pw.print("<form action= 'Login' method = 'post'><button  type = \"submit\" class = \"logout\">Logout</button></form>\r\n"
											+ "	</div>");
									pw.print("</div>\r\n"
				+ "				</div>\r\n"
														
				+ "			<div class=\"col-md-12 mx-auto\">\r\n"
				
				// Admin table data
				+ "      <div>"
				+ "      <h3>List of Admin</h3>"
				
				+ "      </div>\r\n"
				+ "			<table class=\"table table-dark design text-center table-striped table-hover\">\r\n"
				+ "				<thead>\r\n"
				+ "					<tr>\r\n"
				+ "						<th scope=\"col\">S.No.</th>\r\n"
				+ "						<th scope=\"col\">Name</th>\r\n"
				+ "						<th scope=\"col\">Email</th>\r\n"
				+ "						<th scope=\"col\">Mobile</th>\r\n"
				+ "						<th scope=\"col\">Date of Birth</th>\r\n"
				+ "						<th scope=\"col\" colspan = 2>Action</th>\r\n"
				+ "					</tr>\r\n"
				+ "				</thead>\r\n"
				+ "				<tbody>\r\n");
									
									
								
		
//		Setting data into tabular format
		
				PreparedStatement ps = conn.prepareStatement("select name, email, mobile, dob from signup where id = ? AND isadmin = ? AND issuperadmin = ?");
				int sno = 1;
				int a;
				for (a = 1; a <= count; a++) {
							ps.setInt(1, a);
							ps.setBoolean(2, true);
							ps.setInt(3, 0);
							
							ResultSet rs = ps.executeQuery();
							while (rs.next()) {
								
								String name = rs.getString(1);
								String email = rs.getString(2);
								String mobile = rs.getString(3);
								String dob = rs.getString(4);
				
								pw.print("<tr>\r\n");
				
								pw.println("<th scope=\"row\">" + sno + "</th>\r\n");
								pw.print("<td>" + name + "</td>");
								pw.print("<td>" + email + "</td>");
								pw.print("<td>" + mobile + "</td>");
								pw.print("<td>" + dob + "</td>");
								pw.print("<td><form action ='UpdateUserBySuperAdminForm' method = 'post'><button type = 'submit' class = 'btn btn-primary'  value = \"+"+ a +"+\"+ name = 'update'>Update</button></form></td>");
								pw.print("<td><form action = 'DeleteUserBySuperAdmin' method = 'post'><button type = 'submit' class = 'btn btn-danger' value = '+"+ a +"+' name = 'delete'>Delete</button></form></td>");
				
								pw.print("</tr>\r\n");
								sno++;
							}	
							
						}
								
								pw.print("</tbody>\r\n"
				+ "			</table>\r\n");
								
								
								
		} catch (Exception e) {
			System.out.println(e);
		}	
				
								
								pw.print("<!-- Modal -->\r\n"
										+ "<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n"
										+ "  <div class=\"modal-dialog\" role=\"document\">\r\n"
										+ "    <div class=\"modal-content popup\">\r\n"
										+ "      <div class=\"modal-header\">\r\n"
										+ "        <h5 class=\"modal-title text-white\" id=\"exampleModalLabel\">Update Your Details</h5>\r\n"
										+ "        <button type=\"button\" class=\"close text-white\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
										+ "          <span aria-hidden=\"true\">&times;</span>\r\n"
										+ "        </button>\r\n"
										+ "      </div>\r\n"
										+ "      <div class=\"modal-body\">\r\n"
										+ "        <form action=\"LoginAdminDashboard\" method=\"post\">\r\n"
										+ "				<div class=\"form-group\">\r\n"
										+ "					<label class = \"text-silver\">Name</label> \r\n");
													pw.print("<input type=\"text\" name =\"name\" class=\"form-control bg-transparent text-white\" required>\r\n");
													pw.print("</div>\r\n"
										+ "				<div class=\"form-group\">\r\n"
										+ "					<label class = \"text-silver\">Email</label> \r\n");
													pw.print("<input type=\"email\" name =\"email\" class=\"form-control bg-transparent text-white\" >\r\n");
													pw.print("</div>\r\n"
										+ "				<div class=\"form-group\">\r\n"
										+ "					<label class = \"text-silver\">Mobile</label> \r\n");
													pw.print("<input type=\"text\" name =\"mobile\" class=\"form-control bg-transparent text-white\" required>\r\n");
													pw.print("</div>\r\n"
										+ "				<div class=\"form-group\">\r\n"
										+ "					<label class = \"text-silver\">DOB</label> \r\n");
													pw.print("<input type=\"date\" name =\"dob\" class=\"form-control bg-transparent text-white\" required>\r\n");
													pw.print("</div>\r\n"
										+ "				<button type=\"submit\" class=\"btn btn-primary edit\">Update</button>\r\n"
										+ "			</form>\r\n"
										+ "      </div>\r\n"
										+ "    </div>\r\n"
										+ "  </div>\r\n"
										+ "</div>");
													
							
													
													
								// User table data
										pw.print("<div>"
										+ "      <h3>List of Users</h3>"
													
									+ "      </div>\r\n"
									+ "			<table class=\"table table-dark design text-center table-striped table-hover\">\r\n"
									+ "				<thead>\r\n"
									+ "					<tr>\r\n"
									+ "						<th scope=\"col\">S.No.</th>\r\n"
									+ "						<th scope=\"col\">Name</th>\r\n"
									+ "						<th scope=\"col\">Email</th>\r\n"
									+ "						<th scope=\"col\">Mobile</th>\r\n"
									+ "						<th scope=\"col\">Date of Birth</th>\r\n"
									+ "						<th scope=\"col\" colspan = 2>Action</th>\r\n"
									+ "					</tr>\r\n"
									+ "				</thead>\r\n"
									+ "				<tbody>\r\n");
									
									
									
									
//							Setting data into tabular format
							try {
									Connection conn= ConnectionPg.getConnection();
									PreparedStatement ps = conn.prepareStatement("select name, email, mobile, dob from signup where id = ? AND isadmin = ? AND issuperadmin = ?");
									int sno=1;
									int a;
									for (a = 1; a <= count; a++) {
										ps.setInt(1, a);
										ps.setBoolean(2, false);
										ps.setInt(3, 0);
										
										ResultSet rs = ps.executeQuery();
										while (rs.next()) {
											
											String name1 = rs.getString(1);
											String email1 = rs.getString(2);
											String mobile1 = rs.getString(3);
											String dob1 = rs.getString(4);
											
											pw.print("<tr>\r\n");
											
											pw.println("<th scope=\"row\">" + sno + "</th>\r\n");
											pw.print("<td>" + name1 + "</td>");
											pw.print("<td>" + email1 + "</td>");
											pw.print("<td>" + mobile1 + "</td>");
											pw.print("<td>" + dob1 + "</td>");
											pw.print("<td><form action ='UpdateUserBySuperAdminForm' method = 'post'><button type = 'submit' class = 'btn btn-primary'  value = \"+"+ a +"+\"+ name = 'update'>Update</button></form></td>");
											pw.print("<td><form action = 'DeleteUserBySuperAdmin' method = 'post'><button type = 'submit' class = 'btn btn-danger' value = '+"+ a +"+' name = 'delete'>Delete</button></form></td>");
											
											pw.print("</tr>\r\n");
											sno++;
										}	
										
									}
									
										pw.print("</tbody>\r\n"
									+ "			</table>\r\n");
												
													
												
											} catch (Exception e) {
												System.out.println(e);
											}
									
									pw.print("</div>\r\n"
									+ "	</div>\r\n"
									+ "</div>\r\n");
								
									pw.print("</body>\r\n"
											+ "</html>");	
		
								// Preventing from getting back to previous page
								pw.print("<script type = \"text/javascript\" >  \r\n"
										+ "    function preventBack() { window.history.forward(); }  \r\n"
										+ "    setTimeout(\"preventBack()\", 0);  \r\n"
										+ "    window.onunload = function () { null };  \r\n"
										+ "</script>");
				}
	



	}


