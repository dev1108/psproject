

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Fetching data from login from
		String name = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		// Declared variable for storing data, fetched from database
		String name1 = null;
		String password1 = null;
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "admin";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			// Fetching data from database
			PreparedStatement ps = conn.prepareStatement("select name, password from signup where password = ?");
			
			ps.setString(1, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				name1 = rs.getString(1);
				password1 = rs.getString(2);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		// Checking data is valid or not && redirecting to user panel area
		if (name.equals(name1) && password.equals(password1)) {
			RequestDispatcher rd1 = request.getRequestDispatcher("LoginUserDashboard");
			rd1.forward(request, response);
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("LoginError");
			rd.forward(request, response);
		}
	}

}
