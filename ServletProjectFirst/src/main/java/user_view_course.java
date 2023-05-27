

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

/**
 * Servlet implementation class user_view_course
 */
@WebServlet("/user_view_course")
public class user_view_course extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");

		// load the JDBC driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generate the connection
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root"); PreparedStatement ps = con.prepareStatement("select * from course ");) {
			ResultSet rs = ps.executeQuery();
			pw.println("<html><head><link rel='stylesheet'     href= ' css.css'>");
			pw.println("	<style>div {" + "width:70%;" + " transform: perspective(1500px) rotateY(0deg); "

					+ "border-radius: 1rem;"

					+ " box-shadow: rgba(0, 0, 0, 0.25) 0px 25px 50px -12px;"

					+ " transition: transform 1s ease 0s;" + "" + " }}" + "" + "table{padding:20px;}" + "</style>");

			pw.println("<body ><br><br><br>");
			pw.print("<div class=\"split right\" style='float:center;  margin-left: 20%;'>\r\n");
			pw.println("<table class='table table-hover table-striped' style='border-spacing:20px;'>");
			// pw.println("course Details");
			pw.println("<center><h1><b>Course Details</b></h1></center>"
					+ "<tr> "+ "<th><center>Course_code</center></th>"
					+ "<th >Course_name</th>" + "</tr>");
			while (rs.next()) {
				pw.println("<tr>" +  "<td><center>" + rs.getString(2)
						+ "</center></td>" + "<td>" + rs.getString(3) + "</td></tr>");
				
				

			}
			pw.println("</table ></div>");
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}