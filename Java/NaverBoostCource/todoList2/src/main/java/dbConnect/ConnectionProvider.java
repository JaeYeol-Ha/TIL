package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false";
	private static String username = "connectuser";
	private static String password = "connect123!@#";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(dburl, username, password);
	}
}
