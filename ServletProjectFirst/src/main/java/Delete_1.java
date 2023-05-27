
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteurl1")
public class Delete_1 extends HttpServlet {
	private final static String query = "delete from course where id = ?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		int id = Integer.parseInt(req.getParameter("id"));
		// load the JDBC driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generate the connection
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root"); PreparedStatement ps = con.prepareStatement(query);) {
			// set the values
			ps.setInt(1, id);
			// execute the query
			int count = ps.executeUpdate();
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			if (count == 1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Deleted Successfully</h2>");
			} else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
			}
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='book'><button class=button class='btn btn-primary btn-xs btn3d'>Home</button></a>");

		pw.println("</div>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
