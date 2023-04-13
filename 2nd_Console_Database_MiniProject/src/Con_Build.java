import java.sql.Connection;
import java.sql.DriverManager;

public class Con_Build {
	
	static Connection con;
	
	public static Connection createCon() {
		
		try {
			// Load a Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
		
	}
}
