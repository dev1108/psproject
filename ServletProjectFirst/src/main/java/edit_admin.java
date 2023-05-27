import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit_admin")
public class edit_admin extends HttpServlet {
	private final static String query = "update signup set name=?,email=?,mobile=?,dob=?,password=? where id=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set content type
		res.setContentType("text/html");
		// link the bootstrap
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		// get the values
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String dob = req.getParameter("dob");
		String password = req.getParameter("pass");
		
		pw.print("<script type = \"text/javascript\" >  \r\n"
				+ "    function preventBack() { window.history.forward(); }  \r\n"
				+ "    setTimeout(\"preventBack()\", 0);  \r\n"
				+ "    window.onunload = function () { null };  \r\n" + "</script>");
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
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, dob);
			ps.setString(5, password);
			ps.setInt(6, id);
			// execute the query
			int count = ps.executeUpdate();
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			if (count == 1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Edited Successfully</h2>");
				RequestDispatcher rd1 = req.getRequestDispatcher("view_admin");
				rd1.include(req, res);
			} else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Edited</h2>");
				RequestDispatcher rd1 = req.getRequestDispatcher("view_admin");
				rd1.include(req, res);
			}
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		pw.println("</div>");

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}