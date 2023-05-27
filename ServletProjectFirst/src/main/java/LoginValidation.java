

import java.io.IOException;
import java.sql.Connection;
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
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		
		// Declared variable for storing data, fetched from database
		String email1 = null;
		String password1 = null;
		boolean admin = false;
		int superAdmin = 0;
		try {
			Connection conn = ConnectionPg.getConnection(); // Calling static getConnection method using class name
			
			// Fetching data from database
			PreparedStatement ps = conn.prepareStatement("select email, password, isadmin, issuperadmin from signup where email = ?");
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				email1 = rs.getString(1);
				password1 = rs.getString(2);
				admin = rs.getBoolean(3);
				superAdmin = rs.getInt(4);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		// Checking data is valid or not && redirecting to user panel area
		if (email.equals(email1) && password.equals(password1) && admin == false && superAdmin == 0) {
			RequestDispatcher rd1 = request.getRequestDispatcher("LoginUserDashboard");
			rd1.forward(request, response);
		}
		else if (email.equals(email1) && password.equals(password1) && admin == true && superAdmin == 0){
			RequestDispatcher rd3 = request.getRequestDispatcher("LoginAdminDashboard");
			rd3.include(request, response);
		}
		else if (email.equals(email1) && password.equals(password1) && admin == false && superAdmin == 1){
			RequestDispatcher rd3 = request.getRequestDispatcher("LoginSuperAdminDashboard");
			rd3.include(request, response);
		}
		else {
			
			RequestDispatcher rd = request.getRequestDispatcher("LoginError");
			rd.forward(request, response);
		}
	}

}
