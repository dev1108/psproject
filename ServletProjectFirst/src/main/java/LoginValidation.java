
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

@WebServlet("/LoginValidation")

public class LoginValidation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Fetching data from login from
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		// Declared variable for storing data, fetched from database
		
		
		String email1 = null;
		String password1 = null;
		boolean admin = false;
		boolean sadmin = false;
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "root";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);

			// Fetching data from database
			PreparedStatement ps = conn.prepareStatement("select email, password,isadmin, issuperadmin from signup where email = ?");

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				email1 = rs.getString(1);
				password1 = rs.getString(2);
				admin = rs.getBoolean(3);
				sadmin = rs.getBoolean(4);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		// Checking data is valid or not && redirecting to user panel area
		
		
		if (email.equals(email1) && password.equals(password1)&& admin==false && sadmin==false) {
			RequestDispatcher rd1 = request.getRequestDispatcher("LoginUserDashboard");
			rd1.forward(request, response);
		} 
		
		else if (email.equals(email1) && password.equals(password1) && admin == true && sadmin==false){
			RequestDispatcher rd3 = request.getRequestDispatcher("LoginAdminDashboard");
			rd3.forward(request, response);
		}
		else if (email.equals(email1) && password.equals(password1) &&admin==false&& sadmin==true) {
			RequestDispatcher rd1 = request.getRequestDispatcher("super_admin");
			rd1.forward(request, response);
		} 
		
		else {

			RequestDispatcher rd = request.getRequestDispatcher("LoginError");
			rd.forward(request, response);
		}
	}

}
