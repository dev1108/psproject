
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterMsg
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		// Fetching data form sign up form

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mnumb");
		String dob = request.getParameter("dob");

		SignUpData sd1 = new SignUpData();

		sd1.setName(name);
		sd1.setPassword(password);
		sd1.setEmail(email);
		sd1.setMobile(mobile);
		sd1.setDob(dob);

		if (name != null && password != null) {
			try {
				String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
				String user = "postgres";
				String pass = "root";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user, pass);

				// Fetching max id from sign up table for auto increment id
				int count = 0;
				String query = "select max(id) as id from signup";
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					count = rs.getInt("id");
				}

				// Inserting data into database using prepared statement

				PreparedStatement ps = conn.prepareStatement("insert into signup values(?,?,?,?,?,?)");

				ps.setInt(1, ++count);
				ps.setString(2, sd1.getName());
				ps.setString(3, sd1.getPassword());
				ps.setString(4, sd1.getEmail());
				ps.setString(5, sd1.getMobile());
				ps.setString(6, sd1.getDob());
				int r = ps.executeUpdate();
				if (r > 0) {
					pw.println("done");
				} else {
					pw.println("not done");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		if (name != null && password != null) {
			RequestDispatcher rd2 = request.getRequestDispatcher("Login");
			rd2.forward(request, response);
			pw.print("<p style ='color: green'>You have successfully registered");
		} else {
			pw.print("<p style = 'color: red'>Some data are missing");
		}

	}

}