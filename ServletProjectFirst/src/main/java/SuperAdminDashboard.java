

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SuperAdminDashboard")
public class SuperAdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		// out.println("<html><body>");
		int count=0;
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "SYSTEM";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
            Statement s1=conn. createStatement();
            
            ResultSet rs1=s1.executeQuery("select max(id) as id from signup");
            
			PreparedStatement ps = conn.prepareStatement("select * from signup where isadmin=false");
			ResultSet rs = ps.executeQuery();
			
			while(rs1.next())
			{
				count=rs1.getInt(1);
			}
			
			
			
			// while(rs.next())
			// {
			// String n = rs.getString("name");
			// String o= rs.getString("password");
			// String p = rs.getString("email");
			// String q=rs.getString("mobile");
			// String r=rs.getString("dob");
			// }
			// }
			// catch(Exception e)
			// {

			// System.out.println(e);
			// }

			System.out.println("hii");
			pw.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n" + "<script\r\n"
					+ "	src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\r\n"
					+ "	integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<script\r\n"
					+ "	src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\r\n"
					+ "	integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<script\r\n"
					+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js\"\r\n"
					+ "	integrity=\"sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n" + "<link rel=\"stylesheet\"\r\n"
					+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\"\r\n"
					+ "	integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\"\r\n"
					+ "	crossorigin=\"anonymous\">\r\n" + "	<style>\r\n" + "		body{\r\n"
					+ "			background-color: #161b22;\r\n" + "		}\r\n" + "		.logout{\r\n"
					+ "			margin-left: 550px;\r\n" + "		}\r\n" + "	</style>\r\n" + "</head>\r\n"
					+ "<body>\r\n" + "	<div class=\"container\">\r\n" + "		<div class=\"row\">\r\n"
					+ "			<div class=\"col-md-12 mx-auto\">\r\n"
					+ "				<div class = \"jumbotron bg-dark mx-auto text-white mt-3 d-flex\">\r\n"
					+ "					<h2>Welcome to super admin!</h2>\r\n");
					pw.print("<form action=\"Login\" method=\"post\">"
					+ "					<button type = \"submit\" class = \"btn btn-danger logout\">Logout</button></form>\r\n"
					+ "				</div>\r\n" + "<table class=\"table table-dark text-center\">\r\n"

					+ "					<thead>\r\n" + "						<tr>\r\n"
					+ "							<th scope=\"col\">S.No</th>\r\n"
					+ "							<th scope=\"col\">Name</th>\r\n"
					+ "							<th scope=\"col\">Email</th>\r\n"
					+ "							<th scope=\"col\">Mobile</th>\r\n"
					+ "							<th scope=\"col\">Date of Birth</th>\r\n"
					+ "							<th colspan=\"2\">Action</th>\r\n" + "\r\n"
					+ "							</th>\r\n"

					+ "						</tr>\r\n" + "					</thead>\r\n"
					+ "					<tbody>\r\n");
					
					for(int a=1;a<=count;a++)
					{
			while (rs.next()) {
				int id=rs.getInt(1);
				String n = rs.getString("name");
				// String o= rs.getString("password");
				String p = rs.getString("email");
				String q = rs.getString("mobile");
				String r = rs.getString("dob");

				pw.print("<tr>\r\n");

						//+ "<th scope=\"row\">1</th>\r\n");
				pw.println("<td>" + n + "</td>");
				pw.println("<td>" + p + "</td>\r\n" + "		"
						+ "<td>" + q + "</td>\r\n"
						+ "	<td>" + r + "</td>\r\n");
						pw.print("<form action=\"UpdateUser\" method=\"post\">"
						+ "	<td><button type=\"submit\" class=\"btn btn-primary\"name=\"update\" value="+ a +">Update</button></form></td>\r\n"
						+ "	<td><button type=\"submit\" class=\"btn btn-danger\">Delete</button></td>\r\n"
						+ "	<td></td>\r\n" 
						+ "	</tr>\r\n");

			}
		}

		}catch (Exception e) {

			System.out.println(e);
		}

		pw.print("</tbody>\r\n"

				+ "</table>\r\n" 
				+ "	</div>\r\n" 
				+ "	</div>\r\n" 
				+ "	</div>\r\n"
				+ "</body>\r\n" 
				+ "</html>");
	}
} // }
	// }
	// catch(Exception e)
	// {

// System.out.println(e);
// }
// }
//}
