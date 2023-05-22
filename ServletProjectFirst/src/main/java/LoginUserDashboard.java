import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginUserDashboard")

public class LoginUserDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		// load the JDBC driver
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generate the connection
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root");
				PreparedStatement ps = con
						.prepareStatement("select id,name,email,mobile,dob,password from signup where email=? ");) {
			// resultSet
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			pw.println("<html><head><link rel='stylesheet'     href= ' css.css'>");
			pw.println("	<style>div { transform: perspective(1500px) rotateY(0deg); "

					+ "border-radius: 1rem;"

					+ " box-shadow: rgba(0, 0, 0, 0.25) 0px 25px 50px -12px;"

					+ " transition: transform 1s ease 0s;" + "" + " }}</style>");

			pw.println("<body >");

			// Preventing from getting back to previous page
			pw.print("<script type = \"text/javascript\" >  \r\n"
					+ "    function preventBack() { window.history.forward(); }  \r\n"
					+ "    setTimeout(\"preventBack()\", 0);  \r\n"
					+ "    window.onunload = function () { null };  \r\n" + "</script>");

			pw.print("<center><h1><b>Welcome to User Management System<b></h1><br><br><br>");

			while (rs.next()) {
				pw.print("<div class=\"split left\"style='float:left;  margin-left:406.0000022px;\r\n" + "'>\r\n"
						+ "  <div class=\"centered\"><br> <center>" + "<img src=\"e.jpg\"><br><br>" + rs.getString(2)
						+ "		 <br>	"

						+ "<br><center><form action= 'Login' method = 'post'>"

						+ "<button type = 'submit' button class='btn btn-danger btn-xs btn3d' >Logout</button><br><br><br><br>	</form>");
				pw.print("</div></div>");

				pw.print("<div class=\"split right\" style='float:right;  margin-right: 31%;'>\r\n"
						+ "  <div class=\"centered\">");
				pw.println("<table class='table table-hover table-striped'>");
				pw.println("User Details<br>");
				pw.println("<tr><th>ID</th>");
				pw.println("<td> <input type='number' name='id' value=" + rs.getString(1) + " ><br></td></tr>");
				pw.println("<tr><th>Name</th>");
				pw.println("<td><input type='text' name='uname' value=" + rs.getString(2) + " ><br></td></tr>");
				pw.println("<tr><th>Email</th>");
				pw.println("<td><input type='email' name='e' value=" + rs.getString(3) + " ><br></td></tr>");
				pw.println("<tr><th>Mobile No</th>");
				pw.println("<td><input type='mobilenum' name='uname' value=" + rs.getString(4) + " ><br></td></tr>");
				pw.println("<tr><th>DOB</th>");
				pw.println("<td><input type='date' name='uname' value=" + rs.getString(5) + " ><br></td></tr>");
				pw.println("<tr><th>Password</th>");
				pw.println("<td><input type='text' name='uname' value=" + rs.getString(6) + " ><br></td></tr>");
				pw.println("<tr>");
				pw.println("<td><a href='editurl?id=" + rs.getInt(1)
						+ "'><button class='btn btn-primary btn-xs btn3d''>Edit</button></a></td>");
				pw.println("<td><a href='deleteurl?id=" + rs.getInt(1)
						+ "'><button class='btn btn-danger btn-xs btn3d''>Delete</button></a></td></tr>");

				pw.println("<tr>");
				pw.println("<td></td>");
				pw.println("<td></td>");

			}
			pw.println("</table>");
			pw.print("</div></div>\r\n");

		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
