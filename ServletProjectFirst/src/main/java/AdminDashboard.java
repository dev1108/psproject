

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


 
@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter pw = response.getWriter();
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
        	String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "SYSTEM";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);

			PreparedStatement ps = conn.prepareStatement("select * from signup");
            ResultSet rs = ps.executeQuery();  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Name</th><th>Password</th><th>Email</th><th>Mobile</th><th>Date Of Birth</th></tr>");
            	
            while (rs.next()) 
            {  
                String n = rs.getString("name");  
                String o=rs.getString("password");  
                String p=rs.getString("email");   
                String q=rs.getString("mobile");
                String r=rs.getString("dob");
                
                out.println("<tr><td>" + n + "</td><td>" + o + "</td><td>" + p + "</td><td>"+ q+"</td><td>"+ r +"</td></</tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            conn.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
    }  

	}


