import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBOperation {
	
	private static Connection con=null;
	private final String insertSql = "insert into test_git (name, email, mobile_no) values (?,?,?)";
	protected void insertNewUser(NewUser n)  {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
			System.out.println("Connection:- "+con);
			PreparedStatement p1 = con.prepareStatement(insertSql);
			p1.setString(1, n.getName());
			p1.setString(2, n.getEmail());
			p1.setString(3, n.getMobile_number());
			System.out.println(n);
			p1.executeUpdate();
			System.out.println("User Insert" + n);
			con.close();
		} catch (Exception e) {
			System.out.println("Error:  ------>>>>>> "+e);
		}
	}
}
