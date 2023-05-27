

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
 * Servlet implementation class edit_admin_screen
 */
@WebServlet("/edit_admin_screen")
public class edit_admin_screen extends HttpServlet {
	private final static String query = "select id,name,password,email,mobile,dob from signup where id=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");

		// get the id
		// get the values
		int id = Integer.parseInt(req.getParameter("id"));
		// link the bootstrap
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generate the connection
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root"); PreparedStatement ps = con.prepareStatement(query);) {
			// set value
			ps.setInt(1, id);
			// resultSet
			
			pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
			pw.println("<form action='edit_admin?id=" + id + "' method='post'>");
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<table class='table table-hover table-striped' style='border-spacing:20px;'>");
			pw.println("<tr>");
			pw.println("<td>Name</td>");
			pw.println("<td><input type='text' name='name' value='" + rs.getString(2) + "'><br><br></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Email</td>");
			pw.println("<td><input type='email' name='email' value='" + rs.getString(4) + "'><br><br></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Mobile</td>");
			pw.println("<td><input type='text' name='mobile' value='" + rs.getString(5) + "'><br><br></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>DOB</td>");
			pw.println("<td><input type='date' name='dob' value='" + rs.getString(6) + "'><br><br></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Password</td>");
			pw.println("<td><input type='text' name='pass' value='" + rs.getString(3) + "'><br><br></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<tr>");
			pw.println("<td><button type='submit' class=button class='btn btn-sucess btn-xs btn3d'>Edit</button></td>");
			pw.println(
					"<td><button type='reset' class=button class='btn btn-danger btn-xs btn3d'>Cancel</button></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
			
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='book'><buttonbutton class='btn btn-primary btn-xs btn3d'>Back</button></a>");
		pw.println("</div>");
		// close the stream
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
