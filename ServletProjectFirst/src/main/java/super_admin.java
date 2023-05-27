

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/super_admin")
public class super_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
			
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres","root");
		
				PreparedStatement ps = con.prepareStatement("select id,name,email,mobile,dob,password from signup where email=? ");
			// resultSet
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			
			pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
			
			pw.println("<html><head>"
					+ "<style>"
					+ "* {"
					+ "  box-sizing: border-box;\r\n"
					+ "}"
					+ "body {"
					+ "  font-family: Arial, Helvetica, sans-serif;"
					+ "  padding: 30px;"
					+ "}"
					
					
					+ "/* Style the header */"
					+ "header {"
					+ "  background-color: #87CEEB;"
					+ "  padding: 10px;"
					+ "  text-align: center;"
					+ "  font-size: 35px;"
					+ "  color: white;"
					+ "}"
					+ "/* Create two columns/boxes that floats next to each other */"
					+ "nav {"
					+ "  float: left;"
					+ "  width: 15%;"
					+ "  height: 500px;"
					+ " /* only for demonstration, should be removed */"
					+ "  background: #ccc;"
					+"padding-top:none;"
					+ "  padding: 20px;"
					+ "}"
					+ "/* Style the list inside the menu */"
					+ "nav ul {"
					+ "  list-style-type: none;"
					+ "  padding: 0;"
					+ "}"
					+ ""
					+ "article {"
					+ "  float: left;"
					+ "  padding: 20px;"
					+ "  width: 100%;"
					+ "  background-color: #f1f1f1;"
					+ "  height: 600px; "
					+ "}"
					+ ""
					
					+ "section::after {"
					+ "  content: \"\";"
					+ "  display: table;"
					+ "  clear: both;"
					+ "}"
					
					+ ""
					+ "@media (max-width: 600px) {"
					+ "  nav, article {"
					+ "    width: 100%;"
					+ "    height: auto;"
					+ "  }"
					+ "}"
					
					
					+"header,section,article{"
					+ " perspective(800px)\r\n"
					+ "    rotateY(-8deg);\r\n"
					+ "  transition: transform 1s ease 0s;\r\n"
					+ "  border-radius: 4px;\r\n"
					+ "  box-shadow:\r\n"
					+ "    rgba(0, 0, 0, 0.024) 0px 0px 0px 1px,\r\n"
					+ "    rgba(0, 0, 0, 0.05) 0px 1px 0px 0px,\r\n"
					+ "    rgba(0, 0, 0, 0.03) 0px 0px 8px 0px,\r\n"
					+ "    rgba(0, 0, 0, 0.1) 0px 20px 30px 0px;\r\n"
					+ ""
					+ "}"
					+ ""
					+ ""
					+ "/* unvisited link */"
					+ "a:link {"
					+ "  color: red;"
					+ "}"
					+ ""
					+ "/* visited link */"
					+ "a:visited {"
					+ "  color: green;"
					+ "}"
					+ "/* mouse over link */"
					+ "a:hover {"
					+ "  color: hotpink;"
					+ "}"
					+ "/* selected link */"
					+ "a:active {"
					+ "  color: blue;"
					+ "}"
					+ ""
					
					+ "}"
					+ "</style>"
					
						
					+ "</head>"
					
					+ "<body>"
					+ "<header>"
					+"<b>ADMIN</b>"
					+ "<a href='login'style='float:right;'><button class='btn btn-danger btn-xs btn3d''>Logout</button></a>"
					+ "</header>"
					+ ""
					+ "<section>"
					
					+ "  <article>"
					+ "  <p style='float:left;'><img src=\"e.jpg\"width=\"150\" height=\"150\"></p>  ");
			
			
			
			pw.println("<table class='table table-hover table-striped' style='float:center;width:70%;  margin-left:40px;'>");
			while (rs.next()) {

				pw.println("<tr><label for=\"staticEmail\" ><th>Name</label></th>");
				pw.println("<td><input type='text' name='uname' value=" + rs.getString(2)
						+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td></tr>");

				pw.println("<tr><label for=\"staticEmail\" ><th>Email</label></th>");
				pw.println("<td><input type='email' name='email' value=" + rs.getString(3)
						+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td></tr>");

				pw.println("<tr><label for=\"staticEmail\" ><th>Mobile No</label></th>");
				pw.println("<td><input type='mobilenum' name='uname' value=" + rs.getString(4)
						+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td></tr>");

				pw.println("<tr><th><label for=\"staticEmail\" >DOB</th></label>");
				pw.println("<td><input type='date' name='uname' value=" + rs.getDate(5)
						+ "readonly class=\"form-control-plaintext\" id=\"staticEmail\" ><br></td></tr>");
				
				pw.println("<tr><th>Password</th>");
				pw.println("<td>"+ rs.getString(6)
				+ "<br></td></tr>");

				pw.println("<tr>");
				pw.println("<td><a href='edit_admin?id="+rs.getInt(1)+"'><button class='btn btn-primary btn-xs btn3d''>Edit</button></a></td>");

				pw.println("<td><a href='admin_delete?id=" + rs.getInt(1)
						+ "'><button class='btn btn-danger btn-xs btn3d''>Delete</button></a></td></tr>");

				pw.println("<tr>");
				pw.println("<td></td>");
				pw.println("<td></td>");
			}
			
			pw.println( "  </article>"
					+ "  <nav style='float:right;'>"
					+ "    <ul>"
					+ "      <li><a href=\"book\"><b>View Course</b></a></li>"
					+ "			<li><a href=\"view_admin\"><b>View Admin</b></a></li>"
					+ "      <li><a href=\"view_users\"><b>View users</b></a></li>"
					+ "    </ul>"
					+ "  </nav>"
					
					
					+ "</section>"
					+ ""
					+ ""
					+ ""
					+ "</body></html>");
			

			} catch (SQLException se) {
				pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		doGet(request, response);
	}

}
