

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserBySuperAdmin
 */
@WebServlet("/DeleteUserBySuperAdmin")
public class DeleteUserBySuperAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// Getting id from admin dash board 
		String deleteId = request.getParameter("delete");
		deleteId = deleteId.substring(1, deleteId.length()-1);
		int d = Integer.parseInt(deleteId);
		response.setContentType("text/html");
//		pw.print(deleteId);
		

		try {
			
			Connection conn = ConnectionPg.getConnection(); // Calling static getConnection method using class name
			
			PreparedStatement pstmt = conn.prepareStatement("delete from signup where id = ?");
			pstmt.setInt(1, d);
			int status = pstmt.executeUpdate();
			
			if (status > 0 ) {
				pw.print("	<div class=\"container\">\r\n"
						+ "		<div class=\"main-body\">\r\n"
						+ "			<div class=\"row\">\r\n"
						+ "				<div class=\"col-sm-12 mx-auto\">\r\n"
						+ "					<div class=\"alert alert-danger shadow fade show\" role=\"alert\"\r\n"
						+ "						style=\"border-left: darkred 8px solid; border-radius: 10px\">\r\n"
						+ "						<button type=\"button\" class=\"close\" data-dismiss=\"alert\"\r\n"
						+ "							aria-label=\"Close\">\r\n"
						+ "							<span aria-hidden=\"True\" style=\"color: darkred\">&times;</span>\r\n"
						+ "						</button>\r\n"
						+ "						<div class=\"row\">\r\n"
						+ "							<svg width=\"1.25em\" height=\"1.25em\" viewBox=\"0 0 16 16\"\r\n"
						+ "								class=\"m-1 bi bi-shield-fill-check\" fill=\"currentColor\"\r\n"
						+ "								xmlns=\"http://www.w3.org/2000/svg\">\r\n"
						+ "			  				<path fill-rule=\"evenodd\" d=\"M8 .5c-.662 0-1.77.249-2.813.525a61.11 61.11 0 0 0-2.772.815 1.454 1.454 0 0 0-1.003 1.184c-.573 4.197.756 7.307 2.368 9.365a11.192 11.192 0 0 0 2.417 2.3c.371.256.715.451 1.007.586.27.124.558.225.796.225s.527-.101.796-.225c.292-.135.636-.33 1.007-.586a11.191 11.191 0 0 0 2.418-2.3c1.611-2.058 2.94-5.168 2.367-9.365a1.454 1.454 0 0 0-1.003-1.184 61.09 61.09 0 0 0-2.772-.815C9.77.749 8.663.5 8 .5zm2.854 6.354a.5.5 0 0 0-.708-.708L7.5 8.793 6.354 7.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z\" />\r\n"
						+ "							</svg>\r\n"
						+ "							<p style=\"font-size: 18px\" class=\"mb-0 font-weight-light\">\r\n"
						+ "								<b class=\"mr-1\">Danger!</b>User has been deleted successfully.\r\n"
						+ "							</p>\r\n"
						+ "						</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>");
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuperAdminDashboard");
				rd.include(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
}

}

