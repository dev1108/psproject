import java.sql.*;
import java.sql.DriverManager;

public class ConnectionPg {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:postgresql://localhost:5432/SignInSignUp";
			String user = "postgres";
			String pass = "admin";
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}