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
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String id=request.getParameter("update");
	out.print(id);
	//PrintWriter out = response.getWriter(); 
		
   response.setContentType("text/html");
		//String email = request.getParameter("email");
 String username=null;
 String emailid=null;
 String mobile=null;
 String dob=null;
 
 
	
	//int id=0;

		
     try{  
    		String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "SYSTEM";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
 
           
        // PreparedStatement ps = conn.prepareStatement(" update set name=?,email=?,mobile=?,dob where email=?");  
        // ResultSet rs = ps.executeQuery();
        
         
			PreparedStatement ps = conn.prepareStatement("select name, email, mobile, dob from signup where id = ?");
	//		ps.setString(1, email);
			ResultSet rs = ps.executeQuery();


			

			while (rs.next()) {
              username = rs.getString(1);
                emailid = rs.getString(2);
				mobile = rs.getString(3);
				dob = rs.getString(4);
				
				
			}}
			
//PreparedStatement pss = conn.prepareStatement("UPDATE signup SET name = ?, email = ?, mobile = ?, dob = ? WHERE id = ?");
			
			//pss.setString(1, username);
			//pss.setString(2, emailid);
			//pss.setString(3, mobile);
			//pss.setString(4, dob);
			//pss.setInt(5, id);
			//int i = ps.executeUpdate();
			//}
     
		catch(Exception e) {

           
                  //{  
           //String n = rs.getString("name");  
            // String o=rs.getString("password");  
             //String p=rs.getString("email");   
             //String q=rs.getString("mobile");
             //String r=rs.getString("dob");
  
           
           out.println("<!doctype>");
           out.println("<html>");
           out.println("<title>");
           out.println("</title>");
           out.println("<head>");
           out.println("</head>");
           out.println("<body>");
             
            out.println("<h1>Update Employee</h1>");  
             
             //int id=Integer.parseInt(sid);  
               
            // SignUpData  e=SignUpData.get(email);  
               
            // out.print("<form action='EditServlet2' method='post'>");
             out.print("<table>");  
            // out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
             out.print("<tr><td>Name:</td><td><input type='text' name='name' value="+username+"></td></tr>");  
              
             out.print("<tr><td>Email:</td><td><input type='email' name='emailid' value='"+emailid+"'/></td></tr>");  
             out.print("<tr><td>Mobile:</td><td><input type='text' name='mobile' value='"+mobile+"'/></td></tr>");
             out.print("<tr><td>Date of Birth:</td><td><input type='date' name='dob' value='"+dob+"'/></td></tr>");
              
             out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
             out.print("</table>");  
       //      out.print("</form>");  
             out.println("</body>");
             out.println("<html>");
             
             out.close();  
         }  
}}
       