
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterMsg
 */
@WebServlet("/RegisterMsg")
public class RegisterMsg extends HttpServlet {
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
		// Creating object of pojo class
		SignUpData sd1 = new SignUpData();
		// Passing data to pojo class parameterized constructor
//				new SignUpData(name, password, email, mobile, dob);

		// Inserting all the to pojo class
		sd1.setName(name);
		sd1.setPassword(password);
		sd1.setEmail(email);
		sd1.setMobile(mobile);
		sd1.setDob(dob);

		if (email != null && password != null) {
			try {
				String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
				String user = "postgres";
				String pass = "admin";
				Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection(url, user, pass);

				// Fetching all email from database and adding to the list
				List<String> lst = new LinkedList<>();
				
				Statement st = conn.createStatement();
				ResultSet rst = st.executeQuery("select email from signup");
				
				while (rst.next()) {
					lst.add(rst.getString("email"));
				}
				
				// Fetching max id from sign up table for auto increment id
				int count = 0;
				String query = "select max(id) as id from signup";
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					count = rs.getInt("id");
				}

				
				// Comparing email is present in the database or not
				for (String x : lst) {
					if (email.equals(x)) {
						RequestDispatcher rds = request.getRequestDispatcher("EmailValidation");
						rds.forward(request, response);
					}
				}
				// Inserting data into database using prepared statement
				PreparedStatement ps = conn.prepareStatement("insert into signup values(?,?,?,?,?,?,?)");
				ps.setInt(1, ++count);
				ps.setString(2, sd1.getName());
				ps.setString(3, sd1.getPassword());
				ps.setString(4, sd1.getEmail());
				ps.setString(5, sd1.getMobile());
				ps.setString(6, sd1.getDob());
				ps.setBoolean(7, false);
				ps.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		if (email != null && password != null) {
			RequestDispatcher rd2 = request.getRequestDispatcher("Login");
			rd2.forward(request, response);
		} else {
			pw.print("<p style = 'color: red'>Some data are missing");
		}

	}

}
