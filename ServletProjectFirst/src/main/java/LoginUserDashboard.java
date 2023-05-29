

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

/**
 * Servlet implementation class LoginUserDashboard
 */
@WebServlet("/LoginUserDashboard")
public class LoginUserDashboard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// Getting email from login form
		String email = request.getParameter("email");
		// Getting user name form database
		String username = null;
		String emailid = null;
		String mobile = null;
		String dob = null;
		
		try {
			Connection conn = ConnectionPg.getConnection(); // Calling static getConnection method using class name
			
			PreparedStatement ps = conn.prepareStatement("select name, email, mobile, dob from signup where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				username = rs.getString(1);
				emailid = rs.getString(2);
				mobile = rs.getString(3);
				dob = rs.getString(4);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}

		
//		User Profile
		
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>User Dashboard</title>\r\n"
				+ "<script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<style>\r\n"
				+ "	body{\r\n"
//				+ "    margin-top:20px;\r\n"
				+ "    color: #e6edf3;\r\n"
				+ "    text-align: left;\r\n"
				+ "    background-color: #161b22;    \r\n"
				+ "}\r\n"
				+ ".main-body {\r\n"
				+ "    padding: 15px;\r\n"	
				+ "}\r\n"
				+ ".courseHead {\r\n"
				+ "    margin-top: -64px;\r\n"	
				+ "}\r\n"
				+ ".card {\r\n"
				+ "    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".card {\r\n"
				+ "    position: relative;\r\n"
				+ "    display: flex;\r\n"
				+ "    flex-direction: column;\r\n"
				+ "    min-width: 0;\r\n"
				+ "    word-wrap: break-word;\r\n"
				+ "    background-color: #21262d;\r\n"
				+ "    background-clip: border-box;\r\n"
				+ "    border: 0 solid rgba(0,0,0,.125);\r\n"
				+ "    border-radius: .25rem;\r\n"
				+ "    box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "}\r\n"
				+ ".logout{\r\n"
				+ "		width: 250px;\r\n"
				+ "		height: auto;\r\n"
				+ "		border: 1px solid silver;\r\n"
				+ "		border-radius: 20px;\r\n"
				+ "		background-color: transparent;\r\n"
				+ "		transition: 0.5s ease-out;\r\n"
				+ "}\r\n"
				+ ".edit{\r\n"
				+ "		width: 100%;\r\n"
				+ "		height: 40px;\r\n"
				+ "		border: 1px solid silver;\r\n"
				+ "		border-radius: 20px;\r\n"
				+ "		background-color: transparent;\r\n"
				+ "		transition: 0.5s ease-out;\r\n"
				+ "}\r\n"
				+ ".edit1{\r\n"
				+ "		width: 100%;\r\n"
				+ "		height: 40px;\r\n"
				+ "		border: 1px solid silver;\r\n"
				+ "		border-radius: 20px;\r\n"
				+ "		background-color: transparent;\r\n"
				+ "		transition: 0.5s ease-out;\r\n"
				+ "}\r\n"
				+ ".popup{\r\n"
				+ " 	background: transparent;\r\n"
				+ "		background-color: rgba(0, 10, 9, 0.78);\r\n"
				+ "		border-radius: 10px;\r\n"
				+ "		box-shadow: 5px 8px 15px silver inset;\r\n"
				+ "		padding: 20px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".head{\r\n"
				+ "		margin-top: 50px;\r\n"
				+ "}\r\n"
				+ ".card-body {\r\n"
				+ "    flex: 1 1 auto;\r\n"
				+ "    min-height: 1px;\r\n"
				+ "    padding: 1rem;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".gutters-sm {\r\n"
				+ "    margin-right: -8px;\r\n"
				+ "    margin-left: -8px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".gutters-sm>.col, .gutters-sm>[class*=col-] {\r\n"
				+ "    padding-right: 8px;\r\n"
				+ "    padding-left: 8px;\r\n"
				+ "}\r\n"
				+ ".mb-3, .my-3 {\r\n"
				+ "    margin-bottom: 1rem!important;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".bg-gray-300 {\r\n"
				+ "    background-color: #e2e8f0;\r\n"
				+ "}\r\n"
				+ ".h-100 {\r\n"
				+ "    height: 100%!important;\r\n"
				+ "}\r\n"
				+ ".shadow-none {\r\n"
				+ "    box-shadow: none!important;\r\n"
				+ "}\r\n"
				+ ".collBtn:hover{background-color: green;}\r\n"
				// courses style
				+ "#course {\r\n"
				+ "	font-family: Arial, Helvetica, sans-serif;\r\n"
				+ "	border-collapse: collapse;\r\n"
				+ "	width: 100%;\r\n"
				+ "	\r\n"
				+ "	background-color: transparent;\r\n"

				+ "}\r\n"
				+ "\r\n"
				+ "#course td, #course th {\r\n"
				+ "	border: 1px solid #21262d;\r\n"
				+ "	padding: 8px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "#course th {\r\n"
				+ "	padding-top: 12px;\r\n"
				+ "	padding-bottom: 12px;\r\n"
				+ "	text-align: left;\r\n"
				+ "	background-color: rgba(8, 215, 173, 0.18);\r\n"
				+ "	color: white;\r\n"
				+ "}\r\n"
				
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n");
				
//		Update pop up
		pw.print("<!-- Modal -->\r\n"
				+ "<div class=\"modal fade\" id=\"updateModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n"
				+ "  <div class=\"modal-dialog\" role=\"document\">\r\n"
				+ "    <div class=\"modal-content popup\">\r\n"
				+ "      <div class=\"modal-header\">\r\n"
				+ "        <h5 class=\"modal-title text-white\" id=\"exampleModalLabel\">Update Your Details</h5>\r\n"
				+ "        <button type=\"button\" class=\"close text-white\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
				+ "          <span aria-hidden=\"true\">&times;</span>\r\n"
				+ "        </button>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"modal-body\">\r\n"
				+ "        <form action=\"UpdateProfile\" method=\"post\">\r\n"
				+ "				<div class=\"form-group\">\r\n"
				+ "					<label class = \"text-silver\">Name</label> \r\n");
							pw.print("<input type=\"text\" name =\"name\" value = "+username +" class=\"form-control bg-transparent text-white\" required>\r\n");
							pw.print("</div>\r\n"
				+ "				<div class=\"form-group\">\r\n"
				+ "					<label class = \"text-silver\">Email</label> \r\n");
							pw.print("<input type=\"email\" name =\"email\" value = "+emailid+" class=\"form-control bg-transparent text-white\" readonly>\r\n");
							pw.print("</div>\r\n"
				+ "				<div class=\"form-group\">\r\n"
				+ "					<label class = \"text-silver\">Mobile</label> \r\n");
							pw.print("<input type=\"text\" name =\"mobile\" value = "+mobile+" class=\"form-control bg-transparent text-white\" required>\r\n");
							pw.print("</div>\r\n"
				+ "				<div class=\"form-group\">\r\n"
				+ "					<label class = \"text-silver\">DOB</label> \r\n");
							pw.print("<input type=\"date\" name =\"dob\" value = "+dob+" class=\"form-control bg-transparent text-white\" required>\r\n");
							pw.print("</div>\r\n"
				+ "				<button type=\"submit\" class=\"btn btn-primary edit\">Update</button>\r\n"
				+ "			</form>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</div>");
							

								
					
					/* User Profile Heading */	
		pw.print("	<div class=\"container\">\r\n"
				+ "    <div class=\"main-body\">\r\n"
				+ "    \r\n"
				+ "     <div class = \"row gutters-sm\">\r\n"
				+ "     	<div class = \"col-sm-12 mb-3\">\r\n"
				+ "     		<div class = \"card head\">\r\n"
				+ "     			<div class = \"card-body\">\r\n"
				+ "     				<div class = \"d-flex flex-column align-items-center text-center\">\r\n"
				+ "     					<h3>Your Profile</h3>\r\n"
				+ "     				</div>\r\n"
				+ "     			</div>\r\n"
				+ "     		</div>\r\n"
				+ "     	</div>\r\n"
				+ "     </div>\r\n"
				
				+ "          <!-- /Breadcrumb -->\r\n"
				+ "    \r\n"
				+ "          <div class=\"row gutters-sm\">\r\n"
				+ "            <div class=\"col-md-4\">\r\n"
				+ "              <div class=\"card p-1\">\r\n"
				+ "                <div class=\"card-body\">\r\n"
				+ "                  <div class=\"d-flex flex-column align-items-center text-center\">\r\n"
				+ "                    <img src=\"https://bootdey.com/img/Content/avatar/avatar7.png\" alt=\"Admin\" class=\"rounded-circle\" width=\"150\">\r\n"
				+ "                    <div class=\"mt-3\">\r\n");
								pw.print("<h4>"+username +"</h4>");
								pw.print("<p class=\"text-muted font-size-sm\">"+emailid+"</p>");									
								pw.print("<form action= 'Login' method = 'post'><button type = 'submit' class = \"btn btn-danger logout\" >Logout</button></form>\r\n"
				+ "                    </div>\r\n"
				+ "                  </div>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "              \r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-md-8\">\r\n"
				+ "         	\r\n"
				+ "              <div class=\"card p-2\">\r\n"
				+ "                <div class=\"card-body\">\r\n"
				+ "                  <div class=\"row\">\r\n"
				+ "                    <div class=\"col-sm-3\">\r\n"
				+ "                      <h6 class=\"mb-0\">Full Name</h6>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class=\"col-sm-9 text-secondary\">\r\n");
				                  pw.print(username);
				                  pw.print("</div>\r\n"
				+ "                  </div>\r\n"
				+ "                  <hr>\r\n"
				+ "                  <div class=\"row\">\r\n"
				+ "                    <div class=\"col-sm-3\">\r\n"
				+ "                      <h6 class=\"mb-0\">Email</h6>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class=\"col-sm-9 text-secondary\">\r\n");
									pw.print(emailid);
									pw.print("</div>\r\n"
				+ "                  </div>\r\n"
				+ "                  <hr>\r\n"
				+ "                  <div class=\"row\">\r\n"
				+ "                    <div class=\"col-sm-3\">\r\n"
				+ "                      <h6 class=\"mb-0\">Phone</h6>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class=\"col-sm-9 text-secondary\">\r\n");
									pw.print(mobile);
									pw.print("</div>\r\n"
				+ "                  </div>\r\n"
				+ "                  <hr>\r\n"
				+ "                  <div class=\"row\">\r\n"
				+ "                    <div class=\"col-sm-3\">\r\n"
				+ "                      <h6 class=\"mb-0\">Date of Birth</h6>\r\n"
				+ "                    </div>\r\n"
				+ "                    <div class=\"col-sm-9 text-secondary\">\r\n");
									pw.print(dob);
									pw.print("</div>\r\n"
				+ "                  </div>\r\n"
				+ "                 <hr>\r\n"
				+ "                  <div class=\"row\">\r\n"
				+ "                    <div class=\"col-sm-12 d-flex\">\r\n"
				+ "                      <button type = 'button' class = \"btn btn-primary edit mr-2\" data-toggle=\"modal\" data-target=\"#updateModal\" >Edit Profile</button>\r\n");

				                pw.print("</div>\r\n"
				+ "                  </div>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n");
				
//				Courses heading
				pw.print("	<div class=\"container\">\r\n"
						+ "    <div class=\"main-body courseHead\">\r\n"
						+ "    \r\n"
						+ "     <div class = \"row gutters-sm\">\r\n"
						+ "     	<div class = \"col-sm-12 mb-3\">\r\n"
						+ "     		<div class = \"card head\">\r\n"
						+ "     			<div class = \"card-body\">\r\n"
						+ "     				<div class = \"d-flex flex-column align-items-center text-center\">\r\n"
						+ "     					<h3>Your Courses</h3>\r\n"
						+ "     				</div>\r\n"
						+ "     			</div>\r\n"
						+ "     		</div>\r\n"
						+ "     	</div>\r\n"
						+ "     </div>\r\n");
				
				
			// User courses list
				
				
				pw.print("<div class=\"accordion\" id=\"accordionExample\">\r\n"
						+ "  <div class=\"card\">\r\n"
						+ "    <div class=\"card-header\" id=\"headingOne\">\r\n"
						+ "      <h2 class=\"mb-0\">\r\n"
						+ "        <button class=\"btn btn-link collapsed text-white text-decoration-none collBtn\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseOne\" aria-expanded=\"false\" aria-controls=\"collapseOne\">\r\n"
						+ "          View Your Course\r\n"
						+ "        </button>\r\n"
						+ "      </h2>\r\n"
						+ "    </div>\r\n"
						+ "\r\n"
						+ "    <div id=\"collapseOne\" class=\"collapse multi-collapse\" aria-labelledby=\"headingOne\" data-parent=\"#accordionExample\">\r\n"
						+ "      <div class=\"card-body\">\r\n");
				
				pw.print("\r\n"
						+ "		<table id=\"course\">\r\n"
						+ "			<tr>\r\n"
						+ "				<th>S.No.</th>\r\n"
						+ "				<th>Courses</th>\r\n"
						
						+ "			</tr>\r\n");
						
				try {
					String[] course = null;
						Connection conn = ConnectionPg.getConnection();
						PreparedStatement pst = conn.prepareStatement("select course_name from signup where email = ?");
						

							pst.setString(1, email);
							ResultSet rs = pst.executeQuery();
							
							
							while (rs.next()) {
								Array c = rs.getArray("course_name");
								course = (String[]) c.getArray();
																  
								  int sno = 1;		  
								  for (String x : course) {
									  pw.print("<tr>\r\n");
									  	pw.print("<td>"+sno+"</td>\r\n");
										pw.print("<td>"+x+"</td>\r\n");
										sno++;
										
									  pw.print("</tr>\r\n");
									}								  
								
							}
				
				}catch(Exception e) {
					System.out.println(e);
				}
				
				pw.print("			\r\n"
						+ "\r\n"
						+ "		</table>\r\n");
				
						pw.print("</div>\r\n"
						+ "    </div>\r\n"
						+ "  </div></div>");		
				
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

