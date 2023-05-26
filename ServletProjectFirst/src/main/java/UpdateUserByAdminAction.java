

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class UpdateUserByAdminAction
 */
@WebServlet("/UpdateUserByAdminAction")
public class UpdateUserByAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int id =0;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String dob = request.getParameter("dob");
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "admin";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			PreparedStatement pstmt = conn.prepareStatement("select id dob from signup where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
			
			PreparedStatement ps = conn.prepareStatement("UPDATE signup SET name = ?, email = ?, mobile = ?, dob = ? WHERE id = ?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, dob);
			ps.setInt(5, id);
			int i = ps.executeUpdate();
			
			if (i > 0) {
				pw.print("	<div class=\"container\">\r\n"
						+ "		<div class=\"main-body\">\r\n"
						+ "			<div class=\"row\">\r\n"
						+ "				<div class=\"col-sm-12 mx-auto\">\r\n"
						+ "					<div class=\"alert alert-success shadow fade show\" role=\"alert\"\r\n"
						+ "						style=\"border-left: #155724 8px solid; border-radius: 10px\">\r\n"
						+ "						<button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
						+ "							aria-label=\"Close\">\r\n"
						+ "							<span aria-hidden=\"True\" style=\"color: #155724\">&times;</span>\r\n"
						+ "						</button>\r\n"
						+ "						<div class=\"row\">\r\n"
						+ "							<svg width=\"1.25em\" height=\"1.25em\" viewBox=\"0 0 16 16\"\r\n"
						+ "								class=\"m-1 bi bi-shield-fill-check\" fill=\"currentColor\"\r\n"
						+ "								xmlns=\"http://www.w3.org/2000/svg\">\r\n"
						+ "			  				<path fill-rule=\"evenodd\" d=\"M8 .5c-.662 0-1.77.249-2.813.525a61.11 61.11 0 0 0-2.772.815 1.454 1.454 0 0 0-1.003 1.184c-.573 4.197.756 7.307 2.368 9.365a11.192 11.192 0 0 0 2.417 2.3c.371.256.715.451 1.007.586.27.124.558.225.796.225s.527-.101.796-.225c.292-.135.636-.33 1.007-.586a11.191 11.191 0 0 0 2.418-2.3c1.611-2.058 2.94-5.168 2.367-9.365a1.454 1.454 0 0 0-1.003-1.184 61.09 61.09 0 0 0-2.772-.815C9.77.749 8.663.5 8 .5zm2.854 6.354a.5.5 0 0 0-.708-.708L7.5 8.793 6.354 7.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z\" />\r\n"
						+ "							</svg>\r\n"
						+ "							<p style=\"font-size: 18px\" class=\"mb-0 font-weight-light\">\r\n"
						+ "								<b class=\"mr-1\">Success!</b>Data updated successfully.\r\n"
						+ "							</p>\r\n"
						+ "						</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>");
				
				RequestDispatcher rd = request.getRequestDispatcher("LoginAdminDashboard");
				rd.include(request, response);
				
				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("LoginAdminDashboard");
				rd.forward(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
