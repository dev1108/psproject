

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class Add_User
 */
public class Add_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String query1 = "select max(id) as id from signup";
    private final static String query = "insert into signup (id,name,password,email,mobile,dob,isAdmin,issuperadmin)values(?,?,?,?,?,?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //link the bootstrap
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        //get the values
        String name = req.getParameter("uname");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        String dob = req.getParameter("dob");
        String mobile = req.getParameter("number");
        boolean admin=false;
        boolean sadmin=false;
        int c=0;
       
        //load the JDBC driver
        try {
            Class.forName("org.postgres.Driver");
        }catch(Exception e) {
            e.printStackTrace();
        }
        //load the JDBC driver
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root");){
        	Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(query1);
			while (rs.next()) {
				c = rs.getInt("id");
        	
			}
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignInSignUp", "postgres",
				"root"); PreparedStatement ps = con.prepareStatement(query);){
            //set the values
        	 ps.setInt(1, ++c);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, mobile);
            ps.setString(6, dob);
            ps.setBoolean(7, admin);
            ps.setBoolean(8, sadmin);
            
            //execute the query
            int count = ps.executeUpdate();
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Registered Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>");
            }
        }catch(SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='view_user'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        //close the stram
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}