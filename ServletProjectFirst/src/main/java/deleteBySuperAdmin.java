

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

/**
 * Servlet implementation class deleteBySuperAdmin
 */
@WebServlet("/deleteBySuperAdmin")
public class deleteBySuperAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String query = "delete from signup where id = ?";

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// get PrintWriter
				PrintWriter pw = res.getWriter();
				// set content type
				res.setContentType("text/html");
				pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
				int id = Integer.parseInt(req.getParameter("id"));
				// load the JDBC driver
				
				
				pw.print("<script type = \"text/javascript\" >  \r\n"
						+ "    function preventBack() { window.history.forward(); }  \r\n"
						+ "    setTimeout(\"preventBack()\", 0);  \r\n"
						+ "    window.onunload = function () { null };  \r\n" + "</script>");
				
				
				
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
						RequestDispatcher rd1 = req.getRequestDispatcher("view_admin");
						rd1.include(req, res);
					} else {
						pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
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
