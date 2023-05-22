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

@WebServlet("/editurl")
public class edit_screen extends HttpServlet {
	private final static String query = "select name,email,mobile,dob,password from signup where id=?";

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
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
			pw.println("<form action='edit?id=" + id + "' method='post'>");
			pw.println("<table class='table table-hover table-striped'>");
			pw.println("<tr>");
			pw.println("<td>Name</td>");
			pw.println("<td><input type='text' name='name' value='" + rs.getString(1) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Email</td>");
			pw.println("<td><input type='email' name='email' value='" + rs.getString(2) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Mobile</td>");
			pw.println("<td><input type='text' name='mobile' value='" + rs.getString(3) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>DOB</td>");
			pw.println("<td><input type='date' name='dob' value='" + rs.getString(4) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Password</td>");
			pw.println("<td><input type='text' name='city' value='" + rs.getString(5) + "'></td>");
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
		pw.println("<a href='LoginUserDashboard'><buttonbutton class='btn btn-primary btn-xs btn3d'>Back</button></a>");
		pw.println("</div>");
		// close the stream
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
