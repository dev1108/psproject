

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


@WebServlet("/view_users")
public class view_users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		pw.println("<html><head>"
				+ "<style>"
				+ "* {"
				+ "  box-sizing: border-box;\r\n"
				+ "}"
				+ "body {"
				+ "  font-family: Arial, Helvetica, sans-serif;"
				+ "  padding: 30px;"
				+ "}</style>");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
					"root");
					PreparedStatement ps = con
							.prepareStatement("select * from signup where isadmin='false'");
					ResultSet rs = ps.executeQuery();
					
					pw.println("<table class='table table-hover table-striped'>");
					pw.println("<h1><center><b>User Details<br></b></center></h1>");
					pw.println("<a href='Add'style='float:right;'"
							+ "'><button class='btn btn-primary btn-xs btn3d''>Add</button></a>");
					pw.println("<tr>");
					pw.println("<label for=\"staticEmail\" ><th>Name</label></th>");
					pw.println("<label for=\"staticEmail\" ><th>Email</label></th>");
					pw.println("<label for=\"staticEmail\" ><th>Mobile No</label></th>");
					pw.println("<th><label for=\"staticEmail\" >DOB</th></label>");
					pw.println("<th colspan='3'><label for=\"staticEmail\" >Password</label></th></tr>");
					while (rs.next()) {
					
					
				

					pw.println("<tr>");
					pw.println("<td><input type='text' name='uname' value=" + rs.getString(2)
							+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td>");
	
					pw.println("<td><input type='email' name='e' value=" + rs.getString(4)
							+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td>");
					
					pw.println("<td><input type='mobilenum' name='uname' value=" + rs.getString(5)
							+ " readonly class=\"form-control-plaintext\" id=\"staticEmail\"><br></td>");

				
					pw.println("<td><input type='date' name='uname' value=" + rs.getString(6)
							+ "readonly class=\"form-control-plaintext\" id=\"staticEmail\" ><br></td>");
					
					pw.println("<td>" + rs.getString(3)
					+ "<br></td>");
			
					pw.println("<td><a href='edituser?id=" + rs.getInt(1)
					+ "'><button class='btn btn-primary btn-xs btn3d''>Edit</button></a></td>");

			
					pw.println("<td><a href='deleteurl?id=" + rs.getInt(1)
							+ "'><button class='btn btn-danger btn-xs btn3d''>Delete</button></a></td></tr>");

					

				}
	}
	
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
	}

}
